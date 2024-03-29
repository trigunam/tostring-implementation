package io.github.trigunam.java;

import java.util.Calendar;
import java.util.List;

import io.github.trigunam.java.util.Utilities;

/**
 * Hello World program to describe the toString-implementation project. This is a sample POJO class.
 * 
 * @author Triguna
 * @since Project v1.0
 */
public class HelloToString /* extends AssessmentItem */{
	long id = 1;
	String name;
	List<String> addresses;
	Calendar now;

	/**
	 * Default constructor.
	 */
	public HelloToString() {
		// Do not delete this.
	}

	/**
	 * Constructor to take name and address for the HelloToString.
	 * 
	 * @param name Name as defined by the class
	 * @param addresses Addresses as defined by the class
	 */
	public HelloToString(String name, List<String> addresses) {
		this.setName(name);
		this.setAddresses(addresses);
	}

	/**
	 * Constructor to take name and address for the HelloToString.
	 * 
	 * @param name Name as defined by the class
	 * @param addresses Addresses as defined by the class
	 * @param now Calendar instance for today's date
	 */
	public HelloToString(String name, List<String> addresses, Calendar now) {
		this.setName(name);
		this.setAddresses(addresses);
		this.setNow(now);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addresses
	 */
	public List<String> getAddresses() {
		return this.addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the now
	 */
	public Calendar getNow() {
		return this.now;
	}

	/**
	 * @param now
	 *            the now to set
	 */
	public void setNow(Calendar now) {
		this.now = now;
	}

	@Override
	public String toString() {
		return Utilities.toString(this);
	}

}
