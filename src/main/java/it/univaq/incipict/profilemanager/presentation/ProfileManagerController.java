/*
 * 
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.incipict.profilemanager.business.DataTableRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTableResponseGrid;
import it.univaq.incipict.profilemanager.business.ProfileService;
import it.univaq.incipict.profilemanager.business.model.Profile;

/**
 * 
 * @author Daniele Tellina 
 *
 */

@Controller
@RequestMapping("/profile")
public class ProfileManagerController {

   @Autowired
   private ProfileService discoveryService;

   @RequestMapping(value = "/discovery", method = RequestMethod.GET)
   public @ResponseBody DataTableResponseGrid<Profile> discovery(
         @ModelAttribute DataTableRequestGrid requestGrid) {
      return discoveryService.discovery(requestGrid);
   }

   @RequestMapping(value = "/info", method = RequestMethod.GET)
   public String info(@RequestParam("name") String name, @RequestParam("description") String description, Model model) {
      
      Profile profile = discoveryService.detail(name, description);
      model.addAttribute("profileDetail", profile);
            
      return "content.profile.detail";
   }
}
