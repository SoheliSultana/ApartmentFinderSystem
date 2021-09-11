package com.uwb.entity.apartment;


/**
 * The ApartmentIf interfaces exposes the persistence data.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public interface ApartmentIf {

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
    * Returns the value of the <code>name</code> property.
    *
    * @return the value of the <code>name</code> property
    */
   java.lang.String getName();

   /**
    * Sets the value of the <code>name</code> property.
    *
    * @param name the value for the <code>name</code> property
    */
   void setName(java.lang.String name);

   /**
    * Returns the value of the <code>owner</code> property.
    *
    * @return the value of the <code>owner</code> property
    */
   java.lang.String getOwner();

   /**
    * Sets the value of the <code>owner</code> property.
    *
    * @param owner the value for the <code>owner</code> property
    */
   void setOwner(java.lang.String owner);

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
    * Returns the value of the <code>imageurl</code> property.
    *
    * @return the value of the <code>imageurl</code> property
    */
   java.lang.String getImageurl();

   /**
    * Sets the value of the <code>imageurl</code> property.
    *
    * @param imageurl the value for the <code>imageurl</code> property
    */
   void setImageurl(java.lang.String imageurl);

   /**
    * Returns the value of the <code>parking</code> property.
    *
    * @return the value of the <code>parking</code> property
    */
   java.lang.String getParking();

   /**
    * Sets the value of the <code>parking</code> property.
    *
    * @param parking the value for the <code>parking</code> property
    */
   void setParking(java.lang.String parking);


}
