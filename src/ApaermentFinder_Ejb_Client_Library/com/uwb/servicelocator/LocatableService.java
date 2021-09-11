package com.uwb.servicelocator;

import com.uwb.exception.*;

/**
 * Services have to implement the LocatebleService interface.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public interface LocatableService {
    /**
     * init.
     * @throws GenericBusinessException the business exception.
     */
    void init() throws GenericBusinessException;

    /**
     * destroy.
     * @throws GenericBusinessException the business exception.
     */
    void destroy() throws GenericBusinessException;
}
