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
public class InformationProfilePK implements Serializable {
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
       return (int) (id_information.hashCode() + id_profile);
   }

   @Override
   public boolean equals(Object obj) {
       if (obj == this) return true;
       if (obj == null) return false;
       if (!(obj instanceof InformationProfilePK)) return false;
       InformationProfilePK pk = (InformationProfilePK) obj;
       return pk.id_information == id_information && pk.id_profile == id_profile;
   }
}
