package com.uwb.entity.apartment;

import java.io.Serializable;


/**
 * The ApartmentData objects extends the generated Value object.
 * Put here your presentation specific code.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.8 $, $Date: 2005/07/08 17:09:50 $
 */
public class ApartmentData implements ApartmentIf, Serializable    {

   /**
    * Default constructor.
    */
   public ApartmentData() {
   }

   /**
    * Value object constructor.
    */
   public ApartmentData(com.uwb.entity.apartment.ApartmentIf value) {
      setId(value.getId());
      setName(value.getName());
      setOwner(value.getOwner());
      setDescription(value.getDescription());
      setImageurl(value.getImageurl());
      setParking(value.getParking());
   }


   private java.lang.Integer id;

   /**
    * Returns the value of the <code>id</code> property.
    *
    * @return the value of the <code>id</code> property.
    */
   public java.lang.Integer getId() {
      return id;
   }

   /**
    * Sets the value of the <code>id</code> property.
    *
    * @param id a value for <code>id</code>.
    */
   public void setId(java.lang.Integer id) {
      this.id = id;
   }

   private java.lang.String name;

   /**
    * Returns the value of the <code>name</code> property.
    *
    * @return the value of the <code>name</code> property.
    */
   public java.lang.String getName() {
      return name;
   }

   /**
    * Sets the value of the <code>name</code> property.
    *
    * @param name a value for <code>name</code>.
    */
   public void setName(java.lang.String name) {
      this.name = name;
   }

   private java.lang.String owner;

   /**
    * Returns the value of the <code>owner</code> property.
    *
    * @return the value of the <code>owner</code> property.
    */
   public java.lang.String getOwner() {
      return owner;
   }

   /**
    * Sets the value of the <code>owner</code> property.
    *
    * @param owner a value for <code>owner</code>.
    */
   public void setOwner(java.lang.String owner) {
      this.owner = owner;
   }

   private java.lang.String description;

   /**
    * Returns the value of the <code>description</code> property.
    *
    * @return the value of the <code>description</code> property.
    */
   public java.lang.String getDescription() {
      return description;
   }

   /**
    * Sets the value of the <code>description</code> property.
    *
    * @param description a value for <code>description</code>.
    */
   public void setDescription(java.lang.String description) {
      this.description = description;
   }

   private java.lang.String imageurl;

   /**
    * Returns the value of the <code>imageurl</code> property.
    *
    * @return the value of the <code>imageurl</code> property.
    */
   public java.lang.String getImageurl() {
      return imageurl;
   }

   /**
    * Sets the value of the <code>imageurl</code> property.
    *
    * @param imageurl a value for <code>imageurl</code>.
    */
   public void setImageurl(java.lang.String imageurl) {
      this.imageurl = imageurl;
   }

   private java.lang.String parking;

   /**
    * Returns the value of the <code>parking</code> property.
    *
    * @return the value of the <code>parking</code> property.
    */
   public java.lang.String getParking() {
      return parking;
   }

   /**
    * Sets the value of the <code>parking</code> property.
    *
    * @param parking a value for <code>parking</code>.
    */
   public void setParking(java.lang.String parking) {
      this.parking = parking;
   }


    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
    public java.lang.Integer getPrimaryKey() {
        return getId();
    }

    /**
     * Set the primary key.
     *
     * @param pk the primary key
     */
    public void setPrimaryKey(java.lang.Integer pk) {
       setId(pk);
    }


   public String getPrimaryKeyParameters() {
      String parameters = "";
      parameters += "&id=" + getId();
      return parameters;
   }





   public String toString() {
	  StringBuffer str = new StringBuffer("{");
	  str.append("id=" + getId()  + " ");
	  str.append("name=" + getName()  + " ");
	  str.append("owner=" + getOwner()  + " ");
	  str.append("description=" + getDescription()  + " ");
	  str.append("imageurl=" + getImageurl()  + " ");
	  str.append("parking=" + getParking()  + " ");
	  str.append('}');
	  return(str.toString());
   }
}
