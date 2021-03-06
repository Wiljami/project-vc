package fi.tuni.tiko;

import java.util.List;
import java.util.Scanner;

/**
 * An UI to be used in console.
 */

class ConsoleUI {
    private Calculator calculator;
    private Scanner input;

    private final String[] HELP = {"help", "h"};
    private final String[] ADDITION = {"addition", "add", "+"};
    private final String[] SUBSTRACTION = {"substraction", "sub", "-"};
    private final String[] MULTIPLICATION = {"multiplication", "multi", "*"};
    private final String[] DIVISION = {"division", "divide", "div", "/"};
    private final String[] FIBONACCI = {"fibonacci", "fibo", "f"};
    private final String[] GRAPHCALC = {"graphicalcalculator", "graphcalc", "gcalc", "g"};
    private final String[] QUIT = {"quit", "q"};
    private final String LINESTART = "> ";

    private final String[] COFFEE = 
            {"coffee counter", "coffee", "cof", "black liquid of the gods"};
    private final String[] CALCULATOR = {"calculator", "calc", "c"};
    private final String[] POEM = {"poem", "p", "secret poem generator"};
    private final String[] POEMWINDOW = {"poem window", "pw"};
    private final String[] SNAKE = {"snake", "s", "snaek"};

    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
        this.input = new Scanner(System.in);
    }

    private boolean running = true;

    public void runModule(CalculatorConsole module) {
        while(running) {
            System.out.println(module.INTRO);
            String command = askCommand();
            boolean okCommand = false;
            for (Command c : module.getCommands()) {
                if (checkCommand(c.getStr(), command)) {
                    c.run();
                    okCommand = true;
                    continue;
                }
            }
            if (!okCommand) {
                System.out.println(module.BADCOMMAND);
            }
        }
    }

    private String askCommand() {
        System.out.print(LINESTART);
        String command = input.nextLine();
        return command.toLowerCase();
    }

    public void start() {
        printIntro();
        boolean run = true;
        while (run) {
            System.out.print(LINESTART);
            String command = input.nextLine();
            command = command.toLowerCase();
            if (checkCommand(HELP, command)) {
                printHelp();
            } else if (checkCommand(ADDITION, command)) {
                addition();
            } else if (checkCommand(SUBSTRACTION, command)) {
                substraction();
            } else if (checkCommand(MULTIPLICATION, command)) {
                multiplication();
            } else if (checkCommand(DIVISION, command)) {
                division();
            } else if (checkCommand(FIBONACCI, command)) {
                fibonacci();
            } else if (checkCommand(QUIT, command)) {
                System.out.println("Good bye");
                run = false;
                continue;
            } else {
                System.out.println("Unknown command. Type 'help' for commands.");
            }
        }
    }

    public void startLaunchUI() {
        System.out.println("Give launch arguement");
        System.out.print(LINESTART);
        String command = input.nextLine();
        command = command.toLowerCase();
        if (checkCommand(CALCULATOR, command)) {
            start();
        } else if (checkCommand(POEM, command)) {
            calculator.startPoemGenerator();
        } else if (checkCommand(POEMWINDOW, command)) {
            PoemWindow window = new PoemWindow();
        } else if (checkCommand(SNAKE, command)) {
            calculator.startSnake();
        } else if (checkCommand(GRAPHCALC, command)) {
            Window Window = new Window("calculator");
        } else if (checkCommand(COFFEE, command)) {
            CoffeeCounter cc = new CoffeeCounter();
        } else {
            System.out.println("Unknown command");
        }
    }

    private boolean checkCommand(String[] commands, String command) {
        for (String cmd : commands) {
            if (command.equals(cmd)) return true;
        }
        return false;
    }

    private void fibonacci() {
        int a = askFirstValue();
        int[] result = calculator.fibonacci(a);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void division() {
        int a = askFirstValue();
        int b = askSecondValue();
        int result = calculator.divide(a, b);
        System.out.println(a + " divided by " + b + " is " + result);
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

    public int askValueWithPrompt(String prompt) {
        System.out.println(prompt);
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

    void printHelp(List<Command> commands) {
        for (Command c : commands) {
            System.out.println(c.getStr()[0] + c.getDesc());
        }
    }

    void printHelp() {
        System.out.println(HELP[0] + " - this printout");
        System.out.println(ADDITION[0] + " - addition");
        System.out.println(SUBSTRACTION[0] + " - substraction");
        System.out.println(MULTIPLICATION[0] + " - multiplication");
        System.out.println(DIVISION[0] + " - division");
        System.out.println(FIBONACCI[0] + " - fibonacci series");
        System.out.println(QUIT[0] + " - quits");
    }

    void quit(String msg) {
        System.out.println(msg);
        running = false;
    }
}