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
package it.univaq.incipict.profilemanager.business;

import java.util.List;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public interface CRUDService<PK, MODEL> {
   List<MODEL> findAll() throws ProfileManagerException;
  // DataTableResponseGrid<MODEL> findAllPaginated(DataTableRequestGrid dataTableRequestGrid) throws ProfileManagerException;
   DataTablesResponseGrid<MODEL> findAllPaginated(DataTablesRequestGrid dataTableRequestGrid) throws ProfileManagerException;
   void create(MODEL model) throws ProfileManagerException;
   MODEL findByPK(PK pk) throws ProfileManagerException;
   void update(MODEL model) throws ProfileManagerException;
   void delete(MODEL model) throws ProfileManagerException;

}
