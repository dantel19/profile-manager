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

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import it.univaq.incipict.profilemanager.business.CRUDService;
import it.univaq.incipict.profilemanager.business.DataTablesRequestGrid;
import it.univaq.incipict.profilemanager.business.DataTablesResponseGrid;
import it.univaq.incipict.profilemanager.business.ProfileManagerException;
import it.univaq.incipict.profilemanager.business.SearchField;

/**
 * 
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 * @param <PK>
 *           Primary Key of the Business Model
 * @param <MODEL>
 *           Generic Business Model
 */
public class JPACRUDService<PK, MODEL> implements CRUDService<PK, MODEL> {

   protected Class<MODEL> persistentClass;
   @PersistenceContext
   protected EntityManager em;
   
   @SuppressWarnings("unchecked")
   public JPACRUDService() {
      this.persistentClass  = (Class<MODEL>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
   }

   @Override
   @Transactional
   public List<MODEL> findAll() throws ProfileManagerException {
      String sql = "from " + persistentClass.getSimpleName() + " order by id";
      TypedQuery<MODEL> q = em.createQuery(sql, persistentClass);
      return q.getResultList();
   }

   @Override
   @Transactional(readOnly = true)
   public DataTablesResponseGrid<MODEL> findAllPaginated(DataTablesRequestGrid requestGrid)
         throws ProfileManagerException {

      StringBuilder sql = new StringBuilder();
      StringBuilder sqlCount = new StringBuilder();
      sql.append("select distinct e ");
      sql.append(" from ");
      sql.append(persistentClass.getSimpleName()).append(" as e ");
      sql.append(" ");
      sqlCount.append("select count(distinct e) from ");
      sqlCount.append(persistentClass.getSimpleName()).append(" as e ");
      sqlCount.append(" ");

      /* Single Column Search*/
      boolean addWhere = true;
      List<SearchField> searchFields = requestGrid.getSearchFields();
      for (SearchField sf : searchFields) {
         try {
            if (!sf.isEmpty() && ConversionUtility.isCollectionFieldType(persistentClass, sf.getName())) {
               sql.append(" join ").append(" e.").append(sf.getNameRoot()).append(" as ").append(sf.getAlias())
                     .append(" ");
               sqlCount.append(" join ").append(" e.").append(sf.getNameRoot()).append(" as ").append(sf.getAlias())
                     .append(" ");
            }
         } catch (NoSuchFieldException e) {
            throw new ProfileManagerException("No Such Search Field", e);
         }

      }

      for (SearchField sf : searchFields) {
         if (!sf.isEmpty()) {
            if (addWhere) {
               sql.append(" where ");
               sqlCount.append(" where ");
               addWhere = false;
            } else {
               sql.append(" and ");
               sqlCount.append(" and ");
            }
            try {

               if (ConversionUtility.isCollectionFieldType(persistentClass, sf.getName())) {
                  sql.append(sf.getNameAlias());
                  sqlCount.append(sf.getNameAlias());
               } else {
                  sql.append(" e.").append(sf.getName());
                  sqlCount.append(" e.").append(sf.getName());
               }

               if (sf.isIsNull()) {
                  sql.append(" IS NULL ");
                  sqlCount.append(" IS NULL ");
               } else if (sf.isIsNotNull()) {
                  sql.append(" IS NOT NULL ");
                  sqlCount.append(" IS NOT NULL ");
               } else {
                  String operand = ConversionUtility.getOperand(persistentClass, sf);
                  sql.append(operand);
                  sqlCount.append(operand);
                  if (sf.isRangeIn()) {
                     sql.append(" (:").append(sf.getNameParam()).append(") ");
                     sqlCount.append(" (:").append(sf.getNameParam()).append(") ");
                  } else {
                     sql.append(sf.getNameParam());
                     sqlCount.append(sf.getNameParam());
                  }
               }

            } catch (NoSuchFieldException e) {
               throw new ProfileManagerException("No Such Search Field", e);
            }
         }
      }
      
      /* Single Table Search */
      boolean addAnd = true;
      if (!"".equals(requestGrid.getsSearch())) {
         for (SearchField sf : searchFields) {
            if (addWhere) {
               sql.append(" where ");
               sqlCount.append(" where ");
               addWhere = false;
            } else {
               sql.append(" or ");
               sqlCount.append(" or ");
            }
            try {
               sql.append(" e.").append(sf.getName());
               sqlCount.append(" e.").append(sf.getName());
               String operand = ConversionUtility.getOperand(persistentClass, sf);
               sql.append(operand);
               sqlCount.append(operand);
               if (sf.isRangeIn()) {
                  sql.append(" (:").append("global_".concat(sf.getNameParam())).append(") ");
                  sqlCount.append(" (:").append("global_".concat(sf.getNameParam())).append(") ");
               } else {
                  sql.append("global_".concat(sf.getNameParam()));
                  sqlCount.append("global_".concat(sf.getNameParam()));
               }

            } catch (NoSuchFieldException e) {
               throw new ProfileManagerException("No Such Search Field", e);
            }
         }
         if (!addAnd) {
            sql.append(" ) ");
            sqlCount.append(" ) ");
         }
      }

      sql.append(" order by e.").append(requestGrid.getSortCol()).append(" ").append(requestGrid.getSortDir());

      TypedQuery<MODEL> query = em.createQuery(sql.toString(), persistentClass);
      Query queryCount = em.createQuery(sqlCount.toString());
      for (SearchField sf : searchFields) {
         if (!sf.isEmpty() && !sf.isIsNull() && !sf.isIsNotNull()) {
            try {
               query.setParameter(sf.getNameParam(), ConversionUtility.getParamObject(persistentClass, sf.getName(),
                     sf.getValue(), sf.isAddPercentPrefix(), !sf.isRange()));
               queryCount.setParameter(sf.getNameParam(), ConversionUtility.getParamObject(persistentClass,
                     sf.getName(), sf.getValue(), sf.isAddPercentPrefix(), !sf.isRange()));
            } catch (NoSuchFieldException e) {
               throw new ProfileManagerException("No Such Search Field", e);
            }
         }
      }
      
      if (!"".equals(requestGrid.getsSearch())) {

         for (SearchField sf : searchFields) {

            try {
               query.setParameter("global_".concat(sf.getNameParam()), ConversionUtility.getParamObject(persistentClass,
                     sf.getName(), requestGrid.getsSearch(), false, true));
               queryCount.setParameter("global_".concat(sf.getNameParam()), ConversionUtility
                     .getParamObject(persistentClass, sf.getName(), requestGrid.getsSearch(), false, true));
            } catch (NoSuchFieldException e) {
               throw new ProfileManagerException("No Such Search Field", e);
            }

         }
      }
      
      // Set First and Max query results
      if (requestGrid.getiDisplayStart() > 0) {
         query.setFirstResult(requestGrid.getiDisplayStart());
      }
      
      if (requestGrid.getiDisplayLength() > 0) {
         query.setMaxResults(requestGrid.getiDisplayLength());
      }

      List<MODEL> results = query.getResultList();
      
      long records = (Long) queryCount.getSingleResult();
      return new DataTablesResponseGrid<MODEL>(requestGrid.getsEcho(), records, records, results);
   }

   @Override
   @Transactional()
   public void create(MODEL model) throws ProfileManagerException {
      em.persist(model);
   }

   @Override
   @Transactional
   public MODEL findByPK(PK id) throws ProfileManagerException {
      return (MODEL) em.find(persistentClass, id);
   }

   @Override
   @Transactional()
   public void update(MODEL model) throws ProfileManagerException {
      em.merge(model);
   }

   @Override
   @Transactional()
   public void delete(MODEL model) throws ProfileManagerException {
      MODEL m = (MODEL) em.merge(model);
      em.remove(m);
   }
}
