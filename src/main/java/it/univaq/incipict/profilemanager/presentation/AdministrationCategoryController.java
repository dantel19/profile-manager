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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.incipict.profilemanager.business.CategoryService;
import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.model.Category;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Controller
@RequestMapping("/administration/category")
public class AdministrationCategoryController {

   @Autowired
   private CategoryService categoryService;

   @RequestMapping("/list")
   public String list() {
      return "administration.category.list";
   }

   @RequestMapping("/findallpaginated")
   public @ResponseBody DataTablesResponseGrid<Category> findallpaginated(
         @ModelAttribute DataTablesRequestGrid requestGrid) {
      return categoryService.findAllPaginated(requestGrid);
   }

   @RequestMapping(value = "/create", method = { RequestMethod.GET })
   public String create_start(Model model) {
      model.addAttribute("category", new Category());
      return "administration.category.create";
   }

   @RequestMapping(value = "/create", method = { RequestMethod.POST })
   public String create(@ModelAttribute Category category) {
      categoryService.create(category);
      return "redirect:/administration/category/list";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.GET })
   public String update_start(@RequestParam("id") Long id, Model model) {
      Category category = categoryService.findByPK(id);
      model.addAttribute("category", category);
      return "administration.category.update";
   }

   @RequestMapping(value = "/update", method = { RequestMethod.POST })
   public String update(@ModelAttribute Category category) {
      categoryService.update(category);
      return "redirect:/administration/category/list";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.GET })
   public String delete_start(@RequestParam("id") Long id, Model model) {
      Category category = categoryService.findByPK(id);
      model.addAttribute("category", category);
      return "administration.category.delete";
   }

   @RequestMapping(value = "/delete", method = { RequestMethod.POST })
   public String delete(@ModelAttribute Category category) {
      categoryService.delete(category);
      return "redirect:/administration/category/list";
   }

}
