package net.juby.brewnotes;

import java.sql.*;
import java.util.List;

import net.juby.brewnotes.dao.HopsDAO;

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
			try {
				Command command = parser.getCommand();
				finished = processCommand(command);
			} catch (SQLException e) {
				System.out.println("There has been an error connecting to the database.");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thanks for visiting!");
	}

	private boolean processCommand(Command command) throws SQLException {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("I don't understand!");
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("hops")) {
			HopsDAO dao = new HopsDAO();
			List<Hops> hopsList = dao.getAllHops();
			for (Hops hops : hopsList) {
				System.out.println(hops);
				System.out.println();
			}
		} else if (commandWord.equals("malts")) {
			// TODO malts
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