package com.uwb.entity.contact;


/**
 * The ContactIf interfaces exposes the persistence data.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public interface ContactIf {

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer he primary key.
     */
    java.lang.Integer getPrimaryKey();

    /**
     * Set the primary key.
     *
     * @param pk return java.lang.Integer with the primary key.
     */
    void setPrimaryKey(java.lang.Integer pk);


   /**
    * Returns the value of the <code>id</code> property.
    *
    * @return the value of the <code>id</code> property
    */
   java.lang.Integer getId();

   /**
    * Sets the value of the <code>id</code> property.
    *
    * @param id the value for the <code>id</code> property
    */
   void setId(java.lang.Integer id);

   /**
    * Returns the value of the <code>representative</code> property.
    *
    * @return the value of the <code>representative</code> property
    */
   java.lang.String getRepresentative();

   /**
    * Sets the value of the <code>representative</code> property.
    *
    * @param representative the value for the <code>representative</code> property
    */
   void setRepresentative(java.lang.String representative);

   /**
    * Returns the value of the <code>phone</code> property.
    *
    * @return the value of the <code>phone</code> property
    */
   java.lang.String getPhone();

   /**
    * Sets the value of the <code>phone</code> property.
    *
    * @param phone the value for the <code>phone</code> property
    */
   void setPhone(java.lang.String phone);

   /**
    * Returns the value of the <code>email</code> property.
    *
    * @return the value of the <code>email</code> property
    */
   java.lang.String getEmail();

   /**
    * Sets the value of the <code>email</code> property.
    *
    * @param email the value for the <code>email</code> property
    */
   void setEmail(java.lang.String email);

   /**
    * Returns the value of the <code>openhour</code> property.
    *
    * @return the value of the <code>openhour</code> property
    */
   java.lang.String getOpenhour();

   /**
    * Sets the value of the <code>openhour</code> property.
    *
    * @param openhour the value for the <code>openhour</code> property
    */
   void setOpenhour(java.lang.String openhour);

   /**
    * Returns the value of the <code>apartmentid</code> property.
    *
    * @return the value of the <code>apartmentid</code> property
    */
   java.lang.Integer getApartmentid();

   /**
    * Sets the value of the <code>apartmentid</code> property.
    *
    * @param apartmentid the value for the <code>apartmentid</code> property
    */
   void setApartmentid(java.lang.Integer apartmentid);


}
