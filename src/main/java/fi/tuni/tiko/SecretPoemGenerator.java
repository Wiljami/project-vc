package fi.tuni.tiko;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.lang.Math;

public class SecretPoemGenerator{
    Scanner scanner;
    ArrayList<PoetAndTheme> poetsAndThemesList;
    ArrayList<String> printablePoem;
    String poet1;
    String poet2;
    String theme;

    public SecretPoemGenerator(){
        scanner = new Scanner(System.in);
        poetsAndThemesList = new ArrayList<>();
        printablePoem = new ArrayList<>();
    }

    public void startPoemGenerator(){
        System.out.println("\nYou found a Secret Poem Generator.");
        System.out.println("Welcome, Friend!");
        System.out.println("\n         **************************************");
        System.out.println();
        readPoemFiles();
        askPoets();
        try{
            fetchVerseLines();
        }catch(Exception e){
            System.out.println("Invalid input. Please, try again!");
        }
        
    }

    /**
    * Ask user input for two poets and a theme. Print out summary of user's picks.
    *
    */
    public void askPoets(){
        System.out.println("Walt Withman    William Shakespeare    John Keats    Emily Dickinson");
        System.out.println("Pick a poet and press enter: ");

        String poet1_input = scanner.nextLine();
        if (poet1_input.toLowerCase().contains("withman") || poet1_input.toLowerCase().contains("witman")){
            poet1 = "Withman";
        }else if (poet1_input.toLowerCase().contains("shakespeare") || poet1_input.toLowerCase().contains("shakespear")){
            poet1 = "Shakespeare";
        }else if (poet1_input.toLowerCase().contains("keats")){
            poet1 = "Keats";
        }else if (poet1_input.toLowerCase().contains("dickinson") || poet1_input.toLowerCase().contains("dikcinson")){
            poet1 = "Dickinson";
        }

        System.out.println("Pick another poet: ");
        String poet2_input = scanner.nextLine();
        if (poet2_input.toLowerCase().contains("withman") || poet2_input.toLowerCase().contains("witman")){
            poet2 = "Withman";
        }else if (poet2_input.toLowerCase().contains("shakespeare") || poet2_input.toLowerCase().contains("shakespear")){
            poet2 = "Shakespeare";
        }else if (poet2_input.toLowerCase().contains("keats")){
            poet2 = "Keats";
        }else if (poet2_input.toLowerCase().contains("dickinson") || poet2_input.toLowerCase().contains("dikcinson")){
            poet2 = "Dickinson";
        }
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

    public void fetchVerseLines() throws IncorrectInput{
        String strObject1 = "";
        PoetAndTheme object1 = poetsAndThemesList.get(0);
        String strObject2 = "";
        PoetAndTheme object2 = poetsAndThemesList.get(0);
        strObject1 = userInputToPoet(poet1, theme);
        strObject2 = userInputToPoet(poet2, theme);

        for(PoetAndTheme object: poetsAndThemesList){
            if (object.getNameAndTheme().equals(strObject1)){
                object1 = object;
            }
            if (object.getNameAndTheme().equals(strObject2)){
                object2 = object;
            }
        }
        //Poems length is a random number between 5 and 10
        int poemLength = getRandomPoemLength();

        if(poemLength % 2 == 0){
            for (int i=0; i < (poemLength/2); i++){
                if(i != (poemLength/2 - 1)){
                    System.out.println(object1.getRandomVerseLine());
                    System.out.println(object2.getRandomVerseLine());
                }else{
                    System.out.println(object1.getRandomVerseLine());

                    //Checking if the last verse line ends with period or question mark.
                    //If not, get a new verse line.
                    System.out.println(getLastPoemLine(object2));
                }
                
            }
        }else{
            for (int i=0; i < (poemLength/2 - 1); i++){
                System.out.println(object1.getRandomVerseLine());
                System.out.println(object2.getRandomVerseLine());
            }

            //Checking if the last verse line ends with period or question mark.
            //If not, get a new verse line.
            System.out.println(getLastPoemLine(object1));
        }
        
        
    }

    public String userInputToPoet(String poet, String theme) throws IncorrectInput{
        String returnable = "";
        if(poet.equals("Withman")){
            if(theme.equals("Love")){
                returnable = "love Withman";
            }else{
                returnable = "death Withman";
            }
        }else if(poet.equals("Shakespeare")){
            if(theme.equals("Love")){
                returnable = "love Shakespeare";
            }else{
                returnable = "death Shakespeare";
            }
        }else if(poet.equals("Keats")){
            if(theme.equals("Love")){
                returnable = "love Keats";
            }else{
                returnable = "death Keats";
            }
        }else if(poet.equals("Dickinson")){
            if(theme.equals("Love")){
                returnable = "love Dickinson";
            }else{
                returnable = "death Dickinson";
            }
        }else{
            IncorrectInput e = new IncorrectInput();
            throw e;
        }
        return returnable;
    }

    public int getRandomPoemLength(){
        double poemLengthDouble = Math.random() * 4 + 6;
        int poemLength = (int) poemLengthDouble;
        return poemLength;
    }

    public String getLastPoemLine(PoetAndTheme object){
        boolean lastCharDot = false;
        String lastVerseLine = "";
        while(!lastCharDot){
            lastVerseLine = object.getRandomVerseLine();
            if(lastVerseLine.substring(lastVerseLine.length() - 1).equals(".") ||
                lastVerseLine.substring(lastVerseLine.length() - 1).equals("!")||
                lastVerseLine.substring(lastVerseLine.length() - 1).equals("?")){
                lastCharDot = true;
            }
        }
        return lastVerseLine;
    }

}
class IncorrectInput extends Exception{}