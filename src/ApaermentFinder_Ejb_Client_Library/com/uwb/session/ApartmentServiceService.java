package com.uwb.session;

/**
 * The <code>ApartmentServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.29 $, $Date: 2005/08/21 13:04:12 $
 */
public interface ApartmentServiceService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/


   /**
    * Adds a new address to the storage.
    *
    * @param model a data object
    * @return AddressIf a data object with the primary key
    */
   com.uwb.entity.address.AddressIf addAddress(com.uwb.entity.address.AddressIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Stores the <code>AddressIf</code>.
    *
    * @param model the data model to store
    */
   void saveAddress(com.uwb.entity.address.AddressIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Removes a address.
    *
    * @param id the unique reference for the address
    */
   void deleteAddress(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Adds a new apartment to the storage.
    *
    * @param model a data object
    * @return ApartmentIf a data object with the primary key
    */
   com.uwb.entity.apartment.ApartmentIf addApartment(com.uwb.entity.apartment.ApartmentIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Stores the <code>ApartmentIf</code>.
    *
    * @param model the data model to store
    */
   void saveApartment(com.uwb.entity.apartment.ApartmentIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Removes a apartment.
    *
    * @param id the unique reference for the apartment
    */
   void deleteApartment(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Adds a new contact to the storage.
    *
    * @param model a data object
    * @return ContactIf a data object with the primary key
    */
   com.uwb.entity.contact.ContactIf addContact(com.uwb.entity.contact.ContactIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Stores the <code>ContactIf</code>.
    *
    * @param model the data model to store
    */
   void saveContact(com.uwb.entity.contact.ContactIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Removes a contact.
    *
    * @param id the unique reference for the contact
    */
   void deleteContact(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Adds a new deals to the storage.
    *
    * @param model a data object
    * @return DealsIf a data object with the primary key
    */
   com.uwb.entity.deals.DealsIf addDeals(com.uwb.entity.deals.DealsIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Stores the <code>DealsIf</code>.
    *
    * @param model the data model to store
    */
   void saveDeals(com.uwb.entity.deals.DealsIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Removes a deals.
    *
    * @param id the unique reference for the deals
    */
   void deleteDeals(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Adds a new units to the storage.
    *
    * @param model a data object
    * @return UnitsIf a data object with the primary key
    */
   com.uwb.entity.units.UnitsIf addUnits(com.uwb.entity.units.UnitsIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Stores the <code>UnitsIf</code>.
    *
    * @param model the data model to store
    */
   void saveUnits(com.uwb.entity.units.UnitsIf model) throws com.uwb.exception.GenericBusinessException;

   /**
    * Removes a units.
    *
    * @param id the unique reference for the units
    */
   void deleteUnits(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return AddressIf the data object
    */
   com.uwb.entity.address.AddressIf getAddress(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Returns a collection of all address instances.
    *
    * @return a collection of AddressIf objects.
    */
   java.util.Collection getAddressList() throws com.uwb.exception.GenericBusinessException;

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
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.Collection getAddressList(int startIndex, int endIndex) throws com.uwb.exception.GenericBusinessException;

   /**
    * Obtains the total number of address objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getAddressListSize() throws com.uwb.exception.GenericBusinessException;
   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return ApartmentIf the data object
    */
   com.uwb.entity.apartment.ApartmentIf getApartment(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Returns a collection of all apartment instances.
    *
    * @return a collection of ApartmentIf objects.
    */
   java.util.Collection getApartmentList() throws com.uwb.exception.GenericBusinessException;

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
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.Collection getApartmentList(int startIndex, int endIndex) throws com.uwb.exception.GenericBusinessException;

   /**
    * Obtains the total number of apartment objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getApartmentListSize() throws com.uwb.exception.GenericBusinessException;
   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return ContactIf the data object
    */
   com.uwb.entity.contact.ContactIf getContact(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Returns a collection of all contact instances.
    *
    * @return a collection of ContactIf objects.
    */
   java.util.Collection getContactList() throws com.uwb.exception.GenericBusinessException;

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
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.Collection getContactList(int startIndex, int endIndex) throws com.uwb.exception.GenericBusinessException;

   /**
    * Obtains the total number of contact objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getContactListSize() throws com.uwb.exception.GenericBusinessException;
   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return DealsIf the data object
    */
   com.uwb.entity.deals.DealsIf getDeals(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Returns a collection of all deals instances.
    *
    * @return a collection of DealsIf objects.
    */
   java.util.Collection getDealsList() throws com.uwb.exception.GenericBusinessException;

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
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.Collection getDealsList(int startIndex, int endIndex) throws com.uwb.exception.GenericBusinessException;

   /**
    * Obtains the total number of deals objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getDealsListSize() throws com.uwb.exception.GenericBusinessException;
   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return UnitsIf the data object
    */
   com.uwb.entity.units.UnitsIf getUnits(java.lang.Integer id) throws com.uwb.exception.GenericBusinessException;

   /**
    * Returns a collection of all units instances.
    *
    * @return a collection of UnitsIf objects.
    */
   java.util.Collection getUnitsList() throws com.uwb.exception.GenericBusinessException;

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
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.Collection getUnitsList(int startIndex, int endIndex) throws com.uwb.exception.GenericBusinessException;

   /**
    * Obtains the total number of units objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUnitsListSize() throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified addresscol field.
     *
     * @param addresscol the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     */
    java.util.Collection findAddressByAddresscol(java.lang.String addresscol) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified city field.
     *
     * @param city the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     */
    java.util.Collection findAddressByCity(java.lang.String city) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified state field.
     *
     * @param state the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     */
    java.util.Collection findAddressByState(java.lang.String state) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified zipcode field.
     *
     * @param zipcode the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     */
    java.util.Collection findAddressByZipcode(java.lang.String zipcode) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of AddressIf data objects, empty list in case no results were found.
     */
    java.util.Collection findAddressByApartmentid(java.lang.Integer apartmentid) throws com.uwb.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified name field.
     *
     * @param name the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     */
    java.util.Collection findApartmentByName(java.lang.String name) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified owner field.
     *
     * @param owner the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     */
    java.util.Collection findApartmentByOwner(java.lang.String owner) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     */
    java.util.Collection findApartmentByDescription(java.lang.String description) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified imageurl field.
     *
     * @param imageurl the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     */
    java.util.Collection findApartmentByImageurl(java.lang.String imageurl) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified parking field.
     *
     * @param parking the field
     * @return Collection of ApartmentIf data objects, empty list in case no results were found.
     */
    java.util.Collection findApartmentByParking(java.lang.String parking) throws com.uwb.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified representative field.
     *
     * @param representative the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     */
    java.util.Collection findContactByRepresentative(java.lang.String representative) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified phone field.
     *
     * @param phone the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     */
    java.util.Collection findContactByPhone(java.lang.String phone) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified email field.
     *
     * @param email the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     */
    java.util.Collection findContactByEmail(java.lang.String email) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified openhour field.
     *
     * @param openhour the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     */
    java.util.Collection findContactByOpenhour(java.lang.String openhour) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of ContactIf data objects, empty list in case no results were found.
     */
    java.util.Collection findContactByApartmentid(java.lang.Integer apartmentid) throws com.uwb.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return Collection of DealsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findDealsByDescription(java.lang.String description) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified apartmentid field.
     *
     * @param apartmentid the field
     * @return Collection of DealsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findDealsByApartmentid(java.lang.Integer apartmentid) throws com.uwb.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified number field.
     *
     * @param number the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsByNumber(java.lang.String number) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified squareft field.
     *
     * @param squareft the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsBySquareft(java.lang.String squareft) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified type field.
     *
     * @param type the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsByType(java.lang.String type) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified rent field.
     *
     * @param rent the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsByRent(java.math.BigDecimal rent) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified avalibility field.
     *
     * @param avalibility the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsByAvalibility(java.sql.Timestamp avalibility) throws com.uwb.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified apertmentid field.
     *
     * @param apertmentid the field
     * @return Collection of UnitsIf data objects, empty list in case no results were found.
     */
    java.util.Collection findUnitsByApertmentid(java.lang.Integer apertmentid) throws com.uwb.exception.GenericBusinessException;

}
