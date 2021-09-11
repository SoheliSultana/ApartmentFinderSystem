package com.uwb.dao;

import com.uwb.QueryHelper;
import com.uwb.entity.deals.DealsBean;
import com.uwb.entity.deals.DealsData;
import com.finalist.util.CountBean;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.Iterator;
import java.util.List;


/**
 * Read-only Data Access Object for retrieving DealsData value objects directly using JDBC.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $,
 */
public class DealsDAO {
   /**
    * The Logger.
    */
   private static Logger log = LogService.getLogger(DealsDAO.class);
   /**
    * The Deals list query.
    */
   private static String selectDealsListQuery;
   /**
    * The Deals select query.
    */
   private static String selectDealsQuery;
   /**
    * The Deals count query.
    */
   private static String countDealsQuery;
   /**
    * The Deals DAO.
    */
   private static DealsDAO instance;

   /**
    * Maximum result size of a list query.
    */
   public static int MAX_RESULTS = 1000;

   //instantiate the DAO when the class is loaded.
   static {
         instance = new DealsDAO();
         selectDealsListQuery = createSql();
         StringBuffer temp = new StringBuffer(selectDealsListQuery);
         temp.append(" WHERE id = :ID");

         selectDealsQuery = temp.toString();
         countDealsQuery = "SELECT COUNT(*) AS value FROM " + DealsBean.TABLE_NAME;
   }

   /**
    * Private constructor of the DAO.
    */
   private DealsDAO() { }


   /**
    * Obtains the singleton instance of the DealsDAO.
    * @return the DAO.
    */
   public static synchronized DealsDAO getInstance() {
      return instance;
   }

   /**
    * Gets an individual deals, given its primary key.
    *
    * @param id the Id
    * @return DealsData value object
    */
   public DealsData getDeals(java.lang.Integer id) {
      if (id == null) {
         return null;
      }
      DealsData deals;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectDealsQuery);
         q.setBindVar("ID", id);

         deals = (DealsData) q.executeQueryIntoBean(DealsData.class).get(0);

         return deals;

      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Deals objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   public List getDealsList(int startIndex, int endIndex) {
      return getList(startIndex, endIndex);
   }

   /**
    * Creates a list of beans containing deals information,
    * one for every deals.
    *
    * @return the deals list.
    */
   public List getDealsList() {
      return getList(-1, -1);
   }

   /**
    * Obtains the total number of Deals objects in the database.
    *
    * @return an integer value.
    */
   public static int getDealsListSize() {
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(countDealsQuery);
         return ((CountBean) q.executeQueryIntoBean(CountBean.class).get(0)).getValue();
      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Deals objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   private List getList(int startIndex, int endIndex) {
      List result;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectDealsListQuery);

         //todo : This code should be removed once "View List Handler" pattern implemented!
         if (getDealsListSize() > MAX_RESULTS) {
         log.warn("---RESTRICTING RESULT SET SIZE TO " + MAX_RESULTS + "---");
            startIndex = 0;
            endIndex = MAX_RESULTS;
         }

         result = (startIndex == -1) 
               ? q.executeQueryIntoBean(DealsData.class) 
               : q.executeQueryIntoBean(DealsData.class, startIndex, endIndex).getPartialResult();
         return result;
      }
      finally {
         q.close();
      }
   }
   /**
    * Create SQL dynamically form the entity ejb fields.
    *
    * @return String with sql command.
    */
   private static String createSql() {
      StringBuffer temp = new StringBuffer("SELECT ");
      Iterator fields = DealsBean.COLUMNS_MAP.keySet().iterator();
      while (fields.hasNext()) {
         String field = (String) fields.next();
         temp.append(DealsBean.COLUMNS_MAP.get(field));
         temp.append(" AS \"");
         temp.append(field);
         temp.append("\",");
      }
      temp.deleteCharAt(temp.lastIndexOf(","));
      temp.append(" FROM ");
      temp.append(DealsBean.TABLE_NAME);
      log.info("Created SQL: " + temp.toString());
      return temp.toString();
   }
}
