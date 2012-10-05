package org.company.utility.tostring;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class to test the to-string implementation.
 * 
 * @author Triguna
 * @since Project v1.0
 */
public class HelloToStringTest
{
	private static final Logger _logger = LoggerFactory.getLogger(HelloToStringTest.class);

	HelloToString helloToString;

	/**
	 * @return the Logger
	 */
	public static Logger getLogger()
	{
		return _logger;
	}

	/**
	 * @param helloToString
	 *            the helloToString to set
	 */
	public void setHelloToString(HelloToString helloToString)
	{
		this.helloToString = helloToString;
	}

	/**
	 * @return the helloToString
	 */
	public HelloToString getHelloToString()
	{
		return this.helloToString;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		this.setHelloToString(new HelloToString("Triguna", Arrays.asList(new String[] {
				"Bangalore", "Karnataka", "India"
		})));
	}

	/**
	 * Test method for {@link org.company.utility.tostring.HelloToString#toString()}.
	 */
	@Test
	public void testToString()
	{
		// Using slf4j over logback to print the toString implementation for HelloToString.
		getLogger().debug("{}", this.getHelloToString().toString());
	}
}
