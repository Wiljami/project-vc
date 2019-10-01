package fi.tuni.tiko;

interface UICommand {
    public void run();
}

abstract class ConsoleCommand implements UICommand {
    String[] commandStrings;
    String description;

    public ConsoleCommand(String[] strings, String desc) {
        commandStrings = strings;
        description = desc;
    }

    abstract public void run();
}