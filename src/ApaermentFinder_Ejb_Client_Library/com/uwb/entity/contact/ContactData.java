package com.uwb.entity.contact;

import java.io.Serializable;


/**
 * The ContactData objects extends the generated Value object.
 * Put here your presentation specific code.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.8 $, $Date: 2005/07/08 17:09:50 $
 */
public class ContactData implements ContactIf, Serializable    {

   /**
    * Default constructor.
    */
   public ContactData() {
   }

   /**
    * Value object constructor.
    */
   public ContactData(com.uwb.entity.contact.ContactIf value) {
      setId(value.getId());
      setRepresentative(value.getRepresentative());
      setPhone(value.getPhone());
      setEmail(value.getEmail());
      setOpenhour(value.getOpenhour());
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

   private java.lang.String representative;

   /**
    * Returns the value of the <code>representative</code> property.
    *
    * @return the value of the <code>representative</code> property.
    */
   public java.lang.String getRepresentative() {
      return representative;
   }

   /**
    * Sets the value of the <code>representative</code> property.
    *
    * @param representative a value for <code>representative</code>.
    */
   public void setRepresentative(java.lang.String representative) {
      this.representative = representative;
   }

   private java.lang.String phone;

   /**
    * Returns the value of the <code>phone</code> property.
    *
    * @return the value of the <code>phone</code> property.
    */
   public java.lang.String getPhone() {
      return phone;
   }

   /**
    * Sets the value of the <code>phone</code> property.
    *
    * @param phone a value for <code>phone</code>.
    */
   public void setPhone(java.lang.String phone) {
      this.phone = phone;
   }

   private java.lang.String email;

   /**
    * Returns the value of the <code>email</code> property.
    *
    * @return the value of the <code>email</code> property.
    */
   public java.lang.String getEmail() {
      return email;
   }

   /**
    * Sets the value of the <code>email</code> property.
    *
    * @param email a value for <code>email</code>.
    */
   public void setEmail(java.lang.String email) {
      this.email = email;
   }

   private java.lang.String openhour;

   /**
    * Returns the value of the <code>openhour</code> property.
    *
    * @return the value of the <code>openhour</code> property.
    */
   public java.lang.String getOpenhour() {
      return openhour;
   }

   /**
    * Sets the value of the <code>openhour</code> property.
    *
    * @param openhour a value for <code>openhour</code>.
    */
   public void setOpenhour(java.lang.String openhour) {
      this.openhour = openhour;
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
	  str.append("representative=" + getRepresentative()  + " ");
	  str.append("phone=" + getPhone()  + " ");
	  str.append("email=" + getEmail()  + " ");
	  str.append("openhour=" + getOpenhour()  + " ");
	  str.append("apartmentid=" + getApartmentid()  + " ");
	  str.append('}');
	  return(str.toString());
   }
}
