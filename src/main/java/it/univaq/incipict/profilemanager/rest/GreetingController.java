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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.incipict.profilemanager.business.InformationService;
import it.univaq.incipict.profilemanager.business.ProfileService;
import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.Information;
import it.univaq.incipict.profilemanager.business.model.Profile;
import it.univaq.incipict.profilemanager.business.model.ProfileInformation;
import it.univaq.incipict.profilemanager.business.model.User;
import it.univaq.incipict.profilemanager.common.spring.security.AuthenticationHolder;
import it.univaq.incipict.profilemanager.common.utility.Utility;

@RestController
@RequestMapping("/rest")
public class GreetingController {
   @Autowired
   private UserService userService;
   
   @Autowired
   private ProfileService profileService;
   
   @Autowired
   private InformationService informationService;
   
   @RequestMapping("/user/information/list")
   public Set<Information> user_information_list() {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());
      
      for (Information information : user.getInformationSet()) {
         // set profileInformationSet to null, because we don't need it in REST client
         information.setProfileInformationSet(null);
      }
      
      return user.getInformationSet();
   }
   
   @RequestMapping("profile/information/list")
   public List<Information> profile_information_list() {
      User user = userService.findByPK(new AuthenticationHolder().getUser().getId());
      List<Profile> profilesList = profileService.findAll();
      HashMap<Profile, Double> distancesMap = Utility.getEuclideanDistances(profilesList, user);
      Profile profile = Utility.getBestProfile(distancesMap);
      List<Information> informationList = new ArrayList<Information>();
      
      for (Information information : informationService.findAll()) {
         for (ProfileInformation profileInformation : information.getProfileInformationSet()) {
            if (profileInformation.getProfile().getId() == profile.getId() && profileInformation.getRank() >= 0.7) {
               // set profileInformationSet to null, because we don't need it in REST client
               information.setProfileInformationSet(null);
               informationList.add(information);
            }
         }
      }
      return informationList;
   }

}
