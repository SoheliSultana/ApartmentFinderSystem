package com.uwb.dao;

import com.uwb.QueryHelper;
import com.uwb.entity.contact.ContactBean;
import com.uwb.entity.contact.ContactData;
import com.finalist.util.CountBean;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.Iterator;
import java.util.List;


/**
 * Read-only Data Access Object for retrieving ContactData value objects directly using JDBC.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $,
 */
public class ContactDAO {
   /**
    * The Logger.
    */
   private static Logger log = LogService.getLogger(ContactDAO.class);
   /**
    * The Contact list query.
    */
   private static String selectContactListQuery;
   /**
    * The Contact select query.
    */
   private static String selectContactQuery;
   /**
    * The Contact count query.
    */
   private static String countContactQuery;
   /**
    * The Contact DAO.
    */
   private static ContactDAO instance;

   /**
    * Maximum result size of a list query.
    */
   public static int MAX_RESULTS = 1000;

   //instantiate the DAO when the class is loaded.
   static {
         instance = new ContactDAO();
         selectContactListQuery = createSql();
         StringBuffer temp = new StringBuffer(selectContactListQuery);
         temp.append(" WHERE id = :ID");

         selectContactQuery = temp.toString();
         countContactQuery = "SELECT COUNT(*) AS value FROM " + ContactBean.TABLE_NAME;
   }

   /**
    * Private constructor of the DAO.
    */
   private ContactDAO() { }


   /**
    * Obtains the singleton instance of the ContactDAO.
    * @return the DAO.
    */
   public static synchronized ContactDAO getInstance() {
      return instance;
   }

   /**
    * Gets an individual contact, given its primary key.
    *
    * @param id the Id
    * @return ContactData value object
    */
   public ContactData getContact(java.lang.Integer id) {
      if (id == null) {
         return null;
      }
      ContactData contact;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectContactQuery);
         q.setBindVar("ID", id);

         contact = (ContactData) q.executeQueryIntoBean(ContactData.class).get(0);

         return contact;

      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Contact objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   public List getContactList(int startIndex, int endIndex) {
      return getList(startIndex, endIndex);
   }

   /**
    * Creates a list of beans containing contact information,
    * one for every contact.
    *
    * @return the contact list.
    */
   public List getContactList() {
      return getList(-1, -1);
   }

   /**
    * Obtains the total number of Contact objects in the database.
    *
    * @return an integer value.
    */
   public static int getContactListSize() {
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(countContactQuery);
         return ((CountBean) q.executeQueryIntoBean(CountBean.class).get(0)).getValue();
      }
      finally {
         q.close();
      }
   }

   /**
    * Gets a list containing <i>a subset of</i> all Contact objects.
    *
    * @param startIndex the start index in the result set - 1 is the first result.
    * @param endIndex the end index in the result set.
    * @return List with value objects.
    */
   private List getList(int startIndex, int endIndex) {
      List result;
      QueryHelper q = new QueryHelper();
      try {
         q.prepareStatement(selectContactListQuery);

         //todo : This code should be removed once "View List Handler" pattern implemented!
         if (getContactListSize() > MAX_RESULTS) {
         log.warn("---RESTRICTING RESULT SET SIZE TO " + MAX_RESULTS + "---");
            startIndex = 0;
            endIndex = MAX_RESULTS;
         }

         result = (startIndex == -1) 
               ? q.executeQueryIntoBean(ContactData.class) 
               : q.executeQueryIntoBean(ContactData.class, startIndex, endIndex).getPartialResult();
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
      Iterator fields = ContactBean.COLUMNS_MAP.keySet().iterator();
      while (fields.hasNext()) {
         String field = (String) fields.next();
         temp.append(ContactBean.COLUMNS_MAP.get(field));
         temp.append(" AS \"");
         temp.append(field);
         temp.append("\",");
      }
      temp.deleteCharAt(temp.lastIndexOf(","));
      temp.append(" FROM ");
      temp.append(ContactBean.TABLE_NAME);
      log.info("Created SQL: " + temp.toString());
      return temp.toString();
   }
}
