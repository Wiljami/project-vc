package fi.tuni.tiko;

import java.util.*;

class ConsoleCommands {
    private final String[] HELP = {"help", "h"};
    private final String[] ADDITION = {"addition", "add", "+"};
    private final String[] SUBSTRACTION = {"substraction", "sub", "-"};
    private final String[] MULTIPLICATION = {"multiplication", "multi", "*"};
    private final String[] DIVISION = {"division", "divide", "div", "/"};
    private final String[] FIBONACCI = {"fibonacci", "fibo", "f"};
    private final String[] QUIT = {"quit", "q"};
    private final String LINESTART = "> ";
    
    private final String[] CALCULATOR = {"calculator", "calc", "c"};
    private final String[] POEM = {"poem", "p", "secret poem generator"};
    private final String[] SNAKE = {"snake", "s", "snaek"};
    
    private List<Command> commands;
    private ConsoleUI consoleUI;
    private Calculator calculator;

    public ConsoleCommands(ConsoleUI consoleUI, Calculator calculator) {
        this.consoleUI = consoleUI;
        this.calculator = calculator;
        commands = new ArrayList<Command>();
        setupCommands();
    }

    private void setupCommands() {
        commands.add(new Command(HELP, " - this printout"){
            @Override
            void run() {
                consoleUI.printHelp(commands);
            }
        });

        commands.add(new Command(ADDITION, " - addition"){
            @Override
            void run() {
                int a = consoleUI.askFirstValue();
                int b = consoleUI.askSecondValue();
                System.out.println(calculator.addition(a, b));
            }
        });
    }
}