package fi.tuni.tiko;

import java.util.List;

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


    commands = new ArrayList<Command>();
    private void setupCommands() {
        commands.add(new Command(HELP, " - this printout"));
    }

}