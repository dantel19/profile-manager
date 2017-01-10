/*
 * Profile Manager - Copyright (C) 2016  Alexander Perucci (http://www.alexanderperucci.com/).
 * Profile Manager - Copyright (C) 2016  Daniele Tellina (http://www.daniele.tellina/).
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

package it.univaq.disim.danieletellina.profilemanager.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.danieletellina.profilemanager.business.ProfileService;
import it.univaq.disim.danieletellina.profilemanager.business.DataTableRequestGrid;
import it.univaq.disim.danieletellina.profilemanager.business.DataTableRequestGrid.SortType;
import it.univaq.disim.danieletellina.profilemanager.business.DataTableResponseGrid;
import it.univaq.disim.danieletellina.profilemanager.business.ProfileManagerException;
import it.univaq.disim.danieletellina.profilemanager.business.model.Profile;

/**
 * 
 * @author Daniele Tellina (http://www.daniele.tellina/)
 *
 */

@Service
public class ProfileServiceImpl implements ProfileService {

   /*
    * @Value("#{appconfig_properties.HTTP_PROTOCOL}") private String
    * httpProtocol;
    * 
    * @Value("#{appconfig_properties.HTTP_PORT}") private String httpPort;
    */

   @Override
   public DataTableResponseGrid<Profile> discovery(DataTableRequestGrid requestGrid) throws ProfileManagerException {
      // search all profiles
      List<Profile> allProfiles = getInitElement();
      

      // filter
      List<Profile> filtered = new ArrayList<Profile>();
      for (Profile profile : allProfiles) {
         if (!filtered.contains(profile)) {
            if (profile.getName().contains(requestGrid.getsSearch())
                  || profile.getDescription().contains(requestGrid.getsSearch())) {
               filtered.add(profile);
            }
         }
      }

      // order filtered element
      int colSort = Integer.parseInt(requestGrid.getiSortCol_0());
      if (requestGrid.getSortDirType() == SortType.ASC) {
         switch (colSort) {
         case 0:
            filtered.sort((a, b) -> a.getName().compareTo(b.getName()));
            break;
         case 1:
            filtered.sort((a, b) -> a.getDescription().compareTo(b.getDescription()));
            break;
         }
      } else if (requestGrid.getSortDirType() == SortType.DESC) {
         switch (colSort) {
         case 0:
            filtered.sort((a, b) -> b.getName().compareTo(a.getName()));
            break;
         case 1:
            filtered.sort((a, b) -> b.getDescription().compareTo(a.getDescription()));
            break;
         }
      }
      
      // show required user 
      List<Profile> result = new ArrayList<Profile>();
      int fromIndex = requestGrid.getiDisplayStart();
      int toIndex = fromIndex + requestGrid.getiDisplayLength();

      if (!(fromIndex < 0 || fromIndex > toIndex)) {
         if (toIndex > filtered.size()) {
            result.addAll(filtered.subList(fromIndex, filtered.size()));
         } else {
            result.addAll(filtered.subList(fromIndex, toIndex));
         }

      }

      return new DataTableResponseGrid<Profile>(requestGrid.getsEcho(), filtered.size(), filtered.size(), result);
   }
   
   @Override
   public Profile detail (String name, String description) throws ProfileManagerException {
      return new Profile(name, description);
   }
   

   private List<Profile> getInitElement() {
      ArrayList<Profile> profiles = new ArrayList<Profile>();

      Profile profile = new Profile("Ingegnere Civile", "IC");
      profiles.add(profile);
      profile = new Profile("Architetto", "ARC");
      profiles.add(profile);
      profile = new Profile("Energy Manager", "EM");
      profiles.add(profile);
      profile = new Profile("Ingegnere Elettronico e dell'Automazione", "IEA");
      profiles.add(profile);
      profile = new Profile("Storico dell'Arte", "SA");
      profiles.add(profile);
      profile = new Profile("Turista", "TS");
      profiles.add(profile);

      return new ArrayList<Profile>(profiles);
   }

}
