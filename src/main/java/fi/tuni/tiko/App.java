package fi.tuni.tiko;

/**
 * Calculator app for version control practice
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
    }

    public int addition(int x, int y) {
        return x+y;
    }

    public int divide(int x, int y) {
        return x/y;
    }
}
