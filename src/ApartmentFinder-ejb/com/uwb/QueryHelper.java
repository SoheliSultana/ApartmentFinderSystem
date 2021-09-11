package com.uwb;

import com.finalist.tools.database.*;
import com.finalist.util.log.*;
import java.sql.*;
import javax.ejb.EJBException;


/**
 * This class is a Helper for the StatementExecutor for getting a database connection.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $,
 */
public class QueryHelper extends StatementExecutor {

    /**
     * The logger
     */
    private static Logger log = LogService.getLogger(QueryHelper.class);

    /**
     * Creates a new instance of QueryHelper
     */
   public QueryHelper() {
      super(createConnection(), new GenericRowMapper());
   }

    /**
     * get connecion from datasource.
     * @return a connection
     * @throws EJBException
     */   
   private static Connection createConnection() throws EJBException {
      Connection con = null;
      try {
         con = ConnectionManager.connect();
      } 
      catch (SQLException q) {
         log.error("SQLException ocurred looking up connection from datasource ", q);
         throw new EJBException(q);
      }
      return con;
   }

   /**
    * Close the database connection.
    */
   public void close() {
      try {
         if (this.conn != null && !this.conn.isClosed()) {
            conn.close();
         }
      } 
      catch (SQLException e) {
         log.warn("Error closing the connection", e);
      }
   }
   
}
