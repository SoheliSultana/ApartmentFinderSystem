package com.finalist.util.ejb;

import com.finalist.util.sequencegenerator.*;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

/**
 * Class UniqueIdGenerator
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $,
 */

public class UniqueIdGenerator {

   private SequenceGenerator sequenceGenerator;
   private static UniqueIdGenerator instance = null;
   private static SequenceGeneratorHome sequenceHome = null;
   private static java.util.Properties props = null;

   /**
    * Private constructor.
    */
   private UniqueIdGenerator() {
      if (props == null) {
         props = new java.util.Properties();
      }
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.DATASOURCENAME,
         com.uwb.ConnectionManager.DATABASE_LOOKUP_NAME_1);
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.TABLENAME, "T_SEQUENCE_APARTMENTFINDER");
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.BLOCKSIZE, "10");
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.BLOCKSIZECOLUMN, "BLOCKSIZE");
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.NAMECOLUMN, "NAME");
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.VALUECOLUMN, "SEQUENCEVALUE");
      props.setProperty(com.finalist.util.sequencegenerator.SequenceGeneratorConstants.USEPUBLICSYNONYMS, "false");
   }

   /**
    * Returns the <code>UniqueIdGenerator</code> instance.
    *
    * @return the <code>UniqueIdGenerator</code> instance
    */
   public static UniqueIdGenerator getInstance() {
      if (instance == null) {
         instance = new UniqueIdGenerator();
      }
      return instance;
   }

   /**
    * Returns the next number in the sequence as a <code>Long</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    */
   public synchronized Long getLongId(String name) {
      getReferences();
      try {
         return new Long(sequenceGenerator.getNextNumberInSequence(name, props));
      }
      catch (RemoteException re) {
         re.printStackTrace();
      }
      return null;
   }

   /**
    * Returns the next number in the sequence as an <code>Integer</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    * @todo This method might be rewritten in order to give an exception
    *       when the max-integer value is exceeded.
    */
   public synchronized Integer getIntegerId(String name) {
      return new Integer((int) (getLongId(name).longValue()));
   }

   /**
    * Returns the next number in the sequence as an <code>Short</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    * @todo This method might be rewritten in order to give an exception
    *       when the max-integer value is exceeded.
    */
   public synchronized Short getShortId(String name) {
      return new Short((short) (getLongId(name).longValue()));
   }

   /**
    * Returns the next number in the sequence as an <code>Byte</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    * @todo This method might be rewritten in order to give an exception
    *       when the max-integer value is exceeded.
    */
   public synchronized Byte getByteId(String name) {
      return new Byte((byte) (getLongId(name).longValue()));
   }

   /**
    * Returns the next number in the sequence as a <code>Double</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    * @todo This method might be rewritten in order to give an exception
    *       when the max-integer value is exceeded.
    */
   public synchronized Double getDoubleId(String name) {
      return new Double((double) (getLongId(name).longValue()));
   }

   /**
    * Returns the next number in the sequence as a <code>String</code>.
    *
    * @param name a specific sequence identifier
    * @return the next number in the sequence
    */
   public synchronized String getStringId(String name) {
      getReferences();

      try {
         return sequenceGenerator.getNextNumberInSequenceAsString(name, props);
      }
      catch (RemoteException re) {
         re.printStackTrace();
      }
      return null;
   }

   /**
    * Returns the next number in the sequence as a <code>String</code>.
    *
    * @param name a specific sequence identifier
    * @param length lengt of the string determines if zeros are prepended.
    * @return the next number in the sequence
    */
   public synchronized String getStringId(String name, int length) {
      getReferences();

      try {
         return sequenceGenerator.getNextNumberInSequenceAsString(name, length, props);
      }
      catch (RemoteException re) {
         re.printStackTrace();
      }
      return null;
   }

   /* Helper method to cache the remote interface */
   private void getReferences() {
      try {
         if (sequenceHome == null) {
            sequenceHome = com.finalist.util.sequencegenerator.SequenceGeneratorUtil.getHome();
         }
         if (sequenceGenerator == null) {
            sequenceGenerator = sequenceHome.create();
         }
      }
      catch (Exception ne) {
         ne.printStackTrace();
      }
   }
}
