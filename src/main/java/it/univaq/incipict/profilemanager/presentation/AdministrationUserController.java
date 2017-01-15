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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.univaq.incipict.profilemanager.business.RequestGrid;
import it.univaq.incipict.profilemanager.business.ResponseGrid;
import it.univaq.incipict.profilemanager.business.UserService;
import it.univaq.incipict.profilemanager.business.model.User;

/**
 * 
 * @author Daniele Tellina 
 *
 */
@Controller
@RequestMapping("/administration/user")
public class AdministrationUserController {
   
   @Autowired
   private UserService userService;
   
   @RequestMapping("/list")
   public String elenco() {
       return "user.list";
   }

   @RequestMapping("/findallpaginated")
   public @ResponseBody
   ResponseGrid<User> findallpaginated(@ModelAttribute RequestGrid requestGrid) {
       return userService.findAllPaginated(requestGrid);
   }
/*
   @RequestMapping(value = "/crea", method = {RequestMethod.GET})
   public String crea_start(Model model) {
       Domanda domanda = new Domanda();
       model.addAttribute("tipologieSoggettoDomanda", tipologiaSoggettoDomandaService.findAll());
       model.addAttribute("domanda", domanda);
       model.addAttribute("categorie", categorieService.findAll());
       return "domanda.crea";
   }

   @RequestMapping(value = "/crea", method = {RequestMethod.POST})
   public String crea(@ModelAttribute Domanda domanda, @RequestParam(value = "categorie", required = false) Long[] categorie) {
       if (categorie != null && categorie.length != 0) {
           for (Long categoria : categorie) {
               CategoriaDomanda categoriaDomanda = new CategoriaDomanda();
               Categoria cat = new Categoria();
               cat.setId(categoria);
               categoriaDomanda.setCategoria(cat);
               domanda.addCategoriaDomanda(categoriaDomanda);
           }
       }
       if (domanda.getSoggettoImprenditoriale().getComuneSedeLegale().getId() == null) {
           domanda.getSoggettoImprenditoriale().setComuneSedeLegale(null);
       }
       if (domanda.getSoggettoImprenditoriale().getComuneSedeINPS().getId() == null) {
           domanda.getSoggettoImprenditoriale().setComuneSedeINPS(null);
       }
       domanda.setDataEvento(Utility.actualDate());
       domanda.setStato(StatoDomanda.INCOMPLETA);
       domandaService.create(domanda, utente);
       return "redirect:/persona/elenco?idSoggettoImprenditoriale=" + domanda.getSoggettoImprenditoriale().getId();
   }

   @RequestMapping(value = "/modifica", method = {RequestMethod.GET})
   public String modifica_start(@RequestParam("id") Long id, Model model) {
       Domanda domanda = domandaService.findByPK(id);
       model.addAttribute("tipologieSoggettoDomanda", tipologiaSoggettoDomandaService.findAll());
       model.addAttribute("domanda", domanda);
       model.addAttribute("categorie", categorieService.findAll());
       return "domanda.modifica";
   }

   @RequestMapping(value = "/modifica", method = {RequestMethod.POST})
   public String modifica(@ModelAttribute Domanda domanda, @RequestParam(value = "categorie", required = false) Long[] categorie) {
       if (categorie != null && categorie.length != 0) {
           for (Long categoria : categorie) {
               CategoriaDomanda categoriaDomanda = new CategoriaDomanda();
               Categoria cat = new Categoria();
               cat.setId(categoria);
               categoriaDomanda.setCategoria(cat);
               domanda.addCategoriaDomanda(categoriaDomanda);
           }
       }

       if (domanda.getSoggettoImprenditoriale().getComuneSedeLegale().getId() == null) {
           domanda.getSoggettoImprenditoriale().setComuneSedeLegale(null);
       }
       if (domanda.getSoggettoImprenditoriale().getComuneSedeINPS().getId() == null) {
           domanda.getSoggettoImprenditoriale().setComuneSedeINPS(null);
       }
       domandaService.deleteCategorieDomanda(domanda.getId());
       domandaService.update(domanda, utente);
       return "redirect:/partecipazione/elenco?iddomanda=" + domanda.getId();
   }

*/
}
