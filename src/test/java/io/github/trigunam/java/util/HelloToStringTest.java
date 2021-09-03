package io.github.trigunam.java.util;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.trigunam.java.HelloToString;

/**
 * Test class to test the to-string implementation.
 * 
 * @author Triguna
 * @since Project v1.0
 */
public class HelloToStringTest {
	private static final Logger _logger = LoggerFactory.getLogger(HelloToStringTest.class);

	HelloToString helloToString;

	/**
	 * @return the Logger
	 */
	public static Logger getLogger() {
		return _logger;
	}

	/**
	 * @param helloToString
	 *            the helloToString to set
	 */
	public void setHelloToString(HelloToString helloToString) {
		this.helloToString = helloToString;
	}

	/**
	 * @return the helloToString
	 */
	public HelloToString getHelloToString() {
		return this.helloToString;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.setHelloToString(new HelloToString("Triguna", Arrays.asList(new String[] { "Bangalore", "Karnataka",
				"India" }), Calendar.getInstance()));
	}

	/**
	 * Test method for {@link org.company.utility.tostring.HelloToString#toString()}.
	 */
	@Test
	public void testToString() {
		long start = System.currentTimeMillis();
		// Using slf4j over logback to print the toString implementation for HelloToString.
		getLogger().debug("{}", this.getHelloToString().toString());
		System.out.println(this.getHelloToString().toString());

		System.out.println("Time taken to use toString method = " + ((System.currentTimeMillis() - start) / 1000.0)
				+ " ms");
	}
}
