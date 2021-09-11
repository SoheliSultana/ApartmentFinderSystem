package com.uwb.entity.units;

import java.io.Serializable;


/**
 * The UnitsData objects extends the generated Value object.
 * Put here your presentation specific code.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.8 $, $Date: 2005/07/08 17:09:50 $
 */
public class UnitsData implements UnitsIf, Serializable    {

   /**
    * Default constructor.
    */
   public UnitsData() {
   }

   /**
    * Value object constructor.
    */
   public UnitsData(com.uwb.entity.units.UnitsIf value) {
      setId(value.getId());
      setNumber(value.getNumber());
      setSquareft(value.getSquareft());
      setType(value.getType());
      setRent(value.getRent());
      setAvalibility(value.getAvalibility());
      setApertmentid(value.getApertmentid());
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

   private java.lang.String number;

   /**
    * Returns the value of the <code>number</code> property.
    *
    * @return the value of the <code>number</code> property.
    */
   public java.lang.String getNumber() {
      return number;
   }

   /**
    * Sets the value of the <code>number</code> property.
    *
    * @param number a value for <code>number</code>.
    */
   public void setNumber(java.lang.String number) {
      this.number = number;
   }

   private java.lang.String squareft;

   /**
    * Returns the value of the <code>squareft</code> property.
    *
    * @return the value of the <code>squareft</code> property.
    */
   public java.lang.String getSquareft() {
      return squareft;
   }

   /**
    * Sets the value of the <code>squareft</code> property.
    *
    * @param squareft a value for <code>squareft</code>.
    */
   public void setSquareft(java.lang.String squareft) {
      this.squareft = squareft;
   }

   private java.lang.String type;

   /**
    * Returns the value of the <code>type</code> property.
    *
    * @return the value of the <code>type</code> property.
    */
   public java.lang.String getType() {
      return type;
   }

   /**
    * Sets the value of the <code>type</code> property.
    *
    * @param type a value for <code>type</code>.
    */
   public void setType(java.lang.String type) {
      this.type = type;
   }

   private java.math.BigDecimal rent;

   /**
    * Returns the value of the <code>rent</code> property.
    *
    * @return the value of the <code>rent</code> property.
    */
   public java.math.BigDecimal getRent() {
      return rent;
   }

   /**
    * Sets the value of the <code>rent</code> property.
    *
    * @param rent a value for <code>rent</code>.
    */
   public void setRent(java.math.BigDecimal rent) {
      this.rent = rent;
   }

   private java.sql.Timestamp avalibility;

   /**
    * Returns the value of the <code>avalibility</code> property.
    *
    * @return the value of the <code>avalibility</code> property.
    */
   public java.sql.Timestamp getAvalibility() {
      return avalibility;
   }

   /**
    * Sets the value of the <code>avalibility</code> property.
    *
    * @param avalibility a value for <code>avalibility</code>.
    */
   public void setAvalibility(java.sql.Timestamp avalibility) {
      this.avalibility = avalibility;
   }

   private java.lang.Integer apertmentid;

   /**
    * Returns the value of the <code>apertmentid</code> property.
    *
    * @return the value of the <code>apertmentid</code> property.
    */
   public java.lang.Integer getApertmentid() {
      return apertmentid;
   }

   /**
    * Sets the value of the <code>apertmentid</code> property.
    *
    * @param apertmentid a value for <code>apertmentid</code>.
    */
   public void setApertmentid(java.lang.Integer apertmentid) {
      this.apertmentid = apertmentid;
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
	  str.append("number=" + getNumber()  + " ");
	  str.append("squareft=" + getSquareft()  + " ");
	  str.append("type=" + getType()  + " ");
	  str.append("rent=" + getRent()  + " ");
	  str.append("avalibility=" + getAvalibility()  + " ");
	  str.append("apertmentid=" + getApertmentid()  + " ");
	  str.append('}');
	  return(str.toString());
   }
}
