package fi.tuni.tiko;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class SecretPoemGenerator{
    Scanner scanner;
    ArrayList<PoetAndTheme> poetsAndThemesList;
    String poet1;
    String poet2;
    String theme;

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

        String poet1_input = scanner.nextLine();
        if (poet1_input.toLowerCase().contains("withman")){
            poet1 = "Withman";
        }else if (poet1_input.toLowerCase().contains("shakespeare")){
            poet1 = "Shakespeare";
        } //TO-DO: exception handling

        System.out.println("Pick another poet: ");
        String poet2_input = scanner.nextLine();
        if (poet2_input.toLowerCase().contains("withman")){
            poet2 = "Withman";
        }else if (poet1_input.toLowerCase().contains("shakespeare")){
            poet2 = "Shakespeare";
        } //TO-DO: exception handling
        System.out.println();

        System.out.println("Choose a theme [Love / Death]: ");
        String theme_input = scanner.nextLine();
        if(theme_input.toLowerCase().contains("love")){
            theme = "Love";
        }else if(theme_input.toLowerCase().contains("death")){
            theme = "Death";
        }
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
        PoetAndTheme object1;
        PoetAndTheme object2;
        if(theme.equals("Love")){
            if(poet1.equals("Withman") | poet2.equals("Withman")){

            }else if(poet1.equals("Shakespeare") | poet2.equals("Shakespeare")){
                
            }
        }else{
        }
        System.out.println(poetsAndThemesList.get(0).getRandomVerseLine());
    }

}