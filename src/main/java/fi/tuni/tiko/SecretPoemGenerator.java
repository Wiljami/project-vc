package fi.tuni.tiko;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class SecretPoemGenerator{
    Scanner scanner;
    ArrayList<PoetAndTheme> poetsAndThemesList;

    public SecretPoemGenerator(){
        scanner = new Scanner(System.in);
        poetsAndThemesList = new ArrayList<>();
    }

    public void startPoemGenerator(){
        System.out.println("\nYou found a Secret Poem Generator.");
        System.out.println("Welcome, Friend!");
        System.out.println("\n         **************************************");
        System.out.println();
        askPoets();
        readPoemFiles();
        fetchVerseLines();
    }

    public void askPoets(){
        System.out.println("Walt Withman    William Shakespeare    John Keats    Emily Dickinson");
        System.out.println("Pick a poet and press enter: ");
        String poet1 = scanner.nextLine();
        System.out.println("Pick another poet: ");
        String poet2 = scanner.nextLine();
        System.out.println();
        System.out.println("Choose a theme [Love / Death]: ");
        String theme = scanner.nextLine();
        System.out.println("\n(" + poet1 + " + " + poet2 + ") * " + theme + ". Coming right up! [Press Enter]" );
        String ignore = scanner.nextLine();
    }

    public void readPoemFiles(){
        //To-do: this method
        try (Scanner fileScan = new Scanner(new File("poems.txt"))) {
            //Poems.txt consist of a header (poet and theme) plus verse lines.
            //First loop reads the header and creates object 'PoetAndTheme'.
            while (fileScan.hasNextLine()){
                String themeAndPoet = fileScan.nextLine();
                PoetAndTheme addToList = new PoetAndTheme(themeAndPoet);
                //Second loop reads verse lines and adds them to object 'PoetAndTheme'.
                while(fileScan.hasNextLine()){
                    String verseLine = fileScan.nextLine();
                    if (verseLine.isEmpty()){
                        break;
                    }
                    addToList.addVerseLine(verseLine);
                }
                poetsAndThemesList.add(addToList);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void fetchVerseLines(){
        System.out.println(poetsAndThemesList.get(0).getRandomVerseLine());
    }

}