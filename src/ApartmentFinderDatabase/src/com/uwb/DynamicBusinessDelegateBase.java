package com.uwb;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import com.uwb.exception.GenericBusinessException;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;
import com.uwb.servicelocator.*;


/**
 * Base class for Dynamic Business delegates with common methods.
 *
 * @author  Soheli Sultana  university of washington bothel
 * @version $Revision: 1.4 $,
 */
public class DynamicBusinessDelegateBase {

    /**
     * the logger.
     */
    private static Logger log = LogService.getLogger(DynamicBusinessDelegateBase.class);

    /**
     * Create a string with a unique method name appended with the parameter types.
     * @param method
     * @return
     */
    public String getUniqueMethodName(Method method) {
        String name = "";
        name = method.getName();
        for (int i = 0; i < method.getParameterTypes().length; i++) {
            Class theType = method.getParameterTypes()[i];
            name += "_" + theType.getName();
        }
        return name;
    }

    /**
     * Determine all methods in the class and put them in a hashmap. Use a unique method string as entry.
     * @throws GenericBusinessException
     */
    public Map getMethods(Class theClass) throws GenericBusinessException {
        Map availableMethods;
        try {
            // Get the methods from the class.
            availableMethods = new HashMap();
            Method[] methods = theClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                String methodName = getUniqueMethodName(methods[i]);
                availableMethods.put(methodName,
                        methods[i]);
            }
        } catch (Exception e) {
            throw new GenericBusinessException(e);
        }
        return availableMethods;
    }
}
