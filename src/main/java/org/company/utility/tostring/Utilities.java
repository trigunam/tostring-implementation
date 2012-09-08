package org.company.utility.tostring;

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
	 * @param classObject
	 *            java.lang.Class of the POJO for which toString implementation should be returned.
	 * 
	 * @return POJO getters are invoked and appended to a string which is returned from this method.
	 */
	public static String toString(Object objectInstance, Class classObject)
	{

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
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
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
	 */
	private static String
			extractMethodNames(Class classObject, Object objectInstance, String methodName, Method method)
					throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
					InstantiationException
	{
		if (methodName.startsWith("set"))
		{
			// Do nothing. We are interested only on get methods in toString method.
		} else
		{
			return methodName + " = " + method.invoke(objectInstance, (Object[]) null) + ", ";
		}

		return "";
	}
}
