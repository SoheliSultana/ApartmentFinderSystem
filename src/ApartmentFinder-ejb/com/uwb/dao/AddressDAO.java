package com.uwb.dao;

import com.uwb.QueryHelper;
import com.uwb.entity.address.AddressBean;
import com.uwb.entity.address.AddressData;
import com.finalist.util.CountBean;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.Iterator;
import java.util.List;


/**
 * Read-only Data Access Object for retrieving AddressData value objects directly using JDBC.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $,
 */
public class AddressDAO {
   /**
    * The Logger.
    */
   private static Logger log = LogService.getLogger(AddressDAO.class);
   /**
    * The Address list query.
    */
   private static String selectAddressListQuery;
   /**
    * The Address select query.
    */
   private static String selectAddressQuery;
   /**
    * The Address count query.
    */
   private static String countAddressQuery;
   /**
    * The Address DAO.
    */
   private static AddressDAO instance;

   /**
    * Maximum result size of a list query.
    */
   public static int MAX_RESULTS = 1000;

   //instantiate the DAO when the class is loaded.
   static {
         instance = new AddressDAO();
         selectAddressListQuery = createSql();
         StringBuffer temp = new StringBuffer(selectAddressListQuery);
         temp.append(" WHERE id = :ID");

         selectAddressQuery = temp.toString();
         countAddressQuery = "SELECT COUNT(*) AS value FROM " + AddressBean.TABLE_NAME;
   }

   /**
    * Private constructor of the DAO.
    */
   private AddressDAO() { }


   /**
    * Obtains the singleton instance of the AddressDAO.
    * @return the DAO.
    */
   public static synchronized AddressDAO getInstance() {
      return instance;
   }

   /**
    * Gets an individual address, given its primary key.
    *
    * @param id the Id
    * @return AddressData value object
    */
   public AddressData getAddress(java.lang.Integer id) {
      if (id == null) {
         return null;
      }
      AddressData address;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectAddressQuery);
         q.setBindVar("ID", id);

         address = (AddressData) q.executeQueryIntoBean(AddressData.class).get(0);

         return address;

      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Address objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   public List getAddressList(int startIndex, int endIndex) {
      return getList(startIndex, endIndex);
   }

   /**
    * Creates a list of beans containing address information,
    * one for every address.
    *
    * @return the address list.
    */
   public List getAddressList() {
      return getList(-1, -1);
   }

   /**
    * Obtains the total number of Address objects in the database.
    *
    * @return an integer value.
    */
   public static int getAddressListSize() {
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(countAddressQuery);
         return ((CountBean) q.executeQueryIntoBean(CountBean.class).get(0)).getValue();
      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Address objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   private List getList(int startIndex, int endIndex) {
      List result;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectAddressListQuery);

         //todo : This code should be removed once "View List Handler" pattern implemented!
         if (getAddressListSize() > MAX_RESULTS) {
         log.warn("---RESTRICTING RESULT SET SIZE TO " + MAX_RESULTS + "---");
            startIndex = 0;
            endIndex = MAX_RESULTS;
         }

         result = (startIndex == -1) 
               ? q.executeQueryIntoBean(AddressData.class) 
               : q.executeQueryIntoBean(AddressData.class, startIndex, endIndex).getPartialResult();
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
      Iterator fields = AddressBean.COLUMNS_MAP.keySet().iterator();
      while (fields.hasNext()) {
         String field = (String) fields.next();
         temp.append(AddressBean.COLUMNS_MAP.get(field));
         temp.append(" AS \"");
         temp.append(field);
         temp.append("\",");
      }
      temp.deleteCharAt(temp.lastIndexOf(","));
      temp.append(" FROM ");
      temp.append(AddressBean.TABLE_NAME);
      log.info("Created SQL: " + temp.toString());
      return temp.toString();
   }
}
