package com.uwb.entity.deals;


/**
 * The DealsIf interfaces exposes the persistence data.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public interface DealsIf {

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
    * Returns the value of the <code>description</code> property.
    *
    * @return the value of the <code>description</code> property
    */
   java.lang.String getDescription();

   /**
    * Sets the value of the <code>description</code> property.
    *
    * @param description the value for the <code>description</code> property
    */
   void setDescription(java.lang.String description);

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
