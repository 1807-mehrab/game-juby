package net.juby.brewnotes;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word = null;

        System.out.print("> ");
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word = tokenizer.next();
            if (tokenizer.hasNext()) {
            	tokenizer.close();
                return null;
            }
        }
        tokenizer.close();

        //Check if words are known
        if (commands.isCommand(word)) {
            return new Command(word);
        }
        
        return null;
    }

    public void showCommands() {
        commands.showAll();
    }
}