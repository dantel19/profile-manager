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
package it.univaq.incipict.profilemanager.business.model;

public class InformationProfileId {
   private Information information;
   private Profile profile;

   public Information getInformation() {
      return information;
   }

   public void setInformation(Information information) {
      this.information = information;
   }

   public Profile getProfile() {
      return profile;
   }

   public void setProfile(Profile profile) {
      this.profile = profile;
   }

   @Override
   public int hashCode() {
      int result = 1;
      result = result + ((information == null && profile == null) ? 0 : information.hashCode() + profile.hashCode());
      return result;
   }

}
