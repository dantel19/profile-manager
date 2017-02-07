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

import org.springframework.util.StringUtils;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class SearchField implements java.io.Serializable{
   private static final long serialVersionUID = -7260940866954111493L;

   private RangeType rangeType;
   private String value;
   private String name;
   private String nameParam;
   private boolean addPercentPrefix = false;
   public static final String NAME_SEPARATOR = ".";
   public static final String NAME_PARAM_SEPARATOR = "_";
   public static final String MULTIPLE_VALUE_SEPARATOR = "$";
   public static final String ALIAS_PREFIX = "alias_";
   
   private NullType nullType;
   

   public SearchField(String name, String value, RangeType range) {
       this(name);
       this.rangeType = range;
       this.value = value;
   }

   public SearchField(String name) {
       this.name = name;
       this.nameParam = name.replace(NAME_SEPARATOR, NAME_PARAM_SEPARATOR);
   }

   public void setRangeType(RangeType rangeType) {
       this.rangeType = rangeType;
   }

   public RangeType getRangeType() {
       return rangeType;
   }

   public boolean isEmpty() {
       return (value == null || "".equalsIgnoreCase(value.trim())) && (this.nullType == NullType.NO_NULL);
   }

   public String getValue() {
       return value;
   }

   public void setValue(String value) {
       this.value = value;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getNameParam() {
       switch (rangeType) {
           case RANGE_FROM:
               return nameParam.concat("FROM");
           case RANGE_TO:
               return nameParam.concat("TO");
           case RANGE_IN:
               return nameParam;
           default:
               return nameParam;
       }        
   }

   public enum RangeType {
       RANGE_NONE,
       RANGE_FROM,
       RANGE_TO,
       RANGE_IN;
   }
   
   public enum NullType {
       NO_NULL,
       IS_NULL,
       IS_NOT_NULL;
       
   }
   
   public boolean isRangeFrom() {
       return rangeType == RangeType.RANGE_FROM;
   }
   
   public boolean isRangeTo() {
       return rangeType == RangeType.RANGE_TO;
   }
   
   public boolean isRangeIn() {
       return rangeType == RangeType.RANGE_IN;
   }
       
   public boolean isRange() {
       return rangeType != RangeType.RANGE_NONE;
   }

   public void setNullType(NullType nullType) {
       this.nullType = nullType;
   }

   public boolean isIsNull() {
       return this.nullType == NullType.IS_NULL;
   }
   public boolean isIsNotNull() {
       return this.nullType == NullType.IS_NOT_NULL;
   }

   public String getAlias() {        
       String[] temp = StringUtils.delimitedListToStringArray(name, ".");
       return ALIAS_PREFIX.concat(temp[0]);        
   }
   
   public String getNameAlias() {        
       return StringUtils.replace(name, StringUtils.delimitedListToStringArray(name, ".")[0], getAlias());
       
   }

   public String getNameRoot() {
       return  StringUtils.delimitedListToStringArray(name, ".")[0];        
   }

   public boolean isAddPercentPrefix() {
       return addPercentPrefix;
   }

   public void setAddPercentPrefix(boolean addPercentPrefix) {
       this.addPercentPrefix = addPercentPrefix;
   }
}
