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
package it.univaq.incipict.profilemanager.business;

import java.util.List;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class DataTableResponseGrid<R> implements java.io.Serializable {
   private static final long serialVersionUID = 2758192036976188694L;
   
   private String sEcho;
   private long iTotalRecords;
   private long iTotalDisplayRecords;
   private List<R> rows;

   public DataTableResponseGrid(String sEcho, long iTotalRecords, long iTotalDisplayRecords, List<R> rows) {
      super();
      this.sEcho = sEcho;
      this.iTotalRecords = iTotalRecords;
      this.iTotalDisplayRecords = iTotalDisplayRecords;
      this.rows = rows;
   }

   public String getsEcho() {
      return sEcho;
   }

   public void setsEcho(String sEcho) {
      this.sEcho = sEcho;
   }

   public long getiTotalRecords() {
      return iTotalRecords;
   }

   public void setiTotalRecords(long iTotalRecords) {
      this.iTotalRecords = iTotalRecords;
   }

   public long getiTotalDisplayRecords() {
      return iTotalDisplayRecords;
   }

   public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
      this.iTotalDisplayRecords = iTotalDisplayRecords;
   }

   public List<R> getRows() {
      return rows;
   }

   public void setRows(List<R> rows) {
      this.rows = rows;
   }

}