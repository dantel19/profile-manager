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
package it.univaq.incipict.profilemanager.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.ProfileManagerException;
import it.univaq.incipict.profilemanager.business.ProfileService;
import it.univaq.incipict.profilemanager.business.model.Profile;

/**
 * 
 * @author Daniele Tellina 
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
   public DataTablesResponseGrid<Profile> discovery(DataTablesRequestGrid requestGrid) throws ProfileManagerException {
      return null;
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
