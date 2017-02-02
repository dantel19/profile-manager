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

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProfileInformationPK implements Serializable {
   private static final long serialVersionUID = -2875398420719600298L;
   private Long id_information, id_profile;

   public Long getId_information() {
      return id_information;
   }

   public void setId_information(Long id_information) {
      this.id_information = id_information;
   }

   public Long getId_profile() {
      return id_profile;
   }

   public void setId_profile(Long id_profile) {
      this.id_profile = id_profile;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id_information == null) ? 0 : id_information.hashCode());
      result = prime * result + ((id_profile == null) ? 0 : id_profile.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ProfileInformationPK other = (ProfileInformationPK) obj;
      if (id_information == null) {
         if (other.id_information != null)
            return false;
      } else if (!id_information.equals(other.id_information))
         return false;
      if (id_profile == null) {
         if (other.id_profile != null)
            return false;
      } else if (!id_profile.equals(other.id_profile))
         return false;
      return true;
   }

}
