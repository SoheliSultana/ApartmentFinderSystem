package com.finalist.util.log;

/**
 * A class to get an instance for a logger object.
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.3 $, $Date: 2005/06/29 20:56:26 $
 */
public final class LogService {
   
   /**
    * Get an instance of a logger object.
    * @param cls the Class to log from
    * @return Logger the logger instance
    */
   public static Logger getLogger(Class cls) {
      return new Log4jLogger(cls);
   }
}
