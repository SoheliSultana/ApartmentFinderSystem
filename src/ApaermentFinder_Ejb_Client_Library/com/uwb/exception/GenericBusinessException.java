package com.uwb.exception;


/**
 * Base Exception class that can be thrown by the business layer.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.3 $, $Date: 2005/06/29 20:56:26 $
 */
public class GenericBusinessException extends Exception {
    /**
     * message constructor.
     * @param message the error message
     */
    public GenericBusinessException(String message) {
        super(message);
    }

    /**
     * cause constructor.
     * @param cause the cause
     */
    public GenericBusinessException(Exception cause) {
        super(cause);
    }

    /**
     * message en cause constructor.
     * @param message the error message
     * @param cause   the cause
     */
    public GenericBusinessException(String message, Exception cause) {
        super(message, cause);
    }
}
