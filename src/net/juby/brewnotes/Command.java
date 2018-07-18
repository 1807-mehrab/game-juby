package net.juby.brewnotes;

public class Command {
    private String commandWord;

    public Command(String word) {
        commandWord = word;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }
}