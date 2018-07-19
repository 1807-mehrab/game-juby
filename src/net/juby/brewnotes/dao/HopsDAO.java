package net.juby.brewnotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.juby.brewnotes.Hops;
import net.juby.util.ConnectionUtil;

/**
 * Data access object definition for the hops table
 * 
 * @author Andrew
 *
 */
public class HopsDAO {

	/**
	 * Creates a Hops object corresponding to the specified id
	 * 
	 * @param id
	 *            the database id of the the hops we're looking for
	 * @return a Hops object containing the data for the specified id
	 */
	public Hops getHops(int id) {
		PreparedStatement ps = null;
		Hops h = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select * from hops join hops_recipes on h_id = h_r_hops where h_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int h_id = rs.getInt("h_id");
				String name = rs.getString("h_name");
				String notes = rs.getString("h_notes");
				double weight = rs.getDouble("h_r_oz");
				double aa = rs.getDouble("h_alpha_acids");
				int time = rs.getInt("h_r_add_time");

				h = new Hops(h_id, name, notes, weight, aa, time);
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return h;
	}

	/**
	 * Generates a list of all hops in the database.
	 * 
	 * @return a List of Hops objects corresponding to all hops in the database
	 */
	public List<Hops> getAllHops() {
		PreparedStatement ps = null;
		Hops h = null;
		List<Hops> hops = new ArrayList<Hops>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select * from hops";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("h_id");
				String name = rs.getString("h_name");
				String notes = rs.getString("h_notes");

				h = new Hops(id, name, notes, 0, 0, 0);
				hops.add(h);
			}

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return hops;
	}

	/**
	 * Adds the specified hops information to the database. If h.id is greater than
	 * 0, it is assumed this is an existing record and will be updated accordingly.
	 * 
	 * @param h the Hops data to be added/updated
	 * @throws SQLException if there is an error updating the database
	 */
	public void addHops(Hops h) throws SQLException {
		PreparedStatement ps = null;
		String sql = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			if(h.getId() > 0) {
				sql = "Update hops set h_name = ? , h_alpha_acids = ? , h_notes = ? where h_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, h.getName());
				ps.setDouble(2, h.getAlphaAcids());
				ps.setString(3, h.getNotes());
				ps.setInt(4, h.getId());
			} else {
				sql = "Insert into hops (h_name, h_alpha_acids, h_notes) values (?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, h.getName());
				ps.setDouble(2, h.getAlphaAcids());
				ps.setString(3, h.getNotes());
			}
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return;
	}

}
