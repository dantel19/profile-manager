package it.univaq.incipict.profilemanager.presentation.form;

import java.util.List;

import it.univaq.incipict.profilemanager.business.model.Profile;
import it.univaq.incipict.profilemanager.business.model.ProfileInformation;

public class ProfileInformationForm {

   private Profile profile;
   private List<ProfileInformation> informationList;

   public Profile getProfile() {
      return profile;
   }

   public void setProfile(Profile profile) {
      this.profile = profile;
   }

   public List<ProfileInformation> getInformationList() {
      return informationList;
   }

   public void setInformationList(List<ProfileInformation> informationList) {
      this.informationList = informationList;
   }

}
