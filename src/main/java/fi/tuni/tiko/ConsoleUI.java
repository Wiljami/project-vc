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
    private final String SUBSTRACTION = "substraction";
    private final String MULTIPLICATION = "multiplication";
    //private final String QUIT = "quit";
    private final String[] QUIT = {"quit", "q"};
    private final String LINESTART = "> ";

    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
        this.input = new Scanner(System.in);
    }

    public void start() {
        printIntro();
        boolean running = true;
        while (running) {
            System.out.print(LINESTART);
            String command = input.nextLine();
            command = command.toLowerCase();
            if (command.equals(HELP)) {
                printHelp();
            } else if (command.equals(ADDITION)) {
                addition();
            } else if (command.equals(SUBSTRACTION)) {
                substraction();
            } else if (command.equals(MULTIPLICATION)) {
                multiplication();
            } else if (checkCommand(QUIT, command)) {
                System.out.println("Good bye");
                running = false;
                continue;
            } else {
                System.out.println("Unknown command. Type 'help' for commands.");
            }
        }
    }

    private boolean checkCommand(String[] commands, String command) {
        for (String cmd : commands) {
            if (command.equals(cmd)) return true;
        }
        return false;
    }

    private void multiplication() {
        int a = askFirstValue();
        int b = askSecondValue();
        int result = calculator.multiplication(a, b);
        System.out.println(a + " times " + b + " is " + result); 

    }

    private void addition() {
        int a = askFirstValue();
        int b = askSecondValue();
        int sum = calculator.addition(a, b);
        System.out.println("Sum of " + a + " and " + b + " is " + sum); 
    }

    private void substraction() {
        int a = askFirstValue();
        int b = askSecondValue();
        int result = calculator.subtract(a, b);
        System.out.println(a + " minus " + b + " is " + result);
    }

    private int askFirstValue() {
        System.out.println("Give first value");
        return askInteger();
    }

    private int askSecondValue() {
        System.out.println("Give second value");
        return askInteger();
    }

    private int askInteger() {
        boolean okValue = false;
        int i = 0;
        while (!okValue) {
            System.out.print(LINESTART);
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
        System.out.println(HELP + " - this printout");
        System.out.println(ADDITION + " - addition");
        System.out.println(SUBSTRACTION + " - substraction");
        System.out.println(QUIT + " - quits");
    }
}