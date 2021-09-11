package com.uwb.exception;


/**
 * Exception that will be thrown if the service is unknown.
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $, $Date: 2005/06/29 20:56:26 $
 */
public class UnknownServiceException extends GenericBusinessException {
    /**
     * message constructor.
     * @param message the error message
     */
    public UnknownServiceException(String message) {
        super(message);
    }

    /**
     * cause constructor.
     * @param cause the cause
     */
    public UnknownServiceException(Exception cause) {
        super(cause);
    }

    /**
     * message en cause constructor.
     * @param message the error message
     * @param cause   the cause
     */
    public UnknownServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
