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

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class DataTableRequestGrid implements java.io.Serializable {
   private static final long serialVersionUID = 1L;

   private Integer iDisplayStart;
   private Integer iDisplayLength;
   private String sEcho;
   private String sSearch;
   private String iSortCol_0;
   private String sSortDir_0;
   private String[] mDataProp;

   public DataTableRequestGrid() {
      super();
   }

   public DataTableRequestGrid(Integer iDisplayStart, Integer iDisplayLength, String sEcho, String sSearch, String iSortCol_0,
         String sSortDir_0, String[] mDataProp) {
      super();
      this.iDisplayStart = iDisplayStart;
      this.iDisplayLength = iDisplayLength;
      this.sEcho = sEcho;
      this.sSearch = sSearch;
      this.iSortCol_0 = iSortCol_0;
      this.sSortDir_0 = sSortDir_0;
      this.mDataProp = mDataProp;

   }

   public String[] getmDataProp() {
      return mDataProp;
   }

   public void setmDataProp(String[] mDataProp) {
      this.mDataProp = mDataProp;
   }

   public Integer getiDisplayStart() {
      return iDisplayStart;
   }

   public void setiDisplayStart(Integer iDisplayStart) {
      this.iDisplayStart = iDisplayStart;
   }

   public Integer getiDisplayLength() {
      return iDisplayLength;
   }

   public void setiDisplayLength(Integer iDisplayLength) {
      this.iDisplayLength = iDisplayLength;
   }

   public String getsEcho() {
      return sEcho;
   }

   public void setsEcho(String sEcho) {
      this.sEcho = sEcho;
   }

   public String getsSearch() {
      return sSearch;
   }

   public void setsSearch(String sSearch) {
      this.sSearch = sSearch;
   }

   public String getiSortCol_0() {
      return iSortCol_0;
   }

   public void setiSortCol_0(String iSortCol_0) {
      this.iSortCol_0 = iSortCol_0;
   }

   public String getsSortDir_0() {
      return sSortDir_0;
   }

   public void setsSortDir_0(String sSortDir_0) {
      this.sSortDir_0 = sSortDir_0;
   }

   public SortType getSortDirType() {
      if (this.getsSortDir_0().equalsIgnoreCase(SortType.DESC.name())) {
         return SortType.DESC;
      }
      return SortType.ASC;

   }

   public enum SortType {
      ASC, DESC;
   }

}