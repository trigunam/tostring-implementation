package org.company.utility.tostring;

import java.util.List;

/**
 * Hello World program to describe the toString-implementation project. This is a sample POJO class.
 * 
 * @author Triguna
 * @since Project v1.0
 */
public class HelloToString
{
	long id = 1;
	String name;
	List<String> addresses;

	/**
	 * Default constructor.
	 */
	public HelloToString()
	{
		// Do not delete this.
	}

	/**
	 * Constructor to take name and address for the HelloToString.
	 * 
	 * @param name
	 * @param address
	 */
	public HelloToString(String name, List<String> addresses)
	{
		this.setName(name);
		this.setAddresses(addresses);
	}

	/**
	 * @return the id
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the addresses
	 */
	public List<String> getAddresses()
	{
		return this.addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<String> addresses)
	{
		this.addresses = addresses;
	}

	@Override
	public String toString()
	{
		// return Utilities.toString(this, this.getClass());
		return Utilities.toString(this);
	}

}