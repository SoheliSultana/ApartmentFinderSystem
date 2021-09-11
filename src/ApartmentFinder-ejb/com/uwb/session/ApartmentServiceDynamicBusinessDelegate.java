package com.uwb.session;

import com.uwb.DynamicBusinessDelegateBase;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import com.uwb.exception.GenericBusinessException;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;
import com.uwb.servicelocator.*;


/**
 * Business delegate for the Session EJB that hides architecture specific details to the web client.
 * The web client will only see this interface.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.5 $,
 */
public class ApartmentServiceDynamicBusinessDelegate extends DynamicBusinessDelegateBase implements InvocationHandler {
    private ApartmentService service;

    private Map availableMethods;

    /**
     * the logger.
     */
    private static Logger log = LogService.getLogger(ApartmentServiceDynamicBusinessDelegate.class);

    public ApartmentServiceDynamicBusinessDelegate() throws GenericBusinessException {
        initService();
    }

    /**
     * Determine all methods in the remote interface and put them in a hashmap.
     * @throws GenericBusinessException
     */
    public void initService() throws GenericBusinessException {
        // Look up and obtain our session bean
        try {
            service = ApartmentServiceUtil.getHome().create();
            // Get the methods available for use in proxying
            availableMethods = getMethods(ApartmentService.class);
        } catch (Exception e) {
            throw new GenericBusinessException(e);
        }
    }

    /**
     * Implement the Locatable interface (init and destroy)
     * and map all Service methods to the Session EJB implementation,
     * using a dynamic proxy.
     *
     * @param proxy the proxy
     * @param method the method
     * @param args the arguments
     * @return Object the resulting object after invocation.
     * @throws Throwable the exception
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            // See if this is init() or destroy()
            if (method.getName().equals("init")) {
                initService();
                return null;
            } else if (method.getName().equals("destroy")) {
                // Nothing to do.
                return null;
            } else {
                Method theMethod;
                String methodName = getUniqueMethodName(method);
                theMethod = (Method) availableMethods.get(methodName);
                // See if we found anything
                if (theMethod != null) {
                    return theMethod.invoke(service, args);
                } else {
                    log.warn("The Service doesn't support the method: " + theMethod.getName());
                    throw new
                            NoSuchMethodException("The Service doesn't support the method " +
                            theMethod.getName() + " method.");
                }
            }
        } catch (InvocationTargetException e) {
            // Package a Remote exception in a Busines Exception
            if (e.getTargetException() instanceof RemoteException) {
                throw new GenericBusinessException((RemoteException) e.getTargetException());
            } else {
                throw e.getTargetException();
            }
        }
    }
}
