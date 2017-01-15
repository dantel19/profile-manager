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

import org.springframework.security.core.GrantedAuthority;

import it.univaq.incipict.profilemanager.business.model.Role;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
   private static final long serialVersionUID = -6656718807102452484L;
   private Role role;

   public GrantedAuthorityImpl(Role role) {
      super();
      this.role = role;
   }

   @Override
   public String getAuthority() {
      return role.getName();
   }

   @Override
   public String toString() {
      return "[autority=" + role.getName() + "]";
   }
}
