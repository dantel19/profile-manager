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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(InformationProfileId.class)
@Table(name = "Information_Profile")
public class InformationProfile implements java.io.Serializable {
   private static final long serialVersionUID = 9046973983171068447L;

   @Id
   @ManyToOne
   @JoinColumn(name = "id_information")
   private Information information;

   @Id
   @ManyToOne
   @JoinColumn(name = "id_profile")
   private Profile profile;

   @Column(name = "rank", nullable = false)
   private Double rank;

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

   public Double getRank() {
      return rank;
   }

   public void setRank(Double rank) {
      this.rank = rank;
   }

}
