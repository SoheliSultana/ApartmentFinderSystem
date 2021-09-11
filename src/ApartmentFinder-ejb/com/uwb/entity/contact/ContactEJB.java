package com.uwb.entity.contact;

import javax.ejb.*;
import com.finalist.util.log.*;

/**
 * The Contact entity bean.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.14 $,
 * @ejb.bean name="Contact"
 *       view-type="local"
 *       local-jndi-name="ejb/local/com/uwb/entity/contact/Contact"
 *       jndi-name="ejb/local/com/uwb/entity/contact/Contact"
 *       type="CMP"
 *       schema="contact"
 *       cmp-version="2.x"
 *       primkey-field="id"
 * @ejb.pk class="java.lang.Integer"
 *
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a"
 *
 * @ejb.finder signature="java.util.Collection findById(java.lang.Integer id)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.id = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByRepresentative(java.lang.String representative)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.representative = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByPhone(java.lang.String phone)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.phone = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByEmail(java.lang.String email)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.email = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByOpenhour(java.lang.String openhour)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.openhour = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByApartmentid(java.lang.Integer apartmentid)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from contact a where a.apartmentid = ?1 "
 *
 * @ejb.transaction type="Required"
 * @ejb.permission unchecked="True"
 * @ejb.util generate="logical"
 * @ejb.value-object match="*"
 * @ejb.persistence table-name="contact"
 * @jboss.persistence
 *       create-table="true"
 *       remove-table="false"
 */
public abstract class ContactEJB implements EntityBean {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ContactEJB.class);

   /**
    * Context for entity bean.
    */
   private EntityContext ctx;

   /**
    * Default constructor.
    */
   public ContactEJB() {
   }

   /*******************************************************************************************************************
    *                            C O N T A I N E R   C A L L B A C K S   M E T H O D S
    *******************************************************************************************************************/

   /**
    * Creates a new entity bean and returns the primary key.
    * If the primary key of the value object has been set, this key will be used.
    * If the primary key is set to null, the UniqueId generator will be used to generate a primary key.
    *
    * @param value a <code>ContactData</code> instance
    * @return the primary key for this Contact
    * @ejb.create-method
    * @throws CreateException Thrown if creation fails
    */
   public java.lang.Integer ejbCreate(com.uwb.entity.contact.ContactData value) throws CreateException {
      setId(value.getId());
      setRepresentative(value.getRepresentative());
      setPhone(value.getPhone());
      setEmail(value.getEmail());
      setOpenhour(value.getOpenhour());
      setApartmentid(value.getApartmentid());
      setContactData(value);
      if (value.getId() == null) {
         value.setId(com.finalist.util.ejb.UniqueIdGenerator.getInstance().getIntegerId("Contact"));
      }
      setId(value.getId());
      return null;
   }

   /**
    * Initializes the entity bean with data.
    *
    * @param value <code>ContactData</code> object
    * @throws CreateException Thrown if creation fails.
    */
   public void ejbPostCreate(com.uwb.entity.contact.ContactData value) throws CreateException {
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
   com.uwb.entity.contact.ContactData theContactData = null;


   /**
    * Returns the <code>ContactData</code> object and related objects..
    *
    *
    * @return the <code>ContactData</code> object
    * @ejb.interface-method
    */
   public com.uwb.entity.contact.ContactData getContactData() {
      return getContactData(true);
   }

   /**
    * Returns the <code>ContactData</code> object.
    * This method allows to specify a lazy loading scheme.
    * Be default, related objects will be loaded.
    * By passing false to this method, the related methods will nog be loaded.
    *
    *
    * @return the <code>ContactData</code> object
    */
   public com.uwb.entity.contact.ContactData getContactData(boolean getRelatedObjects)
   {
      ContactData theContactData = new ContactData();
      try
         {
            theContactData.setId(getId());
            theContactData.setRepresentative(getRepresentative());
            theContactData.setPhone(getPhone());
            theContactData.setEmail(getEmail());
            theContactData.setOpenhour(getOpenhour());
            theContactData.setApartmentid(getApartmentid());

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }
	  return theContactData;
   }

   /**
    * Sets the <code>ContactData</code> object.
    * Only set the data for non primary fields, since they should be set in the ejbCreate.
    *
    * @param data a <code>ContactData</code> object
    * @ejb.interface-method
    */
   public void setContactData(com.uwb.entity.contact.ContactData data)
   {
	  try
	  {
       setRepresentative(data.getRepresentative());
       setPhone(data.getPhone());
       setEmail(data.getEmail());
       setOpenhour(data.getOpenhour());
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
    * Returns the value of the <code>representative</code> property.
    *
    * @return the value of the <code>representative</code> property
    * @ejb.persistence column-name="representative"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getRepresentative();
   /**
    * Sets the value of the <code>representative</code> property.
    *
    * @param representative the value for the <code>representative</code> property
    */
   public abstract void setRepresentative(java.lang.String representative);

   /**
    * Returns the value of the <code>phone</code> property.
    *
    * @return the value of the <code>phone</code> property
    * @ejb.persistence column-name="phone"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getPhone();
   /**
    * Sets the value of the <code>phone</code> property.
    *
    * @param phone the value for the <code>phone</code> property
    */
   public abstract void setPhone(java.lang.String phone);

   /**
    * Returns the value of the <code>email</code> property.
    *
    * @return the value of the <code>email</code> property
    * @ejb.persistence column-name="email"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getEmail();
   /**
    * Sets the value of the <code>email</code> property.
    *
    * @param email the value for the <code>email</code> property
    */
   public abstract void setEmail(java.lang.String email);

   /**
    * Returns the value of the <code>openhour</code> property.
    *
    * @return the value of the <code>openhour</code> property
    * @ejb.persistence column-name="openhour"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getOpenhour();
   /**
    * Sets the value of the <code>openhour</code> property.
    *
    * @param openhour the value for the <code>openhour</code> property
    */
   public abstract void setOpenhour(java.lang.String openhour);

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
   public static final String TABLE_NAME = "contact";

   /**
    * A mapping of container-managed persitent field --> corresponding database column name.
    */
   public static final java.util.Map COLUMNS_MAP = new java.util.HashMap();
   static {
      COLUMNS_MAP.put("id", "id");
      COLUMNS_MAP.put("representative", "representative");
      COLUMNS_MAP.put("phone", "phone");
      COLUMNS_MAP.put("email", "email");
      COLUMNS_MAP.put("openhour", "openhour");
      COLUMNS_MAP.put("apartmentid", "apartmentId");
   }

}
