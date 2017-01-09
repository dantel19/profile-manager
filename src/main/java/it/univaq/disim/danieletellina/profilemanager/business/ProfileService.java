package it.univaq.disim.danieletellina.profilemanager.business;

import it.univaq.disim.danieletellina.profilemanager.business.model.Profile;

/*
 * 
 */
public interface ProfileService {
   
   DataTableResponseGrid<Profile> discovery (DataTableRequestGrid requestGrid) throws ProfileManagerException;

   Profile detail (String name, String description) throws ProfileManagerException;
}
