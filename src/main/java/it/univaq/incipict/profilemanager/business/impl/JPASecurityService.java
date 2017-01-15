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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.univaq.incipict.profilemanager.business.ProfileManagerException;
import it.univaq.incipict.profilemanager.business.SecurityService;
import it.univaq.incipict.profilemanager.business.model.User;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
@Service
public class JPASecurityService implements SecurityService {
   
   @PersistenceContext
   private EntityManager em;

   @Override
   @Transactional
   public User authenticate(String username) throws ProfileManagerException {
      Query query = em.createQuery("from User as u where u.email = :email");
      query.setParameter("email", username);
      return (User) query.getSingleResult();
   }

}
