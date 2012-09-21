package org.company.utility.tostring;

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
	String address;

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
	public HelloToString(String name, String address)
	{
		this.setName(name);
		this.setAddress(address);
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
	 * @return the address
	 */
	public String getAddress()
	{
		return this.address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		// return Utilities.toString(this, this.getClass());
		return Utilities.toString(this);
	}

}
