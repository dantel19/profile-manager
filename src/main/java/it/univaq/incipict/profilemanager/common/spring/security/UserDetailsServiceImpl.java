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
package it.univaq.incipict.profilemanager.common.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.univaq.incipict.profilemanager.business.ProfileManagerException;
import it.univaq.incipict.profilemanager.business.SecurityService;
import it.univaq.incipict.profilemanager.business.model.User;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService{
   @Autowired
   private SecurityService service;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user;
       try {
           user = service.authenticate(username);
       } catch (ProfileManagerException e) {
           throw new UsernameNotFoundException("User not found.");
       }
       
       if (user == null) {
           throw new UsernameNotFoundException("User not found.");
       }
       return new UserDetailsImpl(user);

   }

}
