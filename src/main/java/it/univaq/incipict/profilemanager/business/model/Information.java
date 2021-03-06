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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Entity
@Table(name = "Information")
public class Information implements java.io.Serializable {
   private static final long serialVersionUID = -8647660001088003407L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "description", nullable = true, length = 512)
   private String description;

   @JsonIgnore
   @ManyToMany(fetch = FetchType.EAGER)
   @Fetch(FetchMode.SELECT)
   @JoinTable(name = "Category_Information", joinColumns = {
         @JoinColumn(name = "id_information") }, inverseJoinColumns = { @JoinColumn(name = "id_category") })
   private Set<Category> categorySet = new HashSet<Category>();

   @OneToMany(mappedBy = "information", fetch = FetchType.EAGER, orphanRemoval = true)
   private List<ProfileInformation> profileInformationSet = new ArrayList<ProfileInformation>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public List<ProfileInformation> getProfileInformationSet() {
      return profileInformationSet;
   }

   public void setProfileInformationSet(List<ProfileInformation> profileInformationSet) {
      this.profileInformationSet = profileInformationSet;
   }

   public Set<Category> getCategorySet() {
      return categorySet;
   }

   public void setCategorySet(Set<Category> categorySet) {
      this.categorySet = categorySet;
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
      Information other = (Information) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }

}
