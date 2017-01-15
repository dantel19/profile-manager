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

import java.util.List;

/**
 * 
 * @author Daniele Tellina 
 *
 */

public class Profile {
	private int ID;
	private String name;
	private String description;
	private boolean custom;
	
	private List<Information> associatedInformations;
	
	public Profile(String name, String description) {
	      super();
	      this.name = name;
	      this.description = description;
	      this.custom = false;
	   }
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public List<Information> getAssociatedInformations() {
		return associatedInformations;
	}
	public void setAssociatedInformations(List<Information> associatedInformations) {
		this.associatedInformations = associatedInformations;
	}
	

}
