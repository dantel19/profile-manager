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

import it.univaq.incipict.profilemanager.business.CategoryService;
import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.InformationService;
import it.univaq.incipict.profilemanager.business.model.Category;
import it.univaq.incipict.profilemanager.business.model.Information;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Controller
@RequestMapping("/administration/information")
public class AdministrationInformationController {

   @Autowired
   private InformationService informationService;

   @Autowired
   private CategoryService categoryService;

   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
      binder.registerCustomEditor(Category.class, "categorySet", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) {
            Category category = categoryService.findByPK(Long.parseLong(text));
            setValue(category);
         }
      });
   }

   @RequestMapping("/list")
   public String list(Model model) {
      return "administration.information.list";
   }

   @RequestMapping("/findallpaginated")
   public @ResponseBody DataTablesResponseGrid<Information> findallpaginated(
         @ModelAttribute DataTablesRequestGrid requestGrid) {
      return informationService.findAllPaginated(requestGrid);
   }

   @RequestMapping(value = "/create", method = { RequestMethod.GET })
   public String create_start(Model model) {
      model.addAttribute("information", new Information());
      return "administration.information.create";
   }

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String create(@ModelAttribute Information information) {
      informationService.create(information);
      return "redirect:/administration/information/list";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String update_start(@RequestParam("id") Long id, Model model) {
      Information information = informationService.findByPK(id);
      model.addAttribute("information", information);
      model.addAttribute("availableCategories", categoryService.findAll());
      return "administration.information.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String update(@ModelAttribute Information information) {
      informationService.update(information);
      return "redirect:/administration/information/list";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.GET })
   public String delete_start(@RequestParam("id") Long id, Model model) {
      Information information = informationService.findByPK(id);
      model.addAttribute("information", information);
      model.addAttribute("availableCategories", categoryService.findAll());
      return "administration.information.delete";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.POST })
   public String delete(@ModelAttribute Information information) {
      informationService.delete(information);
      return "redirect:/administration/information/list";
   }

}
