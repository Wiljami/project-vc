package fi.tuni.tiko;

interface UICommand {
    public void run();
}

abstract class ConsoleCommand implements UICommand {
    String[] commandStrings;
    String description;

    abstract public void run();
}