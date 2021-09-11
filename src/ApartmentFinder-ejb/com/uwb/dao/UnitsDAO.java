package com.uwb.dao;

import com.uwb.QueryHelper;
import com.uwb.entity.units.UnitsBean;
import com.uwb.entity.units.UnitsData;
import com.finalist.util.CountBean;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.Iterator;
import java.util.List;


/**
 * Read-only Data Access Object for retrieving UnitsData value objects directly using JDBC.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $,
 */
public class UnitsDAO {
   /**
    * The Logger.
    */
   private static Logger log = LogService.getLogger(UnitsDAO.class);
   /**
    * The Units list query.
    */
   private static String selectUnitsListQuery;
   /**
    * The Units select query.
    */
   private static String selectUnitsQuery;
   /**
    * The Units count query.
    */
   private static String countUnitsQuery;
   /**
    * The Units DAO.
    */
   private static UnitsDAO instance;

   /**
    * Maximum result size of a list query.
    */
   public static int MAX_RESULTS = 1000;

   //instantiate the DAO when the class is loaded.
   static {
         instance = new UnitsDAO();
         selectUnitsListQuery = createSql();
         StringBuffer temp = new StringBuffer(selectUnitsListQuery);
         temp.append(" WHERE id = :ID");

         selectUnitsQuery = temp.toString();
         countUnitsQuery = "SELECT COUNT(*) AS value FROM " + UnitsBean.TABLE_NAME;
   }

   /**
    * Private constructor of the DAO.
    */
   private UnitsDAO() { }


   /**
    * Obtains the singleton instance of the UnitsDAO.
    * @return the DAO.
    */
   public static synchronized UnitsDAO getInstance() {
      return instance;
   }

   /**
    * Gets an individual units, given its primary key.
    *
    * @param id the Id
    * @return UnitsData value object
    */
   public UnitsData getUnits(java.lang.Integer id) {
      if (id == null) {
         return null;
      }
      UnitsData units;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectUnitsQuery);
         q.setBindVar("ID", id);

         units = (UnitsData) q.executeQueryIntoBean(UnitsData.class).get(0);

         return units;

      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Units objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   public List getUnitsList(int startIndex, int endIndex) {
      return getList(startIndex, endIndex);
   }

   /**
    * Creates a list of beans containing units information,
    * one for every units.
    *
    * @return the units list.
    */
   public List getUnitsList() {
      return getList(-1, -1);
   }

   /**
    * Obtains the total number of Units objects in the database.
    *
    * @return an integer value.
    */
   public static int getUnitsListSize() {
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(countUnitsQuery);
         return ((CountBean) q.executeQueryIntoBean(CountBean.class).get(0)).getValue();
      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Units objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   private List getList(int startIndex, int endIndex) {
      List result;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectUnitsListQuery);

         //todo : This code should be removed once "View List Handler" pattern implemented!
         if (getUnitsListSize() > MAX_RESULTS) {
         log.warn("---RESTRICTING RESULT SET SIZE TO " + MAX_RESULTS + "---");
            startIndex = 0;
            endIndex = MAX_RESULTS;
         }

         result = (startIndex == -1) 
               ? q.executeQueryIntoBean(UnitsData.class) 
               : q.executeQueryIntoBean(UnitsData.class, startIndex, endIndex).getPartialResult();
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
      Iterator fields = UnitsBean.COLUMNS_MAP.keySet().iterator();
      while (fields.hasNext()) {
         String field = (String) fields.next();
         temp.append(UnitsBean.COLUMNS_MAP.get(field));
         temp.append(" AS \"");
         temp.append(field);
         temp.append("\",");
      }
      temp.deleteCharAt(temp.lastIndexOf(","));
      temp.append(" FROM ");
      temp.append(UnitsBean.TABLE_NAME);
      log.info("Created SQL: " + temp.toString());
      return temp.toString();
   }
}
