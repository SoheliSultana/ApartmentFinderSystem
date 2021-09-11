package com.uwb.entity.units;

import javax.ejb.*;
import com.finalist.util.log.*;

/**
 * The Units entity bean.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.14 $,
 * @ejb.bean name="Units"
 *       view-type="local"
 *       local-jndi-name="ejb/local/com/uwb/entity/units/Units"
 *       jndi-name="ejb/local/com/uwb/entity/units/Units"
 *       type="CMP"
 *       schema="units"
 *       cmp-version="2.x"
 *       primkey-field="id"
 * @ejb.pk class="java.lang.Integer"
 *
 *
 * @ejb.finder signature="java.util.Collection findAll()"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a"
 *
 * @ejb.finder signature="java.util.Collection findById(java.lang.Integer id)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.id = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByNumber(java.lang.String number)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.number = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findBySquareft(java.lang.String squareft)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.squareft = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByType(java.lang.String type)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.type = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByRent(java.math.BigDecimal rent)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.rent = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByAvalibility(java.sql.Timestamp avalibility)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.avalibility = ?1 "
 *
 * @ejb.finder signature="java.util.Collection findByApertmentid(java.lang.Integer apertmentid)"
 *             view-type ="local"
 *             method-intf="LocalHome"
 *             query="select distinct object (a) from units a where a.apertmentid = ?1 "
 *
 * @ejb.transaction type="Required"
 * @ejb.permission unchecked="True"
 * @ejb.util generate="logical"
 * @ejb.value-object match="*"
 * @ejb.persistence table-name="units"
 * @jboss.persistence
 *       create-table="true"
 *       remove-table="false"
 */
public abstract class UnitsEJB implements EntityBean {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UnitsEJB.class);

   /**
    * Context for entity bean.
    */
   private EntityContext ctx;

   /**
    * Default constructor.
    */
   public UnitsEJB() {
   }

   /*******************************************************************************************************************
    *                            C O N T A I N E R   C A L L B A C K S   M E T H O D S
    *******************************************************************************************************************/

   /**
    * Creates a new entity bean and returns the primary key.
    * If the primary key of the value object has been set, this key will be used.
    * If the primary key is set to null, the UniqueId generator will be used to generate a primary key.
    *
    * @param value a <code>UnitsData</code> instance
    * @return the primary key for this Units
    * @ejb.create-method
    * @throws CreateException Thrown if creation fails
    */
   public java.lang.Integer ejbCreate(com.uwb.entity.units.UnitsData value) throws CreateException {
      setId(value.getId());
      setNumber(value.getNumber());
      setSquareft(value.getSquareft());
      setType(value.getType());
      setRent(value.getRent());
      setAvalibility(value.getAvalibility());
      setApertmentid(value.getApertmentid());
      setUnitsData(value);
      if (value.getId() == null) {
         value.setId(com.finalist.util.ejb.UniqueIdGenerator.getInstance().getIntegerId("Units"));
      }
      setId(value.getId());
      return null;
   }

   /**
    * Initializes the entity bean with data.
    *
    * @param value <code>UnitsData</code> object
    * @throws CreateException Thrown if creation fails.
    */
   public void ejbPostCreate(com.uwb.entity.units.UnitsData value) throws CreateException {
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
   com.uwb.entity.units.UnitsData theUnitsData = null;


   /**
    * Returns the <code>UnitsData</code> object and related objects..
    *
    *
    * @return the <code>UnitsData</code> object
    * @ejb.interface-method
    */
   public com.uwb.entity.units.UnitsData getUnitsData() {
      return getUnitsData(true);
   }

   /**
    * Returns the <code>UnitsData</code> object.
    * This method allows to specify a lazy loading scheme.
    * Be default, related objects will be loaded.
    * By passing false to this method, the related methods will nog be loaded.
    *
    *
    * @return the <code>UnitsData</code> object
    */
   public com.uwb.entity.units.UnitsData getUnitsData(boolean getRelatedObjects)
   {
      UnitsData theUnitsData = new UnitsData();
      try
         {
            theUnitsData.setId(getId());
            theUnitsData.setNumber(getNumber());
            theUnitsData.setSquareft(getSquareft());
            theUnitsData.setType(getType());
            theUnitsData.setRent(getRent());
            theUnitsData.setAvalibility(getAvalibility());
            theUnitsData.setApertmentid(getApertmentid());

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }
	  return theUnitsData;
   }

   /**
    * Sets the <code>UnitsData</code> object.
    * Only set the data for non primary fields, since they should be set in the ejbCreate.
    *
    * @param data a <code>UnitsData</code> object
    * @ejb.interface-method
    */
   public void setUnitsData(com.uwb.entity.units.UnitsData data)
   {
	  try
	  {
       setNumber(data.getNumber());
       setSquareft(data.getSquareft());
       setType(data.getType());
       setRent(data.getRent());
       setAvalibility(data.getAvalibility());
       setApertmentid(data.getApertmentid());
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
    * Returns the value of the <code>number</code> property.
    *
    * @return the value of the <code>number</code> property
    * @ejb.persistence column-name="number"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getNumber();
   /**
    * Sets the value of the <code>number</code> property.
    *
    * @param number the value for the <code>number</code> property
    */
   public abstract void setNumber(java.lang.String number);

   /**
    * Returns the value of the <code>squareft</code> property.
    *
    * @return the value of the <code>squareft</code> property
    * @ejb.persistence column-name="squareft"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getSquareft();
   /**
    * Sets the value of the <code>squareft</code> property.
    *
    * @param squareft the value for the <code>squareft</code> property
    */
   public abstract void setSquareft(java.lang.String squareft);

   /**
    * Returns the value of the <code>type</code> property.
    *
    * @return the value of the <code>type</code> property
    * @ejb.persistence column-name="type"
    *       jdbc-type ="VARCHAR"
    *       sql-type ="VARCHAR(45)"
    */
   public abstract java.lang.String getType();
   /**
    * Sets the value of the <code>type</code> property.
    *
    * @param type the value for the <code>type</code> property
    */
   public abstract void setType(java.lang.String type);

   /**
    * Returns the value of the <code>rent</code> property.
    *
    * @return the value of the <code>rent</code> property
    * @ejb.persistence column-name="rent"
    *       jdbc-type ="DECIMAL"
    *       sql-type ="DECIMAL(5)"
    */
   public abstract java.math.BigDecimal getRent();
   /**
    * Sets the value of the <code>rent</code> property.
    *
    * @param rent the value for the <code>rent</code> property
    */
   public abstract void setRent(java.math.BigDecimal rent);

   /**
    * Returns the value of the <code>avalibility</code> property.
    *
    * @return the value of the <code>avalibility</code> property
    * @ejb.persistence column-name="avalibility"
    *       jdbc-type ="TIMESTAMP"
    *       sql-type ="DATETIME"
    */
   public abstract java.sql.Timestamp getAvalibility();
   /**
    * Sets the value of the <code>avalibility</code> property.
    *
    * @param avalibility the value for the <code>avalibility</code> property
    */
   public abstract void setAvalibility(java.sql.Timestamp avalibility);

   /**
    * Returns the value of the <code>apertmentid</code> property.
    *
    * @return the value of the <code>apertmentid</code> property
    * @ejb.persistence column-name="apertmentId"
    *       jdbc-type ="INTEGER"
    *       sql-type ="INT(11)"
    */
   public abstract java.lang.Integer getApertmentid();
   /**
    * Sets the value of the <code>apertmentid</code> property.
    *
    * @param apertmentid the value for the <code>apertmentid</code> property
    */
   public abstract void setApertmentid(java.lang.Integer apertmentid);


   /**
    * The name of the database table behind the entity bean.
    */
   public static final String TABLE_NAME = "units";

   /**
    * A mapping of container-managed persitent field --> corresponding database column name.
    */
   public static final java.util.Map COLUMNS_MAP = new java.util.HashMap();
   static {
      COLUMNS_MAP.put("id", "id");
      COLUMNS_MAP.put("number", "number");
      COLUMNS_MAP.put("squareft", "squareft");
      COLUMNS_MAP.put("type", "type");
      COLUMNS_MAP.put("rent", "rent");
      COLUMNS_MAP.put("avalibility", "avalibility");
      COLUMNS_MAP.put("apertmentid", "apertmentId");
   }

}
