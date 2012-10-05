package org.company.utility.tostring;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Utilities enum to get a toString implementation.
 * 
 * @author Triguna
 * @since Project v1.0
 * @see The Java Language Specification, section 8.2
 */
public enum Utilities
{
	// No enum variables as of now
	;

	/**
	 * Default Private Constructor
	 */
	private Utilities()
	{
		// Not used as of now
	}

	/**
	 * For a given class object, return a string representation which contains the implementation of POJO's
	 * get methods only. This should be used for POJO's (Plain Old Java Objects) only.
	 * 
	 * @param objectInstance
	 *            java.lang.Object of the POJO for which toString implementation should be returned.
	 * 
	 * @return POJO getters are invoked and appended to a string which is returned from this method.
	 * 
	 * @since Project v1.1
	 * @see #getStringUsingBean(Object)
	 */
	public static String toString(Object objectInstance)
	{
		return getStringUsingBean(objectInstance);
	}

	/**
	 * For a given class object, return a string representation which contains the implementation of POJO's
	 * get methods only. This should be used for POJO's (Plain Old Java Objects) only.
	 * 
	 * @param objectInstance
	 *            java.lang.Object of the POJO for which toString implementation should be returned.
	 * @param classObject
	 *            java.lang.Class of the POJO for which toString implementation should be returned.
	 * 
	 * @return POJO getters are invoked and appended to a string which is returned from this method.
	 * 
	 * @deprecated use {@link #toString(Object objectInstance)} instead.
	 * 
	 * @since Project v1.0
	 * @see #getString(Object)
	 */
	@Deprecated
	public static String toString(Object objectInstance, Class classObject)
	{
		return getString(objectInstance);
	}

	/**
	 * Uses java.beans.PropertyDescriptor to get the getters. This way, we avoid using filters like in
	 * {@link #getString(Object)}
	 * 
	 * @param objectInstance
	 *            Instance of an object for which tostring is required.
	 * 
	 * @return toString implementation of this.
	 * @since Project v1.2
	 * @see #toString(Object)
	 */
	private static String getStringUsingBean(Object objectInstance)
	{
		StringBuilder buildString = new StringBuilder();

		try
		{
			for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(objectInstance.getClass())
					.getPropertyDescriptors())
			{
				if (propertyDescriptor.getReadMethod() != null && !"class".equals(propertyDescriptor.getName()))
				{
					Method method = propertyDescriptor.getReadMethod();
					buildString.append(method.getName().substring(3));
					buildString.append(" = ");
					buildString.append(propertyDescriptor.getReadMethod().invoke(objectInstance));
					buildString.append(", ");
				}
			}
		}
		catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex1)
		{
			// getLogger().error("IntrospectionException while executing toString...", ex1);
		}

		return buildString.toString().substring(0, buildString.length() - 1);
	}

	/**
	 * Uses a typical reflection to get the methods of a given instance. Once we get the methods, we filter
	 * out the methods by set, get and invoke only get methods to append to the string which will later result
	 * into tostring-implementation.
	 * 
	 * @param objectInstance
	 *            Instance of an object for which tostring is required.
	 * 
	 * @return toString implementation of this.
	 * 
	 * @since Project v1.0
	 * @see #getString(Object)
	 */
	private static String getString(Object objectInstance)
	{
		Class classObject = objectInstance.getClass();

		// Get all the methods
		Method[] methods = classObject.getDeclaredMethods();
		int noOfMethods = methods.length;

		StringBuilder buildString = new StringBuilder(noOfMethods + 2);

		buildString.append(classObject);
		buildString.append(" -->> ");

		for (Method method : methods)
		{
			String methodName = method.getName();
			switch (methodName)
			{
				case "toString":
				case "main":
				case "getLogger":
					// Do Nothing
					break;
				default:
					try
					{
						buildString.append(extractMethodNames(classObject, objectInstance, methodName, method));
					}
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| InstantiationException ex)
					{
						// Do nothing as this is just printing the POJO implementations...
						// getLogger().error("Exception while executing toString...", ex);
					}
					break;
			}
		}

		return buildString.toString();
	}

	/**
	 * Executes a get method and returns the output as a string representing methodName = methodValue.
	 * 
	 * @param methodName
	 *            methodName for which method needs to be executed.
	 * @param method
	 *            java.lang.reflect.Method
	 * 
	 * @return A String value with methodName = methodValue.
	 * 
	 * @throws IllegalAccessException
	 *             if this Method object is enforcing Java language access control and the underlying method
	 *             is inaccessible.
	 * @throws IllegalArgumentException
	 *             if the method is an instance method and the specified object argument is not an instance of
	 *             the class or interface declaring the underlying method (or of a subclass or implementor
	 *             thereof); if the number of actual and formal parameters differ; if an unwrapping conversion
	 *             for primitive arguments fails; or if, after possible unwrapping, a parameter value cannot
	 *             be converted to the corresponding formal parameter type by a method invocation conversion.
	 * @throws InvocationTargetException
	 *             if the underlying method throws an exception.
	 * @throws InstantiationException
	 *             if this Class represents an abstract class, an interface, an array class, a primitive type,
	 *             or void; or if the class has no nullary constructor; or if the instantiation fails for some
	 *             other reason.
	 * 
	 * @since Project v1.0
	 * @see #getString(Object)
	 */
	private static String
			extractMethodNames(Class classObject, Object objectInstance, String methodName, Method method)
					throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
					InstantiationException
	{
		if (methodName.startsWith("set"))
		{
			// Do nothing. We are interested only on get methods in toString method.
		}
		else
		{
			return methodName.substring(3) + " = " + method.invoke(objectInstance, (Object[]) null) + ", ";
		}

		return "";
	}
}
