package com.uwb.session;

import java.util.*;
import java.rmi.*;
import javax.ejb.*;

import com.finalist.util.log.*;
import com.uwb.entity.address.*;
import com.uwb.dao.AddressDAO;
import com.uwb.entity.apartment.*;
import com.uwb.dao.ApartmentDAO;
import com.uwb.entity.contact.*;
import com.uwb.dao.ContactDAO;
import com.uwb.entity.deals.*;
import com.uwb.dao.DealsDAO;
import com.uwb.entity.units.*;
import com.uwb.dao.UnitsDAO;


/**
 * The <code>ApartmentService</code> session bean, which acts as a facade to the
 * underlying entity beans and read-only DAO classes.
 * <p>
 * This class uses the <a href="http://java.sun.com/blueprints/patterns/FastLaneReader.html">Fast Lane Reader</a>
 * J2EE design pattern.  If enabled, collections of read-only data are accessed directly from the datastore
 * using JDBC, thus avoiding the EJB layer and unnecessarily expensive calls to entity bean finder methods.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.23 $, $Date: 2005/08/21 13:04:12 $
 * @ejb.bean name="ApartmentService"
 *           view-type="remote"
 *           local-jndi-name="ejb/com/uwb/session/ApartmentService"
 *           jndi-name="ejb/com/uwb/session/ApartmentService"
 *           type="Stateless"
 *
 * @ejb.transaction-type type="Container"
 * @ejb.util generate="physical"
 * @ejb.ejb-ref ejb-name="Address"
 *              view-type="local"
 *              ref-name="ejb/Address"
 *
 * @ejb.util generate="physical"
 * @ejb.ejb-ref ejb-name="Apartment"
 *              view-type="local"
 *              ref-name="ejb/Apartment"
 *
 * @ejb.util generate="physical"
 * @ejb.ejb-ref ejb-name="Contact"
 *              view-type="local"
 *              ref-name="ejb/Contact"
 *
 * @ejb.util generate="physical"
 * @ejb.ejb-ref ejb-name="Deals"
 *              view-type="local"
 *              ref-name="ejb/Deals"
 *
 * @ejb.util generate="physical"
 * @ejb.ejb-ref ejb-name="Units"
 *              view-type="local"
 *              ref-name="ejb/Units"
 *
 */
public class ApartmentServiceEJB implements SessionBean, ApartmentServiceService  {
   /**
    * Configures whether or not the getXXXList methods use the Fast Lane Reader pattern.
    */
   private boolean useFastLane = true;

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ApartmentServiceEJB.class);

   /**
    * The bean context.
    */
   private SessionContext context = null;

   /**
    * The addressHome property.
    */
   private AddressLocalHome addressHome = null;

   /**
    * The apartmentHome property.
    */
   private ApartmentLocalHome apartmentHome = null;

   /**
    * The contactHome property.
    */
   private ContactLocalHome contactHome = null;

   /**
    * The dealsHome property.
    */
   private DealsLocalHome dealsHome = null;

   /**
    * The unitsHome property.
    */
   private UnitsLocalHome unitsHome = null;



   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/


   /**
    * Adds a new address to the database.
    *
    * @param model a data object
    * @return AddressIf a data object with the primary key
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public com.uwb.entity.address.AddressIf addAddress(com.uwb.entity.address.AddressIf model) {
      try {
         getReferences();
         return addressHome.create((com.uwb.entity.address.AddressData)model).getAddressData();
      }
      catch (CreateException exc) {
         log.error("Create exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Stores the <code>AddressIf</code> in the database.
    *
    * @param model the data model to store
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public void saveAddress(com.uwb.entity.address.AddressIf model) {
      try {
         log.debug("Saving data: " + (com.uwb.entity.address.AddressData) model);      
         getReferences();
         java.lang.Integer id = model.getId();
         com.uwb.entity.address.AddressLocal addressRef = addressHome.findByPrimaryKey(id);
         addressRef.setAddressData((com.uwb.entity.address.AddressData) model);
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
    }

   /**
    * Removes a address.
    *
    * @param id the unique reference for the address
    * @ejb.interface-method
    * @ejb.transaction type="Required"
    */
   public void deleteAddress(java.lang.Integer id) {
      try {
         getReferences();
         addressHome.remove(id);
      }
      catch (RemoveException exc) {
         log.error("RemoveException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Adds a new apartment to the database.
    *
    * @param model a data object
    * @return ApartmentIf a data object with the primary key
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public com.uwb.entity.apartment.ApartmentIf addApartment(com.uwb.entity.apartment.ApartmentIf model) {
      try {
         getReferences();
         return apartmentHome.create((com.uwb.entity.apartment.ApartmentData)model).getApartmentData();
      }
      catch (CreateException exc) {
         log.error("Create exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Stores the <code>ApartmentIf</code> in the database.
    *
    * @param model the data model to store
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public void saveApartment(com.uwb.entity.apartment.ApartmentIf model) {
      try {
         log.debug("Saving data: " + (com.uwb.entity.apartment.ApartmentData) model);      
         getReferences();
         java.lang.Integer id = model.getId();
         com.uwb.entity.apartment.ApartmentLocal apartmentRef = apartmentHome.findByPrimaryKey(id);
         apartmentRef.setApartmentData((com.uwb.entity.apartment.ApartmentData) model);
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
    }

   /**
    * Removes a apartment.
    *
    * @param id the unique reference for the apartment
    * @ejb.interface-method
    * @ejb.transaction type="Required"
    */
   public void deleteApartment(java.lang.Integer id) {
      try {
         getReferences();
         apartmentHome.remove(id);
      }
      catch (RemoveException exc) {
         log.error("RemoveException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Adds a new contact to the database.
    *
    * @param model a data object
    * @return ContactIf a data object with the primary key
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public com.uwb.entity.contact.ContactIf addContact(com.uwb.entity.contact.ContactIf model) {
      try {
         getReferences();
         return contactHome.create((com.uwb.entity.contact.ContactData)model).getContactData();
      }
      catch (CreateException exc) {
         log.error("Create exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Stores the <code>ContactIf</code> in the database.
    *
    * @param model the data model to store
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public void saveContact(com.uwb.entity.contact.ContactIf model) {
      try {
         log.debug("Saving data: " + (com.uwb.entity.contact.ContactData) model);      
         getReferences();
         java.lang.Integer id = model.getId();
         com.uwb.entity.contact.ContactLocal contactRef = contactHome.findByPrimaryKey(id);
         contactRef.setContactData((com.uwb.entity.contact.ContactData) model);
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
    }

   /**
    * Removes a contact.
    *
    * @param id the unique reference for the contact
    * @ejb.interface-method
    * @ejb.transaction type="Required"
    */
   public void deleteContact(java.lang.Integer id) {
      try {
         getReferences();
         contactHome.remove(id);
      }
      catch (RemoveException exc) {
         log.error("RemoveException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Adds a new deals to the database.
    *
    * @param model a data object
    * @return DealsIf a data object with the primary key
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public com.uwb.entity.deals.DealsIf addDeals(com.uwb.entity.deals.DealsIf model) {
      try {
         getReferences();
         return dealsHome.create((com.uwb.entity.deals.DealsData)model).getDealsData();
      }
      catch (CreateException exc) {
         log.error("Create exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Stores the <code>DealsIf</code> in the database.
    *
    * @param model the data model to store
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public void saveDeals(com.uwb.entity.deals.DealsIf model) {
      try {
         log.debug("Saving data: " + (com.uwb.entity.deals.DealsData) model);      
         getReferences();
         java.lang.Integer id = model.getId();
         com.uwb.entity.deals.DealsLocal dealsRef = dealsHome.findByPrimaryKey(id);
         dealsRef.setDealsData((com.uwb.entity.deals.DealsData) model);
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
    }

   /**
    * Removes a deals.
    *
    * @param id the unique reference for the deals
    * @ejb.interface-method
    * @ejb.transaction type="Required"
    */
   public void deleteDeals(java.lang.Integer id) {
      try {
         getReferences();
         dealsHome.remove(id);
      }
      catch (RemoveException exc) {
         log.error("RemoveException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Adds a new units to the database.
    *
    * @param model a data object
    * @return UnitsIf a data object with the primary key
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public com.uwb.entity.units.UnitsIf addUnits(com.uwb.entity.units.UnitsIf model) {
      try {
         getReferences();
         return unitsHome.create((com.uwb.entity.units.UnitsData)model).getUnitsData();
      }
      catch (CreateException exc) {
         log.error("Create exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Stores the <code>UnitsIf</code> in the database.
    *
    * @param model the data model to store
    * @ejb.transaction type="Required"
    * @ejb.interface-method
    */
   public void saveUnits(com.uwb.entity.units.UnitsIf model) {
      try {
         log.debug("Saving data: " + (com.uwb.entity.units.UnitsData) model);      
         getReferences();
         java.lang.Integer id = model.getId();
         com.uwb.entity.units.UnitsLocal unitsRef = unitsHome.findByPrimaryKey(id);
         unitsRef.setUnitsData((com.uwb.entity.units.UnitsData) model);
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
    }

   /**
    * Removes a units.
    *
    * @param id the unique reference for the units
    * @ejb.interface-method
    * @ejb.transaction type="Required"
    */
   public void deleteUnits(java.lang.Integer id) {
      try {
         getReferences();
         unitsHome.remove(id);
      }
      catch (RemoveException exc) {
         log.error("RemoveException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return AddressIf the data object
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public com.uwb.entity.address.AddressIf getAddress(java.lang.Integer id) {
      try {
         getReferences();
         return addressHome.findByPrimaryKey(id).getAddressData();
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a collection of all address instances.
    *
    * @return a collection of AddressIf objects.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getAddressList() {
      if (useFastLane) {
         return AddressDAO.getInstance().getAddressList();
      }

      try {
         getReferences();
         Collection collection = addressHome.findAll();
         Iterator   iterator   = collection.iterator();
         ArrayList  resultList = new ArrayList(collection.size());
         while (iterator.hasNext()) {
            com.uwb.entity.address.AddressLocal addressRef =
                  (com.uwb.entity.address.AddressLocal) iterator.next();
            resultList.add(addressRef.getAddressData());
         }
         return resultList;
      }
      catch (FinderException exc) {
         log.error("FinderException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a subset of all address instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of address instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getAddressListSize()</code> = last record),
    * any values greater than or equal to the total number of address instances will cause
    * the full set to be returned.
    * @return a collection of AddressIf objects, of size <code>(endIndex - startIndex)</code>.
    * throws EJBException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getAddressList(int startIndex, int endIndex) {
      if (useFastLane) {
         return AddressDAO.getInstance().getAddressList(startIndex, endIndex);
      }
      else {
         throw new EJBException("Entity bean finder methods do not support partial result sets (yet).");
      }
   }

   /**
    * Obtains the total number of address objects in the database.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public int getAddressListSize() {
      if (useFastLane) {
         return AddressDAO.getInstance().getAddressListSize();
      }
      else {
         return getAddressList().size();
      }
   }
   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return ApartmentIf the data object
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public com.uwb.entity.apartment.ApartmentIf getApartment(java.lang.Integer id) {
      try {
         getReferences();
         return apartmentHome.findByPrimaryKey(id).getApartmentData();
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a collection of all apartment instances.
    *
    * @return a collection of ApartmentIf objects.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getApartmentList() {
      if (useFastLane) {
         return ApartmentDAO.getInstance().getApartmentList();
      }

      try {
         getReferences();
         Collection collection = apartmentHome.findAll();
         Iterator   iterator   = collection.iterator();
         ArrayList  resultList = new ArrayList(collection.size());
         while (iterator.hasNext()) {
            com.uwb.entity.apartment.ApartmentLocal apartmentRef =
                  (com.uwb.entity.apartment.ApartmentLocal) iterator.next();
            resultList.add(apartmentRef.getApartmentData());
         }
         return resultList;
      }
      catch (FinderException exc) {
         log.error("FinderException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a subset of all apartment instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of apartment instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getApartmentListSize()</code> = last record),
    * any values greater than or equal to the total number of apartment instances will cause
    * the full set to be returned.
    * @return a collection of ApartmentIf objects, of size <code>(endIndex - startIndex)</code>.
    * throws EJBException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getApartmentList(int startIndex, int endIndex) {
      if (useFastLane) {
         return ApartmentDAO.getInstance().getApartmentList(startIndex, endIndex);
      }
      else {
         throw new EJBException("Entity bean finder methods do not support partial result sets (yet).");
      }
   }

   /**
    * Obtains the total number of apartment objects in the database.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public int getApartmentListSize() {
      if (useFastLane) {
         return ApartmentDAO.getInstance().getApartmentListSize();
      }
      else {
         return getApartmentList().size();
      }
   }
   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return ContactIf the data object
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public com.uwb.entity.contact.ContactIf getContact(java.lang.Integer id) {
      try {
         getReferences();
         return contactHome.findByPrimaryKey(id).getContactData();
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a collection of all contact instances.
    *
    * @return a collection of ContactIf objects.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getContactList() {
      if (useFastLane) {
         return ContactDAO.getInstance().getContactList();
      }

      try {
         getReferences();
         Collection collection = contactHome.findAll();
         Iterator   iterator   = collection.iterator();
         ArrayList  resultList = new ArrayList(collection.size());
         while (iterator.hasNext()) {
            com.uwb.entity.contact.ContactLocal contactRef =
                  (com.uwb.entity.contact.ContactLocal) iterator.next();
            resultList.add(contactRef.getContactData());
         }
         return resultList;
      }
      catch (FinderException exc) {
         log.error("FinderException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a subset of all contact instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of contact instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getContactListSize()</code> = last record),
    * any values greater than or equal to the total number of contact instances will cause
    * the full set to be returned.
    * @return a collection of ContactIf objects, of size <code>(endIndex - startIndex)</code>.
    * throws EJBException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getContactList(int startIndex, int endIndex) {
      if (useFastLane) {
         return ContactDAO.getInstance().getContactList(startIndex, endIndex);
      }
      else {
         throw new EJBException("Entity bean finder methods do not support partial result sets (yet).");
      }
   }

   /**
    * Obtains the total number of contact objects in the database.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public int getContactListSize() {
      if (useFastLane) {
         return ContactDAO.getInstance().getContactListSize();
      }
      else {
         return getContactList().size();
      }
   }
   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return DealsIf the data object
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public com.uwb.entity.deals.DealsIf getDeals(java.lang.Integer id) {
      try {
         getReferences();
         return dealsHome.findByPrimaryKey(id).getDealsData();
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a collection of all deals instances.
    *
    * @return a collection of DealsIf objects.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getDealsList() {
      if (useFastLane) {
         return DealsDAO.getInstance().getDealsList();
      }

      try {
         getReferences();
         Collection collection = dealsHome.findAll();
         Iterator   iterator   = collection.iterator();
         ArrayList  resultList = new ArrayList(collection.size());
         while (iterator.hasNext()) {
            com.uwb.entity.deals.DealsLocal dealsRef =
                  (com.uwb.entity.deals.DealsLocal) iterator.next();
            resultList.add(dealsRef.getDealsData());
         }
         return resultList;
      }
      catch (FinderException exc) {
         log.error("FinderException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a subset of all deals instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of deals instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getDealsListSize()</code> = last record),
    * any values greater than or equal to the total number of deals instances will cause
    * the full set to be returned.
    * @return a collection of DealsIf objects, of size <code>(endIndex - startIndex)</code>.
    * throws EJBException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getDealsList(int startIndex, int endIndex) {
      if (useFastLane) {
         return DealsDAO.getInstance().getDealsList(startIndex, endIndex);
      }
      else {
         throw new EJBException("Entity bean finder methods do not support partial result sets (yet).");
      }
   }

   /**
    * Obtains the total number of deals objects in the database.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public int getDealsListSize() {
      if (useFastLane) {
         return DealsDAO.getInstance().getDealsListSize();
      }
      else {
         return getDealsList().size();
      }
   }
   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return UnitsIf the data object
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public com.uwb.entity.units.UnitsIf getUnits(java.lang.Integer id) {
      try {
         getReferences();
         return unitsHome.findByPrimaryKey(id).getUnitsData();
      }
      catch (FinderException exc) {
         log.error("Finder Exception", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a collection of all units instances.
    *
    * @return a collection of UnitsIf objects.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getUnitsList() {
      if (useFastLane) {
         return UnitsDAO.getInstance().getUnitsList();
      }

      try {
         getReferences();
         Collection collection = unitsHome.findAll();
         Iterator   iterator   = collection.iterator();
         ArrayList  resultList = new ArrayList(collection.size());
         while (iterator.hasNext()) {
            com.uwb.entity.units.UnitsLocal unitsRef =
                  (com.uwb.entity.units.UnitsLocal) iterator.next();
            resultList.add(unitsRef.getUnitsData());
         }
         return resultList;
      }
      catch (FinderException exc) {
         log.error("FinderException", exc);
         throw new EJBException(exc.getMessage());
      }
   }

   /**
    * Returns a subset of all units instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of units instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUnitsListSize()</code> = last record),
    * any values greater than or equal to the total number of units instances will cause
    * the full set to be returned.
    * @return a collection of UnitsIf objects, of size <code>(endIndex - startIndex)</code>.
    * throws EJBException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public Collection getUnitsList(int startIndex, int endIndex) {
      if (useFastLane) {
         return UnitsDAO.getInstance().getUnitsList(startIndex, endIndex);
      }
      else {
         throw new EJBException("Entity bean finder methods do not support partial result sets (yet).");
      }
   }

   /**
    * Obtains the total number of units objects in the database.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    * @ejb.transaction type="Supports"
    * @ejb.interface-method
    */
   public int getUnitsListSize() {
      if (useFastLane) {
         return UnitsDAO.getInstance().getUnitsListSize();
      }
      else {
         return getUnitsList().size();
      }
   }


    /**
     * Retrieves a list of data object for the specified addresscol field.
     *
     * @param addresscol the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findAddressByAddresscol(java.lang.String addresscol) {
       try {
          getReferences();
          java.util.Collection list = addressHome.findByAddresscol(addresscol);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              AddressLocal el = (AddressLocal) iterator.next();
              result.add(el.getAddressData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified city field.
     *
     * @param city the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findAddressByCity(java.lang.String city) {
       try {
          getReferences();
          java.util.Collection list = addressHome.findByCity(city);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              AddressLocal el = (AddressLocal) iterator.next();
              result.add(el.getAddressData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified state field.
     *
     * @param state the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findAddressByState(java.lang.String state) {
       try {
          getReferences();
          java.util.Collection list = addressHome.findByState(state);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              AddressLocal el = (AddressLocal) iterator.next();
              result.add(el.getAddressData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified zipcode field.
     *
     * @param zipcode the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findAddressByZipcode(java.lang.String zipcode) {
       try {
          getReferences();
          java.util.Collection list = addressHome.findByZipcode(zipcode);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              AddressLocal el = (AddressLocal) iterator.next();
              result.add(el.getAddressData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findAddressByApartmentid(java.lang.Integer apartmentid) {
       try {
          getReferences();
          java.util.Collection list = addressHome.findByApartmentid(apartmentid);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              AddressLocal el = (AddressLocal) iterator.next();
              result.add(el.getAddressData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified name field.
     *
     * @param name the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findApartmentByName(java.lang.String name) {
       try {
          getReferences();
          java.util.Collection list = apartmentHome.findByName(name);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ApartmentLocal el = (ApartmentLocal) iterator.next();
              result.add(el.getApartmentData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified owner field.
     *
     * @param owner the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findApartmentByOwner(java.lang.String owner) {
       try {
          getReferences();
          java.util.Collection list = apartmentHome.findByOwner(owner);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ApartmentLocal el = (ApartmentLocal) iterator.next();
              result.add(el.getApartmentData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findApartmentByDescription(java.lang.String description) {
       try {
          getReferences();
          java.util.Collection list = apartmentHome.findByDescription(description);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ApartmentLocal el = (ApartmentLocal) iterator.next();
              result.add(el.getApartmentData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified imageurl field.
     *
     * @param imageurl the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findApartmentByImageurl(java.lang.String imageurl) {
       try {
          getReferences();
          java.util.Collection list = apartmentHome.findByImageurl(imageurl);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ApartmentLocal el = (ApartmentLocal) iterator.next();
              result.add(el.getApartmentData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified parking field.
     *
     * @param parking the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findApartmentByParking(java.lang.String parking) {
       try {
          getReferences();
          java.util.Collection list = apartmentHome.findByParking(parking);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ApartmentLocal el = (ApartmentLocal) iterator.next();
              result.add(el.getApartmentData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified representative field.
     *
     * @param representative the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findContactByRepresentative(java.lang.String representative) {
       try {
          getReferences();
          java.util.Collection list = contactHome.findByRepresentative(representative);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ContactLocal el = (ContactLocal) iterator.next();
              result.add(el.getContactData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified phone field.
     *
     * @param phone the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findContactByPhone(java.lang.String phone) {
       try {
          getReferences();
          java.util.Collection list = contactHome.findByPhone(phone);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ContactLocal el = (ContactLocal) iterator.next();
              result.add(el.getContactData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified email field.
     *
     * @param email the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findContactByEmail(java.lang.String email) {
       try {
          getReferences();
          java.util.Collection list = contactHome.findByEmail(email);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ContactLocal el = (ContactLocal) iterator.next();
              result.add(el.getContactData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified openhour field.
     *
     * @param openhour the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findContactByOpenhour(java.lang.String openhour) {
       try {
          getReferences();
          java.util.Collection list = contactHome.findByOpenhour(openhour);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ContactLocal el = (ContactLocal) iterator.next();
              result.add(el.getContactData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findContactByApartmentid(java.lang.Integer apartmentid) {
       try {
          getReferences();
          java.util.Collection list = contactHome.findByApartmentid(apartmentid);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              ContactLocal el = (ContactLocal) iterator.next();
              result.add(el.getContactData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return Collection of DealsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findDealsByDescription(java.lang.String description) {
       try {
          getReferences();
          java.util.Collection list = dealsHome.findByDescription(description);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              DealsLocal el = (DealsLocal) iterator.next();
              result.add(el.getDealsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of DealsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findDealsByApartmentid(java.lang.Integer apartmentid) {
       try {
          getReferences();
          java.util.Collection list = dealsHome.findByApartmentid(apartmentid);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              DealsLocal el = (DealsLocal) iterator.next();
              result.add(el.getDealsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified number field.
     *
     * @param number the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsByNumber(java.lang.String number) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findByNumber(number);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified squareft field.
     *
     * @param squareft the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsBySquareft(java.lang.String squareft) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findBySquareft(squareft);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified type field.
     *
     * @param type the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsByType(java.lang.String type) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findByType(type);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified rent field.
     *
     * @param rent the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsByRent(java.math.BigDecimal rent) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findByRent(rent);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified avalibility field.
     *
     * @param avalibility the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsByAvalibility(java.sql.Timestamp avalibility) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findByAvalibility(avalibility);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }

    /**
     * Retrieves a list of data object for the specified apertmentid field.
     *
     * @param apertmentid the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     * @ejb.transaction type="Supports"
     * @ejb.interface-method
     */
    public java.util.Collection findUnitsByApertmentid(java.lang.Integer apertmentid) {
       try {
          getReferences();
          java.util.Collection list = unitsHome.findByApertmentid(apertmentid);
          ArrayList result = new ArrayList();
          for (Iterator iterator = list.iterator(); iterator.hasNext();) {
              UnitsLocal el = (UnitsLocal) iterator.next();
              result.add(el.getUnitsData());
          }
          return result;
       }
       catch (FinderException exc) {
          log.error("Finder Exception", exc);
          throw new EJBException(exc.getMessage());
       }
    }


   /**
    * Retrieves an instance of the home interface.
    */
   private void getReferences() {
      try {
         if (addressHome == null) {
            addressHome = AddressUtil.getLocalHome();

         }
      }
      catch (javax.naming.NamingException ne) {
         log.error("NamingException", ne);
      }

      try {
         if (apartmentHome == null) {
            apartmentHome = ApartmentUtil.getLocalHome();

         }
      }
      catch (javax.naming.NamingException ne) {
         log.error("NamingException", ne);
      }

      try {
         if (contactHome == null) {
            contactHome = ContactUtil.getLocalHome();

         }
      }
      catch (javax.naming.NamingException ne) {
         log.error("NamingException", ne);
      }

      try {
         if (dealsHome == null) {
            dealsHome = DealsUtil.getLocalHome();

         }
      }
      catch (javax.naming.NamingException ne) {
         log.error("NamingException", ne);
      }

      try {
         if (unitsHome == null) {
            unitsHome = UnitsUtil.getLocalHome();

         }
      }
      catch (javax.naming.NamingException ne) {
         log.error("NamingException", ne);
      }

   }

   /*******************************************************************************************************************
    *                            C O N T A I N E R   C A L L B A C K S   M E T H O D S
    *******************************************************************************************************************/

   /**
    * Method that allows for the container to create a bean instance.
    *
    * @throws CreateException when the bean could not be created.
    */
   public void ejbCreate() throws CreateException {
   }

   /**
    * A container invokes this method before it ends the life of the session object. This happens as a result of a
    * client's invoking a remove operation, or when a container decides to terminate the session object after a timeout.
    * <P>This method is called with no transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    * @throws RemoteException This exception is defined in the method signature to provide backward compatibility for
    *                         enterprise beans written for the EJB 1.0 specification. Enterprise beans written for the
    *                         EJB 1.1 specification should throw the javax.ejb.EJBException instead of this exception.
    *                         Enterprise beans written for the EJB2.0 and higher specifications must throw the
    *                         <code>javax.ejb.EJBException</code> instead of this exception.
    */
   public void ejbRemove() throws EJBException, RemoteException {
   }

   /**
    * The activate method is called when the instance is activated from its "passive" state. The instance should
    * acquire any resource that it has released earlier in the ejbPassivate() method.<p>This method is called with no
    * transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    * @throws RemoteException This exception is defined in the method signature to provide backward compatibility for
    *                         enterprise beans written for the EJB 1.0 specification. Enterprise beans written for the
    *                         EJB 1.1 specification should throw the javax.ejb.EJBException instead of this exception.
    *                         Enterprise beans written for the EJB2.0 and higher specifications must throw the
    *                         <code>javax.ejb.EJBException</code> instead of this exception.
    */
   public void ejbActivate() throws EJBException, RemoteException {
   }

   /**
    * The passivate method is called before the instance enters the "passive" state. The instance should release
    * any resources that it can re-acquire later in the ejbActivate() method.<p>After the passivate method completes,
    * the instance must be in a state that allows the container to use the Java Serialization protocol to externalize
    * and store away the instance's state.<p>This method is called with no transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    * @throws RemoteException This exception is defined in the method signature to provide backward compatibility for
    *                         enterprise beans written for the EJB 1.0 specification. Enterprise beans written for the
    *                         EJB 1.1 specification should throw the javax.ejb.EJBException instead of this exception.
    *                         Enterprise beans written for the EJB2.0 and higher specifications must throw the
    *                         <code>javax.ejb.EJBException</code> instead of this exception.
    */
   public void ejbPassivate() throws EJBException, RemoteException {
   }

   /**
    * Set the associated session context. The container calls this method after the instance creation.<p>The
    * enterprise Bean instance should store the reference to the context object in an instance variable.<p> This
    * method is called with no transaction context.
    *
    * @param context A <code>SessionContext</code> interface for the instance.
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    * @throws RemoteException This exception is defined in the method signature to provide backward compatibility for
    *                         enterprise beans written for the EJB 1.0 specification. Enterprise beans written for the
    *                         EJB 1.1 specification should throw the javax.ejb.EJBException instead of this exception.
    *                         Enterprise beans written for the EJB2.0 and higher specifications must throw the
    *                         <code>javax.ejb.EJBException</code> instead of this exception.
    */
   public void setSessionContext(SessionContext context) throws EJBException, RemoteException {
      this.context = context;
   }
}
