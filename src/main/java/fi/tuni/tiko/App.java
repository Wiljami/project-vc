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

        Window akkuna = new Window();
    }

    private static void parseArgs(String[] args) {
        if (args.length != 3) {
            return;
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
	    }
        System.out.println(result);

    }
}
