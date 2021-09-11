package com.uwb.entity.address;

import javax.ejb.*;
import com.finalist.util.log.*;

/**
 * The Address entity bean.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.14 $,
 * @ejb.bean name="Address"
 *       view-type="local"
 *       local-jndi-name="ejb/local/com/uwb/entity/address/Address"
 *       jndi-name="ejb/local/com/uwb/entity/address/Address"
 *       type="CMP"
 *       schema="address"
 *       cmp-version="2.x"
 *       primkey-field="id"
 * @ejb.pk class="java.lang.Integer"
 *
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a"
 *
 * @ejb.finder signature="java.util.Collection findById(java.lang.Integer id)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.id = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByAddresscol(java.lang.String addresscol)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.addresscol = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByCity(java.lang.String city)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.city = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByState(java.lang.String state)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.state = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByZipcode(java.lang.String zipcode)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.zipcode = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByApartmentid(java.lang.Integer apartmentid)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from address a where a.apartmentid = ?1 "
 *
 * @ejb.transaction type="Required"
 * @ejb.permission unchecked="True"
 * @ejb.util generate="logical"
 * @ejb.value-object match="*"
 * @ejb.persistence table-name="address"
 * @jboss.persistence
 *       create-table="true"
 *       remove-table="false"
 */
public abstract class AddressEJB implements EntityBean {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(AddressEJB.class);

   /**
    * Context for entity bean.
    */
   private EntityContext ctx;

   /**
    * Default constructor.
    */
   public AddressEJB() {
   }

   /*******************************************************************************************************************
    *                            C O N T A I N E R   C A L L B A C K S   M E T H O D S
    *******************************************************************************************************************/

   /**
    * Creates a new entity bean and returns the primary key.
    * If the primary key of the value object has been set, this key will be used.
    * If the primary key is set to null, the UniqueId generator will be used to generate a primary key.
    *
    * @param value a <code>AddressData</code> instance
    * @return the primary key for this Address
    * @ejb.create-method
    * @throws CreateException Thrown if creation fails
    */
   public java.lang.Integer ejbCreate(com.uwb.entity.address.AddressData value) throws CreateException {
      setId(value.getId());
      setAddresscol(value.getAddresscol());
      setCity(value.getCity());
      setState(value.getState());
      setZipcode(value.getZipcode());
      setApartmentid(value.getApartmentid());
      setAddressData(value);
      if (value.getId() == null) {
         value.setId(com.finalist.util.ejb.UniqueIdGenerator.getInstance().getIntegerId("Address"));
      }
      setId(value.getId());
      return null;
   }

   /**
    * Initializes the entity bean with data.
    *
    * @param value <code>AddressData</code> object
    * @throws CreateException Thrown if creation fails.
    */
   public void ejbPostCreate(com.uwb.entity.address.AddressData value) throws CreateException {
   }

   /**
    * A container invokes this method before it removes the EJB object that is currently associated with the instance.
    * This method is invoked when a client invokes a remove operation on the enterprise Bean's home interface or the
    * EJB object's Remote interface. This method transitions the instance from the ready state to the pool of available
    * instances.<p>This method is called in the transaction context of the remove operation.
    *
    * @throws RemoveException The enterprise Bean does not allow destruction of the object.
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void ejbRemove() throws RemoveException, EJBException {
   }

   /**
    * Set the associated entity context. The container invokes this method on an instance after the instance has been
    * created.<p>This method is called in an unspecified transaction context.
    *
    * @param ctx An EntityContext interface for the instance. The instance should store the reference to the context in
    *            an instance variable.
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void setEntityContext(EntityContext ctx) throws EJBException {
      this.ctx = ctx;
   }

   /**
    * A container invokes this method when the instance is taken out of the pool of available instances to become
    * associated with a specific EJB object. This method transitions the instance to the ready state.<p>This method
    * executes in an unspecified transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void ejbActivate() throws EJBException {
   }

   /**
    * A container invokes this method on an instance before the instance becomes disassociated with a specific EJB
    * object. After this method completes, the container will place the instance into the pool of available instances.
    * <p>This method executes in an unspecified transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void ejbPassivate() throws EJBException {
   }

   /**
    * A container invokes this method to instruct the instance to synchronize its state by loading it state from the
    * underlying database.<p>This method always executes in the transaction context determined by the value of the
    * transaction attribute in the deployment descriptor.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void ejbLoad() throws EJBException {
   }

   /**
    * A container invokes this method to instruct the instance to synchronize its state by storing it to the underlying
    * database.<p>This method always executes in the transaction context determined by the value of the transaction
    * attribute in the deployment descriptor.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void ejbStore() throws EJBException {
   }

   /**
    * Unset the associated entity context. The container calls this method before removing the instance.<p>This is the
    * last method that the container invokes on the instance. The Java garbage collector will eventually invoke the
    * finalize() method on the instance.<p>This method is called in an unspecified transaction context.
    *
    * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
    */
   public void unsetEntityContext() throws EJBException {
      this.ctx = null;
   }

   /*******************************************************************************************************************
    *                                            B E A N   M E T H O D S
    *******************************************************************************************************************/



   /**
    * Value object.
    */
   com.uwb.entity.address.AddressData theAddressData = null;


   /**
    * Returns the <code>AddressData</code> object and related objects..
    *
    *
    * @return the <code>AddressData</code> object
    * @ejb.interface-method
    */
   public com.uwb.entity.address.AddressData getAddressData() {
      return getAddressData(true);
   }

   /**
    * Returns the <code>AddressData</code> object.
    * This method allows to specify a lazy loading scheme.
    * Be default, related objects will be loaded.
    * By passing false to this method, the related methods will nog be loaded.
    *
    *
    * @return the <code>AddressData</code> object
    */
   public com.uwb.entity.address.AddressData getAddressData(boolean getRelatedObjects)
   {
      AddressData theAddressData = new AddressData();
      try
         {
            theAddressData.setId(getId());
            theAddressData.setAddresscol(getAddresscol());
            theAddressData.setCity(getCity());
            theAddressData.setState(getState());
            theAddressData.setZipcode(getZipcode());
            theAddressData.setApartmentid(getApartmentid());

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }
	  return theAddressData;
   }

   /**
    * Sets the <code>AddressData</code> object.
    * Only set the data for non primary fields, since they should be set in the ejbCreate.
    *
    * @param data a <code>AddressData</code> object
    * @ejb.interface-method
    */
   public void setAddressData(com.uwb.entity.address.AddressData data)
   {
	  try
	  {
       setAddresscol(data.getAddresscol());
       setCity(data.getCity());
       setState(data.getState());
       setZipcode(data.getZipcode());
       setApartmentid(data.getApartmentid());
	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

   /**
    * Returns the value of the <code>id</code> property.
    *
    * @return the value of the <code>id</code> property
    * @ejb.persistence column-name="id"
    *       jdbc-type ="INTEGER"
    *       sql-type ="INT(11)"
    * @ejb.pk-field
    */
   public abstract java.lang.Integer getId();
   /**
    * Sets the value of the <code>id</code> property.
    *
    * @param id the value for the <code>id</code> property
    */
   public abstract void setId(java.lang.Integer id);

   /**
    * Returns the value of the <code>addresscol</code> property.
    *
    * @return the value of the <code>addresscol</code> property
    * @ejb.persistence column-name="addresscol"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(100)"
    */
   public abstract java.lang.String getAddresscol();
   /**
    * Sets the value of the <code>addresscol</code> property.
    *
    * @param addresscol the value for the <code>addresscol</code> property
    */
   public abstract void setAddresscol(java.lang.String addresscol);

   /**
    * Returns the value of the <code>city</code> property.
    *
    * @return the value of the <code>city</code> property
    * @ejb.persistence column-name="city"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getCity();
   /**
    * Sets the value of the <code>city</code> property.
    *
    * @param city the value for the <code>city</code> property
    */
   public abstract void setCity(java.lang.String city);

   /**
    * Returns the value of the <code>state</code> property.
    *
    * @return the value of the <code>state</code> property
    * @ejb.persistence column-name="state"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getState();
   /**
    * Sets the value of the <code>state</code> property.
    *
    * @param state the value for the <code>state</code> property
    */
   public abstract void setState(java.lang.String state);

   /**
    * Returns the value of the <code>zipcode</code> property.
    *
    * @return the value of the <code>zipcode</code> property
    * @ejb.persistence column-name="zipcode"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getZipcode();
   /**
    * Sets the value of the <code>zipcode</code> property.
    *
    * @param zipcode the value for the <code>zipcode</code> property
    */
   public abstract void setZipcode(java.lang.String zipcode);

   /**
    * Returns the value of the <code>apartmentid</code> property.
    *
    * @return the value of the <code>apartmentid</code> property
    * @ejb.persistence column-name="apartmentId"
    *       jdbc-type ="INTEGER"
    *       sql-type ="INT(11)"
    */
   public abstract java.lang.Integer getApartmentid();
   /**
    * Sets the value of the <code>apartmentid</code> property.
    *
    * @param apartmentid the value for the <code>apartmentid</code> property
    */
   public abstract void setApartmentid(java.lang.Integer apartmentid);


   /**
    * The name of the database table behind the entity bean.
    */
   public static final String TABLE_NAME = "address";

   /**
    * A mapping of container-managed persitent field --> corresponding database column name.
    */
   public static final java.util.Map COLUMNS_MAP = new java.util.HashMap();
   static {
      COLUMNS_MAP.put("id", "id");
      COLUMNS_MAP.put("addresscol", "addresscol");
      COLUMNS_MAP.put("city", "city");
      COLUMNS_MAP.put("state", "state");
      COLUMNS_MAP.put("zipcode", "zipcode");
      COLUMNS_MAP.put("apartmentid", "apartmentId");
   }

}
