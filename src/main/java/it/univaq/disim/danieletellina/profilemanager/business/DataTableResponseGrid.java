package it.univaq.disim.danieletellina.profilemanager.business;

import java.util.List;

/**
 * 
 * @author Daniele Tellina (http://www.daniele.tellina/)
 *
 */
public class DataTableResponseGrid<R> implements java.io.Serializable {
   private static final long serialVersionUID = 8763752345678639201L;

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