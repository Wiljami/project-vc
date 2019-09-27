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
        printIntro();
        boolean running = true;
        while (running) {
            String command = input.nextLine();
            command = command.toLowerCase();
            if (command.equals("help")) {
                printHelp();
            } else if (command.equals("addition")) {
                addition();
            } else if (command.equals("quit")) {
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
        int a = Integer.parseInt(input.nextLine());
        System.out.print("Give second value: ");
        int b = Integer.parseInt(input.nextLine());
        int sum = calculator.addition(a, b);
        System.out.println("Sum of " + a + " and " + b + " is " + sum); 
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