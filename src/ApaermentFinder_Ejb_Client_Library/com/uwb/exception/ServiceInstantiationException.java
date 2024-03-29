package com.uwb.exception;

/**
 * Exception that will be thrown if a service can not be instantiated.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public class ServiceInstantiationException extends GenericBusinessException {
    /**
     * message constructor.
     * @param message the error message
     */
    public ServiceInstantiationException(String message) {
        super(message);
    }

    /**
     * cause constructor.
     * @param cause the cause
     */
    public ServiceInstantiationException(Exception cause) {
        super(cause);
    }

    /**
     * message en cause constructor.
     * @param message the error message
     * @param cause   the cause
     */
    public ServiceInstantiationException(String message, Exception cause) {
        super(message, cause);
    }
}
