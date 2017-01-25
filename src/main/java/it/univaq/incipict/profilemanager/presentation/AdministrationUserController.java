/*
 * Profile Manager - Copyright (C) 2016  Daniele Tellina
 *
 * Profile Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * Profile Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with Profile Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.univaq.incipict.profilemanager.presentation;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.RoleService;
import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.Role;
import it.univaq.incipict.profilemanager.business.model.User;
import it.univaq.incipict.profilemanager.common.spring.security.AuthenticationHolder;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
@Controller
@RequestMapping("/administration/user")
public class AdministrationUserController {

   @Autowired
   private UserService userService;

   @Autowired
   private RoleService roleService;
   
   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
      binder.registerCustomEditor(Role.class, "roles", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) {
            Role role = roleService.findByPK(Long.parseLong(text));
            setValue(role);
         }
      });
   }

   @RequestMapping("/list")
   public String elenco() {
      return "administration.user.list";
   }

   @RequestMapping("/findallpaginated")
   public @ResponseBody DataTablesResponseGrid<User> findallpaginated(
         @ModelAttribute DataTablesRequestGrid requestGrid) {
      return userService.findAllPaginated(requestGrid);
   }
   
   @RequestMapping(value = "/create", method = { RequestMethod.GET })
   public String create_start(Model model) {
      model.addAttribute("user", new User());
      model.addAttribute("availableRoles", roleService.findAll());
      return "administration.user.create";
   }

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String create(@ModelAttribute User user) {
      user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      userService.create(user);
      return "redirect:/administration/user/list";
   }
   
   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String update_start(@RequestParam("id") Long id, Model model) {
      User user = userService.findByPK(id);
      model.addAttribute("user", user);
      model.addAttribute("availableRoles", roleService.findAll());
      return "administration.user.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String update(@ModelAttribute User user) {
      if (isPasswordChanged(user)){
         user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      }
      
      userService.update(user);

      // change session user information
      if (new AuthenticationHolder().isAuthenticated(user)) {
         new AuthenticationHolder().updateUser(user);
         Role administratorRole = new Role();
         administratorRole.setId(Role.ADMINISTRATOR_ROLE_ID);
         if (!user.getRoles().contains(administratorRole)) {
            return "redirect:/welcome";
         }
      }

      return "redirect:/administration/user/list";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.GET })
   public String delete_start(@RequestParam("id") Long id, Model model) {
      User user = userService.findByPK(id);
      model.addAttribute("user", user);
      model.addAttribute("availableRoles", roleService.findAll());
      return "administration.user.delete";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.POST })
   public String delete(@ModelAttribute User user) {
      userService.delete(user);
      
      // TODO if the user equals to the session user remove it in the session
      
      return "redirect:/administration/user/list";
   }
   
   
   private boolean isPasswordChanged(User user){
      User persistentUser = userService.findByPK(user.getId());
      return !persistentUser.getId().equals(user.getId());
   }
}
