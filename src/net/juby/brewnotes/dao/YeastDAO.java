package net.juby.brewnotes.dao;

import java.sql.SQLException;
import java.util.List;
import net.juby.brewnotes.Yeast;

/**
 * Data access object for Yeast objects
 * 
 * @author Andrew
 *
 */
public class YeastDAO {
	/**
	 * Returns a Yeast object for the specified id.
	 * 
	 * @param id
	 *            database id for the yeast information
	 * @return a Yeast object containing that information
	 */
	public Yeast getYeast(int id) {
		//TODO getYeast
		return null;
	}

	/**
	 * Returns all of the yeast data in the database.
	 * 
	 * @return a List containing Yeast objects for all information in the yeast
	 *         table
	 */
	public List<Yeast> getAllYeast() {
		//TODO getAllYeast
		return null;
	}

	/**
	 * Adds or updates yeast information in the table. If Yeast.id is greater than
	 * 0, it is assumed that the data already exists and needs to be updated.
	 * 
	 * @param y the Yeast object containing the data to be added/updated
	 * @throws SQLException if the data cannot be added to the database
	 */
	public void addYeast(Yeast y) throws SQLException {
		//TODO addYeast
	}
}
