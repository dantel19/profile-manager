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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import it.univaq.incipict.profilemanager.business.SearchField;
import it.univaq.incipict.profilemanager.common.utility.Utility;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class ConversionUtility {
	
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static String addPercentSuffix(String s) {
		if (s == null || "".equals(s)) {
			return "%";
		}
		return s + "%";
	}

	public static String addPercentPrefix(String s) {
		if (s == null || "".equals(s)) {
			return "%";
		}
		return "%" + s;
	}

	public static String addPercentPrefixAndSuffix(String s) {
		if (s == null || "".equals(s)) {
			return "%";
		}
		return "%" + s + "%";
	}

	public static Class<?> getFieldType(Class<?> persistentClass, String name) throws NoSuchFieldException {
		String[] fields = StringUtils.delimitedListToStringArray(name, ".");
		Class<?> t;

		t = persistentClass.getDeclaredField(fields[0]).getType();

		if (Collection.class.isAssignableFrom(t)) {
			Field collectionField = persistentClass.getDeclaredField(fields[0]);
			ParameterizedType collectionType = (ParameterizedType) collectionField.getGenericType();
			t = (Class<?>) collectionType.getActualTypeArguments()[0];
		}
		if (fields.length == 1) {
			return t;
		} else {
			return getFieldType((Class<?>) t, name.substring(name.indexOf(".") + 1));
		}
	}

	public static boolean isCollectionFieldType(Class<?> persistentClass, String name) throws NoSuchFieldException {
		String[] fields = StringUtils.delimitedListToStringArray(name, ".");
		Class<?> t;

		t = persistentClass.getDeclaredField(fields[0]).getType();
		return Collection.class.isAssignableFrom(t);
	}

	public static String getOperand(Class<?> persistentClass, SearchField sf) throws NoSuchFieldException {
		Class<?> type = getFieldType(persistentClass, sf.getName());
		if (sf.isRangeIn()) {
			return " in ";
		}
		if (type.isPrimitive() || type.isMemberClass() || type.equals(Date.class)) {
			if (sf.isRangeFrom()) {
				return " >= :";
			}
			if (sf.isRangeTo()) {
				return " <= :";
			}
			return " = :";
		} else if (type.equals(String.class)) {
			return " like :";
		}
		return " = :";
	}

	public static Object getParamObject(Class<?> persistentClass, String name, String value, boolean addPercentPrefix, boolean addPercentSuffix) throws NoSuchFieldException {
		Class<?> type = getFieldType(persistentClass, name);
		List<Object> result = new ArrayList<Object>();
		String[] values = StringUtils.delimitedListToStringArray(value, SearchField.MULTIPLE_VALUE_SEPARATOR);
		for (String v : values) {
			if (type.equals(String.class)) {
				if (values.length > 1) {
					result.add(v);
				} else {
					if (addPercentPrefix) {
						if (addPercentSuffix) {
							v = addPercentPrefixAndSuffix(v);
						} else {
							v = addPercentPrefix(v);
						}

					} else if (addPercentSuffix) {
						v = addPercentSuffix(v);
					}
				}
				result.add(v);
			} else {

				if (type.equals(Long.class) || type.equals(long.class)) {
					try {
						result.add(Long.parseLong(v));
					} catch (NumberFormatException e) {
						result.add(new Long(0L));
					}
				} else if (type.equals(Integer.class) || type.equals(int.class)) {
					try {
						result.add(Integer.parseInt(v));
					} catch (NumberFormatException e) {
						result.add(new Integer(0));
					}

				} else if (type.equals(Double.class) || type.equals(double.class)) {
					try {
						result.add(Double.parseDouble(v));
					} catch (NumberFormatException e) {
						result.add(new Double(0D));
					}

				} else if (type.equals(Date.class)) {
					try {
						result.add(df.parse(value));
					} catch (ParseException ex) {
						result.add(Utility.actualDate());
					}
				} else if (type.equals(Boolean.class)) {
					System.out.println("ciao ciao");
					result.add(Boolean.parseBoolean(v));
				} else if (type.isEnum()) {
					try {
						Method m = type.getMethod("values");
						result.add(((Object[]) m.invoke(null, (Object[]) null))[Integer.parseInt(v)]);
					} catch (NoSuchMethodException ex) {
						// Logger.getLogger(ConversionUtility.class.getName()).log(Level.SEVERE,
						// null, ex);
					} catch (SecurityException ex) {
						// Logger.getLogger(ConversionUtility.class.getName()).log(Level.SEVERE,
						// null, ex);
					} catch (IllegalAccessException ex) {
						// Logger.getLogger(ConversionUtility.class.getName()).log(Level.SEVERE,
						// null, ex);
					} catch (IllegalArgumentException ex) {
						// Logger.getLogger(ConversionUtility.class.getName()).log(Level.SEVERE,
						// null, ex);
					} catch (InvocationTargetException ex) {
						// Logger.getLogger(ConversionUtility.class.getName()).log(Level.SEVERE,
						// null, ex);
					}
				}
			}
		}
		if (result.size() > 1) {
			return result;
		} else {
			return result.isEmpty() ? null : result.get(0);
		}

	}
}
