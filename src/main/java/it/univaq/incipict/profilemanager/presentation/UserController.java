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

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
   
   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String crea(@ModelAttribute User user) {
      Role userRole = new Role();
      userRole.setId(Role.USER_ROLE_ID);
      user.getRoles().add(userRole);
      user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      userService.create(user);

      // authenticate the user and redirect on the welcome page
      new AuthenticationHolder().updateUser(userService.findByPK(user.getId()));
      
      return "redirect:/welcome";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String modifica_start(@RequestParam("id") Long id, Model model) {
      User user = userService.findByPK(id);
      if (!(new AuthenticationHolder().isAuthenticated(user))){
         return "standalone.accessdenied";
      }
      model.addAttribute("user", user);
      return "user.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String modifica(@ModelAttribute User user) {
      if (isPasswordChanged(user)){
         user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      }
      // TODO remove this set
      user.setRoles(userService.findByPK(user.getId()).getRoles());
      userService.update(user);
      
      // authenticate the user and redirect on the welcome page
      new AuthenticationHolder().updateUser(userService.findByPK(user.getId()));
      
      return "redirect:/welcome";
   }
   
   private boolean isPasswordChanged(User user){
      User persistentUser = userService.findByPK(user.getId());
      return !persistentUser.getPassword().equals(user.getPassword());
   }

}
