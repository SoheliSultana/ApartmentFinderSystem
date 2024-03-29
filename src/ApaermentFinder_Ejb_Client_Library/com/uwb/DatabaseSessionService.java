package com.uwb;

import com.uwb.exception.GenericBusinessException;

/**
 * The <code>DatabaseSessionService </code> service interface allows closing of a database session by the client.
 * This way it is possible too keep database sessions open for lazy loading support.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.2 $, $Date: 2005/06/29 20:56:26 $
 *
 *
 */
public interface DatabaseSessionService  {
   /**
    * Close a database session if it is still open.
    *
    */
   void close() throws GenericBusinessException;
}
