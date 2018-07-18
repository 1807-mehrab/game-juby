package net.juby.brewnotes;

public class User {
	private int id;
	private String name, longName;

	/**
	 * @param id
	 *            database id of this User
	 * @param name
	 *            user name of this User
	 * @param longName
	 *            full name of this User
	 */
	public User(int id, String name, String longName) {
		super();
		this.id = id;
		this.name = name;
		this.longName = longName;
	}

	/**
	 * @return user name for this user
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the user name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the full name of this User
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * @param longName
	 *            the full name to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}

	/**
	 * @return the database id of this User
	 */
	public int getId() {
		return id;
	}

}