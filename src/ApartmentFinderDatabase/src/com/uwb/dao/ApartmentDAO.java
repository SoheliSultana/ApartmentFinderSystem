package com.uwb.dao;

import com.uwb.QueryHelper;
import com.uwb.entity.apartment.ApartmentBean;
import com.uwb.entity.apartment.ApartmentData;
import com.finalist.util.CountBean;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.Iterator;
import java.util.List;


/**
 * Read-only Data Access Object for retrieving ApartmentData value objects directly using JDBC.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $,
 */
public class ApartmentDAO {
   /**
    * The Logger.
    */
   private static Logger log = LogService.getLogger(ApartmentDAO.class);
   /**
    * The Apartment list query.
    */
   private static String selectApartmentListQuery;
   /**
    * The Apartment select query.
    */
   private static String selectApartmentQuery;
   /**
    * The Apartment count query.
    */
   private static String countApartmentQuery;
   /**
    * The Apartment DAO.
    */
   private static ApartmentDAO instance;

   /**
    * Maximum result size of a list query.
    */
   public static int MAX_RESULTS = 1000;

   //instantiate the DAO when the class is loaded.
   static {
         instance = new ApartmentDAO();
         selectApartmentListQuery = createSql();
         StringBuffer temp = new StringBuffer(selectApartmentListQuery);
         temp.append(" WHERE id = :ID");

         selectApartmentQuery = temp.toString();
         countApartmentQuery = "SELECT COUNT(*) AS value FROM " + ApartmentBean.TABLE_NAME;
   }

   /**
    * Private constructor of the DAO.
    */
   private ApartmentDAO() { }


   /**
    * Obtains the singleton instance of the ApartmentDAO.
    * @return the DAO.
    */
   public static synchronized ApartmentDAO getInstance() {
      return instance;
   }

   /**
    * Gets an individual apartment, given its primary key.
    *
    * @param id the Id
    * @return ApartmentData value object
    */
   public ApartmentData getApartment(java.lang.Integer id) {
      if (id == null) {
         return null;
      }
      ApartmentData apartment;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectApartmentQuery);
         q.setBindVar("ID", id);

         apartment = (ApartmentData) q.executeQueryIntoBean(ApartmentData.class).get(0);

         return apartment;

      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Apartment objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   public List getApartmentList(int startIndex, int endIndex) {
      return getList(startIndex, endIndex);
   }

   /**
    * Creates a list of beans containing apartment information,
    * one for every apartment.
    *
    * @return the apartment list.
    */
   public List getApartmentList() {
      return getList(-1, -1);
   }

   /**
    * Obtains the total number of Apartment objects in the database.
    *
    * @return an integer value.
    */
   public static int getApartmentListSize() {
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(countApartmentQuery);
         return ((CountBean) q.executeQueryIntoBean(CountBean.class).get(0)).getValue();
      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Apartment objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   private List getList(int startIndex, int endIndex) {
      List result;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectApartmentListQuery);

         //todo : This code should be removed once "View List Handler" pattern implemented!
         if (getApartmentListSize() > MAX_RESULTS) {
         log.warn("---RESTRICTING RESULT SET SIZE TO " + MAX_RESULTS + "---");
            startIndex = 0;
            endIndex = MAX_RESULTS;
         }

         result = (startIndex == -1) 
               ? q.executeQueryIntoBean(ApartmentData.class) 
               : q.executeQueryIntoBean(ApartmentData.class, startIndex, endIndex).getPartialResult();
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
      Iterator fields = ApartmentBean.COLUMNS_MAP.keySet().iterator();
      while (fields.hasNext()) {
         String field = (String) fields.next();
         temp.append(ApartmentBean.COLUMNS_MAP.get(field));
         temp.append(" AS \"");
         temp.append(field);
         temp.append("\",");
      }
      temp.deleteCharAt(temp.lastIndexOf(","));
      temp.append(" FROM ");
      temp.append(ApartmentBean.TABLE_NAME);
      log.info("Created SQL: " + temp.toString());
      return temp.toString();
   }
}
