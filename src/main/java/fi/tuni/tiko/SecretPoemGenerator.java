package fi.tuni.tiko;
import java.util.Scanner;

public class SecretPoemGenerator{
    Scanner scanner;

    public SecretPoemGenerator(){
        scanner = new Scanner(System.in);
    }

    public void startPoemGenerator(){
        System.out.println("You found a Secret Poem Generator.");
        System.out.println("Welcome, Friend!");
        System.out.println("         **************************************");
        System.out.println();
    }

    public void askPoets(){
        System.out.println("Eino Leino    William Shakespeare    Thomas Tranströmer    Charles Baudelaire    Edith Södergran");
        System.out.println("Pick a poet and press enter: ");
        String poet1 = scanner.nextLine();
        System.out.println("Pick another poet: ");
        String poet2 = scanner.nextLine();
        System.out.println();
        System.out.println(poet1 + " + " + poet2 + ". You got it! [Press Enter]" );
    }

}