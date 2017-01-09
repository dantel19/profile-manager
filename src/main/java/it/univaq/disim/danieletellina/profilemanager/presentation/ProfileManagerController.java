package it.univaq.disim.danieletellina.profilemanager.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.disim.danieletellina.profilemanager.business.ProfileService;
import it.univaq.disim.danieletellina.profilemanager.business.DataTableRequestGrid;
import it.univaq.disim.danieletellina.profilemanager.business.DataTableResponseGrid;
import it.univaq.disim.danieletellina.profilemanager.business.model.Profile;

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
