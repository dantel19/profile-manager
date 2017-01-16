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

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.univaq.incipict.profilemanager.business.RoleService;
import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.Role;
import it.univaq.incipict.profilemanager.business.model.User;
import it.univaq.incipict.profilemanager.common.spring.security.AuthenticationHolder;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @Autowired
   private RoleService roleService;

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String crea(@ModelAttribute User user) {

      List<Role> roles = roleService.findAll();
      for (Role role : roles) {
         if (role.getName().equals(Role.USER_ROLE_NAME)) {
            user.getRoles().add(role);
         }
      }

      user.setPassword(DigestUtils.md5Hex(user.getPassword()));

      // TODO authenticate the user and redirect on the welcome page
      userService.create(user);
      return "redirect:/login";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String modifica_start(@RequestParam("id") Long id, Model model) {
      User user = userService.findByPK(id);
      if (!((new AuthenticationHolder()).getUser()).getEmail().equals(user.getEmail())){
         return "standalone.accessdenied";
      }
      model.addAttribute("user", user);
      return "user.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String modifica(@ModelAttribute User user) {
      // TODO remove this set
      user.setRoles(userService.findByPK(user.getId()).getRoles());
      
      userService.update(user);
      User authenticatedUser = (new AuthenticationHolder()).getUser();
      authenticatedUser.setName(user.getName());
      authenticatedUser.setSurname(user.getSurname());
      authenticatedUser.setEmail(user.getEmail());
      authenticatedUser.setPassword(user.getPassword());
      return "redirect:/welcome";
   }

}
