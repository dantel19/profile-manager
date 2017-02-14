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
package it.univaq.incipict.profilemanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.univaq.incipict.profilemanager.business.ProfileInformationService;
import it.univaq.incipict.profilemanager.business.ProfileManagerException;
import it.univaq.incipict.profilemanager.business.model.ProfileInformation;
import it.univaq.incipict.profilemanager.business.model.ProfileInformationPK;

/**
 * 
 * @author Daniele Tellina
 *
 */
@Service
public class JPAProfileInformation extends JPACRUDService<ProfileInformationPK, ProfileInformation>
      implements ProfileInformationService {

   @Transactional
   public List<ProfileInformation> findByProfile(Long id) throws ProfileManagerException {
      return (List<ProfileInformation>) em
            .createQuery("SELECT t FROM ProfileInformation t WHERE t.profile.id = :id_profile", ProfileInformation.class)
            .setParameter("id_profile", id).getResultList();
   }

   @Transactional
   public List<ProfileInformation> findByInformation(Long id) throws ProfileManagerException {
      return (List<ProfileInformation>) em
            .createQuery("SELECT t FROM ProfileInformation t WHERE t.information.id = :id_information", ProfileInformation.class)
            .setParameter("id_information", id).getResultList();
   }

}
