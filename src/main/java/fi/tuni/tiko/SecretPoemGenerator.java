package fi.tuni.tiko;
import java.util.Scanner;

public class SecretPoemGenerator{
    Scanner scanner;

    public SecretPoemGenerator(){
        scanner = new Scanner(System.in);
    }

    public void startPoemGenerator(){
        System.out.println("\nYou found a Secret Poem Generator.");
        System.out.println("Welcome, Friend!");
        System.out.println("\n         **************************************");
        System.out.println();
        askPoets();
    }

    public void askPoets(){
        System.out.println("Eino Leino    William Shakespeare    Thomas Tranströmer    Charles Baudelaire");
        System.out.println("Pick a poet and press enter: ");
        String poet1 = scanner.nextLine();
        System.out.println("Pick another poet: ");
        String poet2 = scanner.nextLine();
        System.out.println();
        System.out.println("Choose a theme [Love / Death]: ");
        String theme = scanner.nextLine();
        System.out.println("\n(" + poet1 + " + " + poet2 + ") * " + theme + ". Coming right up! [Press Enter]" );
    }

    public void readPoemFiles(){
        //To-do: this method
    }

}