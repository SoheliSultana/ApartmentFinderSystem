package com.uwb.servicelocator;

import com.uwb.exception.*;

/**
 * Interface that determines the service.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public interface ServiceInfo {
    /**
     * determine service.
     * @return Locatable Service
     * @throws ServiceInstantiationException service can not be started.
     * @throws UnknownServiceException Unknown service
     */
    LocatableService getService() throws ServiceInstantiationException, UnknownServiceException;
}
