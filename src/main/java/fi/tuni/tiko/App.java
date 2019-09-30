package fi.tuni.tiko;

/**
 * Calculator app for version control practice
 * 
 */
public class App 
{
    static Calculator calculator;
    public static void main( String[] args )
    {
        calculator = new Calculator();
        if (args.length > 0) {
            parseArgs(args);
        } else {
            console();
        }
    }

    private static void console() {
        
    }

    private static void parseArgs(String[] args) {
        if (args.length != 3) {
            System.out.println("Please give three arguments.");
        }
        int a = parseArgNumber(args[0]);
        int b = parseArgNumber(args[2]);
        char c = args[1].charAt(0);

        int result = 0;

        if (c == '+') {
            result = calculator.addition(a, b);
        } else if (c == '-') {
	        result = calculator.subtract(a, b);
	    } else if (c == '*') {
	        result = calculator.multiplication(a, b);
	    } else if (c == '/') {
	        result = calculator.divide(a, b);
        } else if (c == 'p'){
            calculator.startPoemGenerator();
        } else if (c == 's'){
            calculator.startSnake();
        }
        
        else {
            System.out.println("Please give a valid command. (+, -, *, /");
            System.exit(0);
        }
        System.out.println(result);
    }

    private static int parseArgNumber(String arg) {
        int parsedValue = 0;
        try {
            parsedValue = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers to the arguement.");
            System.exit(0);
        }
        return parsedValue;
    }
}
