package com.uwb.entity.apartment;

import javax.ejb.*;
import com.finalist.util.log.*;

/**
 * The Apartment entity bean.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.14 $,
 * @ejb.bean name="Apartment"
 *       view-type="local"
 *       local-jndi-name="ejb/local/com/uwb/entity/apartment/Apartment"
 *       jndi-name="ejb/local/com/uwb/entity/apartment/Apartment"
 *       type="CMP"
 *       schema="apartment"
 *       cmp-version="2.x"
 *       primkey-field="id"
 * @ejb.pk class="java.lang.Integer"
 *
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a"
 *
 * @ejb.finder signature="java.util.Collection findById(java.lang.Integer id)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.id = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByName(java.lang.String name)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.name = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByOwner(java.lang.String owner)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.owner = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByDescription(java.lang.String description)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.description = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByImageurl(java.lang.String imageurl)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.imageurl = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByParking(java.lang.String parking)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from apartment a where a.parking = ?1 "
 *
 * @ejb.transaction type="Required"
 * @ejb.permission unchecked="True"
 * @ejb.util generate="logical"
 * @ejb.value-object match="*"
 * @ejb.persistence table-name="apartment"
 * @jboss.persistence
 *       create-table="true"
 *       remove-table="false"
 */
public abstract class ApartmentEJB implements EntityBean {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ApartmentEJB.class);

   /**
    * Context for entity bean.
    */
   private EntityContext ctx;

   /**
    * Default constructor.
    */
   public ApartmentEJB() {
   }

   /*******************************************************************************************************************
    *                            C O N T A I N E R   C A L L B A C K S   M E T H O D S
    *******************************************************************************************************************/

   /**
    * Creates a new entity bean and returns the primary key.
    * If the primary key of the value object has been set, this key will be used.
    * If the primary key is set to null, the UniqueId generator will be used to generate a primary key.
    *
    * @param value a <code>ApartmentData</code> instance
    * @return the primary key for this Apartment
    * @ejb.create-method
    * @throws CreateException Thrown if creation fails
    */
   public java.lang.Integer ejbCreate(com.uwb.entity.apartment.ApartmentData value) throws CreateException {
      setId(value.getId());
      setName(value.getName());
      setOwner(value.getOwner());
      setDescription(value.getDescription());
      setImageurl(value.getImageurl());
      setParking(value.getParking());
      setApartmentData(value);
      if (value.getId() == null) {
         value.setId(com.finalist.util.ejb.UniqueIdGenerator.getInstance().getIntegerId("Apartment"));
      }
      setId(value.getId());
      return null;
   }

   /**
    * Initializes the entity bean with data.
    *
    * @param value <code>ApartmentData</code> object
    * @throws CreateException Thrown if creation fails.
    */
   public void ejbPostCreate(com.uwb.entity.apartment.ApartmentData value) throws CreateException {
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
   com.uwb.entity.apartment.ApartmentData theApartmentData = null;


   /**
    * Returns the <code>ApartmentData</code> object and related objects..
    *
    *
    * @return the <code>ApartmentData</code> object
    * @ejb.interface-method
    */
   public com.uwb.entity.apartment.ApartmentData getApartmentData() {
      return getApartmentData(true);
   }

   /**
    * Returns the <code>ApartmentData</code> object.
    * This method allows to specify a lazy loading scheme.
    * Be default, related objects will be loaded.
    * By passing false to this method, the related methods will nog be loaded.
    *
    *
    * @return the <code>ApartmentData</code> object
    */
   public com.uwb.entity.apartment.ApartmentData getApartmentData(boolean getRelatedObjects)
   {
      ApartmentData theApartmentData = new ApartmentData();
      try
         {
            theApartmentData.setId(getId());
            theApartmentData.setName(getName());
            theApartmentData.setOwner(getOwner());
            theApartmentData.setDescription(getDescription());
            theApartmentData.setImageurl(getImageurl());
            theApartmentData.setParking(getParking());

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }
	  return theApartmentData;
   }

   /**
    * Sets the <code>ApartmentData</code> object.
    * Only set the data for non primary fields, since they should be set in the ejbCreate.
    *
    * @param data a <code>ApartmentData</code> object
    * @ejb.interface-method
    */
   public void setApartmentData(com.uwb.entity.apartment.ApartmentData data)
   {
	  try
	  {
       setName(data.getName());
       setOwner(data.getOwner());
       setDescription(data.getDescription());
       setImageurl(data.getImageurl());
       setParking(data.getParking());
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
    * Returns the value of the <code>name</code> property.
    *
    * @return the value of the <code>name</code> property
    * @ejb.persistence column-name="name"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(100)"
    */
   public abstract java.lang.String getName();
   /**
    * Sets the value of the <code>name</code> property.
    *
    * @param name the value for the <code>name</code> property
    */
   public abstract void setName(java.lang.String name);

   /**
    * Returns the value of the <code>owner</code> property.
    *
    * @return the value of the <code>owner</code> property
    * @ejb.persistence column-name="owner"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getOwner();
   /**
    * Sets the value of the <code>owner</code> property.
    *
    * @param owner the value for the <code>owner</code> property
    */
   public abstract void setOwner(java.lang.String owner);

   /**
    * Returns the value of the <code>description</code> property.
    *
    * @return the value of the <code>description</code> property
    * @ejb.persistence column-name="description"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(200)"
    */
   public abstract java.lang.String getDescription();
   /**
    * Sets the value of the <code>description</code> property.
    *
    * @param description the value for the <code>description</code> property
    */
   public abstract void setDescription(java.lang.String description);

   /**
    * Returns the value of the <code>imageurl</code> property.
    *
    * @return the value of the <code>imageurl</code> property
    * @ejb.persistence column-name="imageurl"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(200)"
    */
   public abstract java.lang.String getImageurl();
   /**
    * Sets the value of the <code>imageurl</code> property.
    *
    * @param imageurl the value for the <code>imageurl</code> property
    */
   public abstract void setImageurl(java.lang.String imageurl);

   /**
    * Returns the value of the <code>parking</code> property.
    *
    * @return the value of the <code>parking</code> property
    * @ejb.persistence column-name="parking"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(100)"
    */
   public abstract java.lang.String getParking();
   /**
    * Sets the value of the <code>parking</code> property.
    *
    * @param parking the value for the <code>parking</code> property
    */
   public abstract void setParking(java.lang.String parking);


   /**
    * The name of the database table behind the entity bean.
    */
   public static final String TABLE_NAME = "apartment";

   /**
    * A mapping of container-managed persitent field --> corresponding database column name.
    */
   public static final java.util.Map COLUMNS_MAP = new java.util.HashMap();
   static {
      COLUMNS_MAP.put("id", "id");
      COLUMNS_MAP.put("name", "name");
      COLUMNS_MAP.put("owner", "owner");
      COLUMNS_MAP.put("description", "description");
      COLUMNS_MAP.put("imageurl", "imageurl");
      COLUMNS_MAP.put("parking", "parking");
   }

}
