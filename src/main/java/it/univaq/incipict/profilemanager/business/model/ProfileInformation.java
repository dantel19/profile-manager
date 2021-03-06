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

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Profile_Information")
public class ProfileInformation implements java.io.Serializable {
   private static final long serialVersionUID = 9046973983171068447L;

   @EmbeddedId
   private ProfileInformationPK id;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "id_profile", insertable = false, updatable = false)
   private Profile profile;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "id_information", insertable = false, updatable = false)
   private Information information;

   @Column(name = "rank", nullable = false)
   private Double rank;

   @Transient
   public ProfileInformationPK getId() {
      return id;
   }

   @Transient
   public void setId(ProfileInformationPK id) {
      this.id = id;
   }

   public Profile getProfile() {
      return profile;
   }

   public void setProfile(Profile profile) {
      this.profile = profile;
   }

   public Information getInformation() {
      return information;
   }

   public void setInformation(Information information) {
      this.information = information;
   }

   public Double getRank() {
      return rank;
   }

   public void setRank(Double rank) {
      this.rank = rank;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
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
      ProfileInformation other = (ProfileInformation) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      }
      return true;
   }

}
