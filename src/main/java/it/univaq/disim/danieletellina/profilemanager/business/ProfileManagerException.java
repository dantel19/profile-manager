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

package it.univaq.disim.danieletellina.profilemanager.business;

/**
 * 
 * @author Daniele Tellina (http://www.daniele.tellina/)
 *
 */

public class ProfileManagerException extends  RuntimeException {
   private static final long serialVersionUID = 8763752345678639100L;

   public ProfileManagerException() {
      super();
   }

   public ProfileManagerException(String message, Throwable cause) {
      super(message, cause);
   }

   public ProfileManagerException(String message) {
      super(message);
   }

   public ProfileManagerException(Throwable cause) {
      super(cause);
   }
}
