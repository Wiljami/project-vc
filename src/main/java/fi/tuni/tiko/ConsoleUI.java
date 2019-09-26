package fi.tuni.tiko;

import java.util.Scanner;

/**
 * An UI to be used in console.
 */

class ConsoleUI {
    private Calculator calculator;
    private Scanner input;

    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
        this.input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the calculator.");
        System.out.println("Type help for commands.");

        while (true) {
            String command = input.nextLine();
            if (command.equals("help")) {
                printHelp();
            } else if (command.equals("quit")) {
                System.out.println("Good bye");
                break;
            } else {
                System.out.println("Unknown command. Type 'help' for commands.");
            }
        }
    }

    private void printHelp() {
        System.out.println("help - this printout");
        System.out.println("quit - quits");
    }
}