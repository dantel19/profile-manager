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

package it.univaq.incipict.profilemanager.business;

import it.univaq.incipict.profilemanager.business.model.Profile;

/*
 * 
 */
public interface ProfileService {
   
   DataTableResponseGrid<Profile> discovery (DataTableRequestGrid requestGrid) throws ProfileManagerException;

   Profile detail (String name, String description) throws ProfileManagerException;
}
