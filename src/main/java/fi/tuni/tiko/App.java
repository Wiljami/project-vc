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
        }
    }

    private static void parseArgs(String[] args) {
        if (args.length != 3) {
            System.out.println("Please give three arguments.");
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);
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
	    } else {
            System.out.println("Please give a valid command. (+, -, *, /");
        }
        System.out.println(result);
    }
}
