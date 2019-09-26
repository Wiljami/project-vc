package fi.tuni.tiko;

class StartConsoleUI {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI(new Calculator());
        consoleUI.start();
    }
}