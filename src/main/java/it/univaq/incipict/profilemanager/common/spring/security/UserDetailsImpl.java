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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.univaq.incipict.profilemanager.business.model.Role;
import it.univaq.incipict.profilemanager.business.model.User;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class UserDetailsImpl implements UserDetails {
   private static final long serialVersionUID = 8851321994996179060L;
   private User user;

   public UserDetailsImpl(User user) {
      super();
      this.user = user;
   }

   @Override
   public Collection<GrantedAuthority> getAuthorities() {
      List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
      for (Role role : user.getRoles()) {
         result.add(new GrantedAuthorityImpl(role));
      }
      return result;
   }

   @Override
   public String getPassword() {
      return this.user.getPassword();
   }

   @Override
   public String getUsername() {
      return user.getEmail();
   }
   
   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public String toString() {
      return "UserDetailsImpl [username=" + this.user.getEmail() + "]";
   }

   public User getUser() {
      return this.user;
   }
}
