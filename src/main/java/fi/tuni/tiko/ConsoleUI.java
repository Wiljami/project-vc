package fi.tuni.tiko;

import java.util.Scanner;

/**
 * An UI to be used in console.
 */

class ConsoleUI {
    private Calculator calculator;
    private Scanner input;

    private final String HELP = "help";
    private final String ADDITION = "addition";
    private final String QUIT = "quit";

    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
        this.input = new Scanner(System.in);
    }

    public void start() {
        printIntro();
        boolean running = true;
        while (running) {
            String command = input.nextLine();
            command = command.toLowerCase();
            if (command.equals(HELP)) {
                printHelp();
            } else if (command.equals(ADDITION)) {
                addition();
            } else if (command.equals(QUIT)) {
                System.out.println("Good bye");
                running = false;
                continue;
            } else {
                System.out.println("Unknown command. Type 'help' for commands.");
            }
        }
    }

    private void addition() {
        System.out.print("Give first value: ");
        int a = askInteger();
        System.out.print("Give second value: ");
        int b = askInteger();
        int sum = calculator.addition(a, b);
        System.out.println("Sum of " + a + " and " + b + " is " + sum); 
    }

    private int askInteger() {
        boolean okValue = false;
        int i = 0;
        while (!okValue) {
            try {
                i = Integer.parseInt(input.nextLine());
                okValue = true;
            } catch (NumberFormatException e) {
                System.out.println("Please type a whole number.");
            }
        }
        return i;
    }

    private void printIntro() {
        System.out.println("Welcome to the calculator console UI.");
        System.out.println("Type help for commands.");
    }

    private void printHelp() {
        System.out.println("help - this printout");
        System.out.println("quit - quits");
    }
}