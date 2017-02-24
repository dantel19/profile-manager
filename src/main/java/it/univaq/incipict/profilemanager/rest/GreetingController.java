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
package it.univaq.incipict.profilemanager.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.Information;
import it.univaq.incipict.profilemanager.business.model.User;
import it.univaq.incipict.profilemanager.common.spring.security.AuthenticationHolder;

@RestController
@RequestMapping("/rest")
public class GreetingController {
   @Autowired
   private UserService userService;
   private static final String template = "Hello, %s!";

   @RequestMapping("/sayhello")
   public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());

      return String.format(template, user.getFirstname() + " " + user.getLastname());
   }

   @RequestMapping("/user/information/list")
   public Set<Information> list(@RequestParam(value = "name", defaultValue = "World") String name) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());

      return userService.findByPK(user.getId()).getInformationSet();
   }

   // This API returns all the information associated with the user profile that
   // he has not selected
   // information is associated with a profile if their rank is greater or equal
   // to 0.7
   @RequestMapping("/user/information/profilecompletion")
   public Set<Information> profileCompletion(@RequestParam(value = "name", defaultValue = "World") String name) {
      return userService.findByPK(1L).getInformationSet();
   }

}
