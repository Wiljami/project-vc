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

    }

    public int addition(int x, int y) {
        return x+y;
    }

    public int divide(int x, int y) {
        return x/y;
    }
}
