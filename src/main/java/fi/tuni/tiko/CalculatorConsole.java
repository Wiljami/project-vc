package fi.tuni.tiko;

import java.util.ArrayList;
import java.util.List;

/**
 * CalculatorConsole is a module for the console UI.
 * 
 * CalculatorConsole holds information and functions for Calculator App to be
 * used with the ConsoleUI.
 * 
 * @author Viljami Pietarila
 * @version 20191019
 */

class CalculatorConsole {
    /**
     * Array of command words for the HELP command
     */
    private final String[] HELP = { "help", "h" };

    /**
     * Description of the HELP command
     */
    private final String HELPDESC = " - this printout.";

    /**
     * Array of command words for the ADDITION command
     */
    private final String[] ADDITION = { "addition", "add", "+" };

    /**
     * Description of the ADDITION command
     */
    private final String ADDITIONDESC = " - addition.";

    /**
     * Array of command words for the SUBSTRACTION command
     */
    private final String[] SUBSTRACTION = { "substraction", "sub", "-" };

    /**
     * Descrption of the SUBSTRACTION command
     */
    private final String SUBSTRACTIONDESC = "- substraction.";
    
    /**
     * Array of command words for the MULTIPLICATION command
     */
    private final String[] MULTIPLICATION = { "multiplication", "multi", "*" };

    /**
     * Descrption of the MULTIPLICATION command
     */
    private final String MULTIPLICATIONDESC = " - multiplication.";
    private final String[] DIVISION = { "division", "divide", "div", "/" };
    private final String DIVISIONDESC = " - division.";
    private final String[] FIBONACCI = { "fibonacci", "fibo", "f" };
    private final String FIBONACCIDESC = " - fibonacci series";
    private final String[] QUIT = { "quit", "q" };
    private final String QUITDESC = " - exits the program";
    final String BADCOMMAND = "Unknown command";
    final String INTRO = "Welcome to the calculator console UI.\nType help for commands.";

    private final String[] GRAPHCALC = { "graphicalcalculator", "gcalc", "g" };
    private final String[] CALCULATOR = { "calculator", "calc", "c" };
    private final String[] POEM = { "poem", "p", "secret poem generator" };
    private final String[] SNAKE = { "snake", "s", "snaek" };

    private final String WELCOMEMESSAGE = "Welcome to the Calculator!\nType help for commands";
    private final String FIRSTVALUE = "Give first value";
    private final String SECONDVALUE = "Give second value";
    private final String SERIESTARGET = "How far into the series";
    private final String DEFAULTRESULT = "The result is ";
    private final String QUITMESSAGE = "Good bye!";

    private List<Command> commands;
    private ConsoleUI consoleUI;
    private Calculator calculator;

    /**
     * CalculatorConsole constructor.
     * 
     * The constructor setups the commands.
     * 
     * @param consoleUI  Reference to the UI element
     * @param calculator Reference to the App
     */
    public CalculatorConsole(ConsoleUI consoleUI, Calculator calculator) {
        this.consoleUI = consoleUI;
        this.calculator = calculator;
        commands = new ArrayList<Command>();
        setupCommands();
        setupBonusCommands();
        consoleUI.runModule(this);
    }

    /**
     * setupBonusCommands method for further command setup
     * 
     * Bonus commands are bonus or 'hidden' commands of the app.
     * They're not part of the Calculator proper, thus they're seperated
     * to a different method
     */
    private void setupBonusCommands() {
        commands.add(new Command(GRAPHCALC, "") {
            @Override
            void run() {
                Window Window = new Window("calculator");
            }
        });

        commands.add(new Command(POEM, "") {
            @Override
            void run() {
                SecretPoemGenerator poems = new SecretPoemGenerator();
                poems.startPoemGenerator();
            }
        });

        commands.add(new Command(SNAKE, "") {
            @Override
            void run() {
                SecretSnake snake = new SecretSnake();
                snake.startSnake();
            }
        });
    }

    /**
     * setupCommands method for command setups
     * 
     * SetupCommands initiates the different commands of the Console module
     * and adds them to a list.
     */
    private void setupCommands() {
        commands.add(new Command(HELP, HELPDESC) {
            @Override
            void run() {
                consoleUI.printHelp(commands);
            }
        });

        commands.add(new Command(ADDITION, ADDITIONDESC) {
            @Override
            void run() {
                int a = consoleUI.askValueWithPrompt(FIRSTVALUE);
                int b = consoleUI.askValueWithPrompt(SECONDVALUE);
                System.out.println(calculator.addition(a, b));
            }
        });

        commands.add(new Command(SUBSTRACTION, SUBSTRACTIONDESC) {
            @Override
            void run() {
                int a = consoleUI.askValueWithPrompt(FIRSTVALUE);
                int b = consoleUI.askValueWithPrompt(SECONDVALUE);
                System.out.println(calculator.subtract(a, b));
            }
        });

        commands.add(new Command(MULTIPLICATION, MULTIPLICATIONDESC) {
            @Override
            void run() {
                int a = consoleUI.askValueWithPrompt(FIRSTVALUE);
                int b = consoleUI.askValueWithPrompt(SECONDVALUE);
                System.out.println(calculator.multiplication(a, b));
            }
        });

        commands.add(new Command(DIVISION, DIVISIONDESC) {
            @Override
            void run() {
                int a = consoleUI.askValueWithPrompt(FIRSTVALUE);
                int b = consoleUI.askValueWithPrompt(SECONDVALUE);
                System.out.println(calculator.divide(a, b));
            }
        });

        commands.add(new Command(FIBONACCI, FIBONACCIDESC) {
            @Override
            void run() {
                int a = consoleUI.askValueWithPrompt(SERIESTARGET);
                int[] series = calculator.fibonacci(a);
                for (int n : series) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        });

        commands.add(new Command(QUIT, QUITDESC) {
            @Override
            void run() {
                consoleUI.quit(QUITMESSAGE);
            }
        });
    }

    /**
     * getCommands getter
     * @return List of Commands
     */
    public List<Command> getCommands() {
        return commands;
    }
}