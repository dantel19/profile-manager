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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.ProfileInformationService;
import it.univaq.incipict.profilemanager.business.ProfileService;
import it.univaq.incipict.profilemanager.business.model.Profile;
import it.univaq.incipict.profilemanager.business.model.ProfileInformation;
import it.univaq.incipict.profilemanager.presentation.form.ProfileInformationForm;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Controller
@RequestMapping("/administration/profile")
public class AdministrationProfileController {

   @Autowired
   private ProfileService profileService;

   @Autowired
   private ProfileInformationService profileInformationService;

   @RequestMapping("/list")
   public String list() {
      return "administration.profile.list";
   }

   @RequestMapping("/findallpaginated")
   public @ResponseBody DataTablesResponseGrid<Profile> findallpaginated(
         @ModelAttribute DataTablesRequestGrid requestGrid) {
      return profileService.findAllPaginated(requestGrid);
   }

   @RequestMapping(value = "/create", method = { RequestMethod.GET })
   public String create_start(Model model) {
      model.addAttribute("profile", new Profile());
      return "administration.profile.create";
   }

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String create(@ModelAttribute Profile profile) {
      profileService.create(profile);
      return "redirect:/administration/profile/list";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String update_start(@RequestParam("id") Long id, Model model) {
      Profile profile = profileService.findByPK(id);
      List<ProfileInformation> profileInformationList = profileInformationService.findByProfile(profile.getId());

      ProfileInformationForm profileInformationForm = new ProfileInformationForm();
      profileInformationForm.setProfile(profile);
      profileInformationForm.setInformationList(profileInformationList);

      model.addAttribute("profileInformationForm", profileInformationForm);

      return "administration.profile.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String update(@ModelAttribute("profileInformationForm") ProfileInformationForm profileInformationForm) {

      Profile profile = profileInformationForm.getProfile();
      Set<ProfileInformation> informationSet = new HashSet<ProfileInformation>(
            profileInformationForm.getInformationList());

      profile.setProfileInformationSet(informationSet);

      profileService.update(profile);
      return "redirect:/user/dashboard";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.GET })
   public String delete_start(@RequestParam("id") Long id, Model model) {
      Profile profile = profileService.findByPK(id);

      List<ProfileInformation> profileInformationList = profileInformationService.findByProfile(profile.getId());

      ProfileInformationForm profileInformationForm = new ProfileInformationForm();
      profileInformationForm.setProfile(profile);
      profileInformationForm.setInformationList(profileInformationList);

      model.addAttribute("profileInformationForm", profileInformationForm);

      return "administration.profile.delete";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.POST })
   public String delete(@ModelAttribute("profileInformationForm") ProfileInformationForm profileInformationForm) {
      Profile profile = profileInformationForm.getProfile();

      profileService.delete(profile);
      return "redirect:/administration/profile/list";
   }

}
