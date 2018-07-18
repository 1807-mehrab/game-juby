package net.juby.brewnotes;

import java.sql.*;

public class Main {
	private Parser parser;
	// Declare Connection and Statement objects
	Connection myConnection = null;
	Statement myStatement = null;

	public static void main(String[] args) {
		Main menu = new Main();
		menu.play();
	}

	public Main() {
		parser = new Parser();
	}

	public void play() {
		System.out.println();
		System.out.println("Welcome to Juby's Homebrew Notes");
		System.out.println("A storage system for notes about homebrewed beer");
		System.out.println("Unfortunately, the system is currently read-only.");
		System.out.println("Type one of the commands to view available data.");

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thanks for visiting!");
	}

	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("I don't understand!");
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("hops")) {
			try {
				// Register the driver
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

				// Configure Connection object
				myConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "brewnotes", "p4ssw0rd");

				// disable auto-commit mode
				myConnection.setAutoCommit(false);

				// Create statement object from connection
				myStatement = myConnection.createStatement();

				// Create a ResultSet object for reading data
				ResultSet brewResultSet = myStatement.executeQuery(
						"Select * from hops join hops_recipes on h_r_hops = h_id"
				);
				// loop through rows in ResultSet
				while (brewResultSet.next()) {
					Hops h = new Hops(brewResultSet.getInt("h_id"),
									  brewResultSet.getString("h_name"),
									  brewResultSet.getString("h_notes"),
									  brewResultSet.getDouble("h_r_oz"),
									  brewResultSet.getDouble("h_alpha_acids"),
									  brewResultSet.getInt("h_r_add_time")
					);
					System.out.println(h);
					System.out.println();

				}
				brewResultSet.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					if (myStatement != null) {
						myStatement.close();
					}

					if (myConnection != null) {
						myConnection.close();
					}
				} catch (SQLException ex) {
					ex.getMessage();
				}
			}
		} else if (commandWord.equals("malts")) {
			try {
				// Register the driver
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

				// Configure Connection object
				myConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "brewnotes", "p4ssw0rd");

				// disable auto-commit mode
				myConnection.setAutoCommit(false);

				// Create statement object from connection
				myStatement = myConnection.createStatement();

				// Create a ResultSet object for reading data
				ResultSet brewResultSet = myStatement.executeQuery(
						"Select * from malts join malts_recipes on m_r_malt = m_id"
				);
				// loop through rows in ResultSet
				while (brewResultSet.next()) {
					Malt h = new Malt(brewResultSet.getInt("m_id"),
									  brewResultSet.getString("m_name"),
									  brewResultSet.getString("m_notes"),
									  brewResultSet.getDouble("m_r_oz"),
									  brewResultSet.getBoolean("m_isdry")
					);
					System.out.println(h);
					System.out.println();
				}
				brewResultSet.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					if (myStatement != null) {
						myStatement.close();
					}

					if (myConnection != null) {
						myConnection.close();
					}
				} catch (SQLException ex) {
					ex.getMessage();
				}
			}
		} else if (commandWord.equals("yeast")) {
			// TODO yeast
		} else if (commandWord.equals("recipes")) {
			// TODO recipes
		} else if (commandWord.equals("brews")) {
			// TODO brews
		} else if (commandWord.equals("help")) {
			parser.showCommands();
		} else if (commandWord.equals("exit")) {
			wantToQuit = true;
		}

		return wantToQuit;
	}
}