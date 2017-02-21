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
import java.util.HashMap;
import java.util.List;

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

import it.univaq.incipict.profilemanager.business.InformationService;
import it.univaq.incipict.profilemanager.business.ProfileService;
import it.univaq.incipict.profilemanager.business.RoleService;
import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.Information;
import it.univaq.incipict.profilemanager.business.model.Profile;
import it.univaq.incipict.profilemanager.business.model.Role;
import it.univaq.incipict.profilemanager.business.model.User;
import it.univaq.incipict.profilemanager.common.spring.security.AuthenticationHolder;
import it.univaq.incipict.profilemanager.common.utility.Utility;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {

   @Autowired
   private UserService userService;

   @Autowired
   private RoleService roleService;

   @Autowired
   private InformationService informationService;

   @Autowired
   private ProfileService profileService;

   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
      binder.registerCustomEditor(Role.class, "roles", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) {
            Role role = roleService.findByPK(Long.parseLong(text));
            setValue(role);
         }
      });

      binder.registerCustomEditor(Information.class, "informationSet", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) {
            Information information = informationService.findByPK(Long.parseLong(text));
            setValue(information);
         }
      });
   }

   @RequestMapping(value = "/dashboard/ajax/widget/profilechart", method = { RequestMethod.GET })
   public String ajax_profilechart(Model model) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());

      List<Profile> profilesList = profileService.findAll();
      int informationSetSize = informationService.findAll().size();

      HashMap<Profile, Double> distancesMap = Utility.getEuclideanDistances(profilesList, user);
      HashMap<Profile, Float> percentagesMap = Utility.getPercentages(distancesMap, informationSetSize);
      Profile bestProfile = Utility.getBestProfile(distancesMap);
      
      model.addAttribute("distancesMap", distancesMap);
      model.addAttribute("percentagesMap", percentagesMap);
      model.addAttribute("bestProfile", bestProfile);
      return "widgets.profilechart";
   }
   
   @RequestMapping(value = "/dashboard/ajax/widget/distances", method = { RequestMethod.GET })
   public String ajax_distances(Model model) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());
      List<Profile> profilesList = profileService.findAll();
      HashMap<Profile, Double> distancesMap = Utility.getEuclideanDistances(profilesList, user);
      
      model.addAttribute("distancesMap", distancesMap);
      return "widgets.distances";
   }

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String crea(@ModelAttribute User user) {
      Role userRole = new Role();
      userRole.setId(Role.USER_ROLE_ID);
      user.getRoles().add(userRole);
      user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      userService.create(user);

      // authenticate the user and redirect on the welcome page
      new AuthenticationHolder().updateUser(userService.findByPK(user.getId()));

      return "redirect:/dashboard";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String modifica_start(Model model) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());
      if (!(new AuthenticationHolder().isAuthenticated(user))) {
         return "standalone.accessdenied";
      }
      model.addAttribute("user", user);
      return "user.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String modifica(@ModelAttribute User user) {
      if (isPasswordChanged(user)) {
         user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      }
      userService.update(user);

      // authenticate the user and redirect on the welcome page
      new AuthenticationHolder().updateUser(user);

      return "redirect:/dashboard";
   }

   @RequestMapping(value = "/information/update", method = { RequestMethod.GET })
   public String update_start(Model model) {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());
      if (!(new AuthenticationHolder().isAuthenticated(user))) {
         return "standalone.accessdenied";
      }
      model.addAttribute("user", user);
      model.addAttribute("informationList", informationService.findAll());
      return "user.information.update";
   }

   @RequestMapping(value = "/information/update", method = { RequestMethod.POST })
   public String update(@ModelAttribute User user) {
      userService.update(user);
      return "redirect:/dashboard";
   }

   private boolean isPasswordChanged(User user) {
      User persistentUser = userService.findByPK(user.getId());
      return !persistentUser.getPassword().equals(user.getPassword());
   }

}
