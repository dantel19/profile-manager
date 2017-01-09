package it.univaq.disim.danieletellina.profilemanager.business.model;

import java.util.List;

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
