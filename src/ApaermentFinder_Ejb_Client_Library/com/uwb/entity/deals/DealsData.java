package com.uwb.entity.deals;

import java.io.Serializable;


/**
 * The DealsData objects extends the generated Value object.
 * Put here your presentation specific code.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.8 $, $Date: 2005/07/08 17:09:50 $
 */
public class DealsData implements DealsIf, Serializable    {

   /**
    * Default constructor.
    */
   public DealsData() {
   }

   /**
    * Value object constructor.
    */
   public DealsData(com.uwb.entity.deals.DealsIf value) {
      setId(value.getId());
      setDescription(value.getDescription());
      setApartmentid(value.getApartmentid());
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

   private java.lang.Integer apartmentid;

   /**
    * Returns the value of the <code>apartmentid</code> property.
    *
    * @return the value of the <code>apartmentid</code> property.
    */
   public java.lang.Integer getApartmentid() {
      return apartmentid;
   }

   /**
    * Sets the value of the <code>apartmentid</code> property.
    *
    * @param apartmentid a value for <code>apartmentid</code>.
    */
   public void setApartmentid(java.lang.Integer apartmentid) {
      this.apartmentid = apartmentid;
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
	  str.append("description=" + getDescription()  + " ");
	  str.append("apartmentid=" + getApartmentid()  + " ");
	  str.append('}');
	  return(str.toString());
   }
}
