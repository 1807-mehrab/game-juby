package net.juby.brewnotes.dao;

import java.sql.SQLException;
import java.util.List;
import net.juby.brewnotes.User;

/**
 * Database access object for users
 * 
 * @author Andrew
 *
 */
public class UserDAO {
	/**
	 * Gets user information from the database for the corresponding id
	 * 
	 * @param id
	 *            the database id for the user information
	 * @return a User object containing that information
	 */
	public User getUser(int id) {
		// TODO getUser
		return null;
	}

	/**
	 * Gets a list of all users
	 * 
	 * @return a List containing User objects for each user in the database
	 */
	public List<User> getAllUsers() {
		// TODO getAllUsers
		return null;
	}

	/**
	 * Adds or updates user information in the database. Note that if u.id is
	 * greater than 0, it is assumed the user alread exists and will be updated.
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void addUser(User u) throws SQLException {
		// TODO addUser
	}
}
