package com.uwb;


import java.sql.*;
import java.io.*;
import javax.naming.*;
import javax.sql.*;

import com.finalist.util.log.*;

/**
 * ConnectionManager does the lookup for the database.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.5 $,
 */
public class ConnectionManager implements Serializable {
    /**
     * the manager.
     */
    private static ConnectionManager instance;

    /**
     * the logger.
     */
    private static Logger log = LogService.getLogger(ConnectionManager.class);
    /**
     * The datasource.
     */
    private DataSource ds;

    /**
     * The fully qualified jndi name will be something like: java:comp/env/jdbc/oracleDB.
     */
    public static final String DATABASE_LOOKUP_NAME_1 = "java:comp/env/jdbc/mysql";

    /**
     * This will be something like: java:/jdbc/oracleDB.
     */
    public static final String DATABASE_LOOKUP_NAME_2;

     /**
      * This will be something like: jdbc/oracleDB.
      */
    public static final String DATABASE_LOOKUP_NAME_3;

     /**
      * Sets the alternative JNDI names (without cannonical names).
      */
     static {
      String compenv = "comp/env";
      String name2 = null;
      String name3 = null;
      try {
         name2 = DATABASE_LOOKUP_NAME_1.substring(0, DATABASE_LOOKUP_NAME_1.indexOf(compenv))
                 + DATABASE_LOOKUP_NAME_1.substring(DATABASE_LOOKUP_NAME_1.indexOf(compenv)
                 + compenv.length());
         name3 = name2.substring(6);
      }
      catch (Exception jndiE) {
         log.debug("Error setting up an alternative db source.");
      }
      DATABASE_LOOKUP_NAME_2 = name2;
      DATABASE_LOOKUP_NAME_3 = name3;
   }

   /**
    * Default constructor. Establishes database connection.
    *
    * @throws NamingException when the name could not be resolved
    */
   protected ConnectionManager() throws NamingException {
      InitialContext jndiContext = new InitialContext();
      try {
         log.debug("Trying to get datasource: " + DATABASE_LOOKUP_NAME_1);
         ds = (javax.sql.DataSource) jndiContext.lookup(DATABASE_LOOKUP_NAME_1);
         log.debug("Got datasource: " + DATABASE_LOOKUP_NAME_1);

      }
      catch (Exception e) {
         log.warn("Warning while getting datasource for: " + DATABASE_LOOKUP_NAME_1);
         try {
            log.debug("Trying to get datasource: " + DATABASE_LOOKUP_NAME_2);
            ds = (javax.sql.DataSource) jndiContext.lookup(DATABASE_LOOKUP_NAME_2);
            log.debug("Got datasource: " + DATABASE_LOOKUP_NAME_2);
         }
         catch (Exception e2) {
            log.warn("Warning2 while getting datasource for: " + DATABASE_LOOKUP_NAME_2);

            try {
               log.debug("Trying to get datasource: " + DATABASE_LOOKUP_NAME_3);
               ds = (javax.sql.DataSource) jndiContext.lookup(DATABASE_LOOKUP_NAME_3);
               log.debug("Got datasource: " + DATABASE_LOOKUP_NAME_3);
            }
            catch (Exception e3) {
               log.warn("Warning3 while getting datasource for: " + DATABASE_LOOKUP_NAME_3);
            }

         }

      }
      if (ds == null) {
         log.fatal("Couldn't get the datasource!");
      }
   }

   /**
    * Returns the <code>ConnectionManager</code> instance.
    *
    * @return the <code>ConnectionManager</code> instance
    * @throws SQLException when retrieving the connection fails
    */
   public static ConnectionManager getInstance() throws SQLException {
      if (instance == null) {
         try {
            instance = new ConnectionManager();
         }
         catch (NamingException e) {
            instance = null;
            throw new SQLException("ConnectionManager : Error getting connection");
         }
      }
      return instance;
   }

   /**
    * Returns the sql connection.
    *
    * @return a connection
    * @throws SQLException when retrieving the connection fails
    */
   protected Connection getConnection() throws SQLException {
      return this.ds.getConnection();
   }

   /**
    * Create return connection calling methode is responsable for closing this connection.
    *
    * @return the Connection
    * @throws SQLException When the lookup failed or if there is no database
    */
   public static Connection connect() throws SQLException {
      return getInstance().getConnection();
   }

   /**
    * Starts the program from a shell.
    *
    * @param args an array of string arguments
    */
   public static void main(String[] args) {
      System.err.println("DATABASE_LOOKUP_NAME_1 = " + ConnectionManager.DATABASE_LOOKUP_NAME_1);
      System.err.println("DATABASE_LOOKUP_NAME_2 = " + ConnectionManager.DATABASE_LOOKUP_NAME_2);
      System.err.println("DATABASE_LOOKUP_NAME_3 = " + ConnectionManager.DATABASE_LOOKUP_NAME_3);
   }
}
