package fi.tuni.tiko;
import java.util.ArrayList;

public class PoetAndTheme{
    ArrayList<String> verseLines;
    String nameAndTheme;

    public PoetAndTheme(String themeAndPoet){
        verseLines = new ArrayList<>();
        this.nameAndTheme = themeAndPoet;
    }

    public void addVerseLine(String verseLine){
        this.verseLines.add(verseLine);
    }

    public String getRandomVerseLine(){
        return " ";
    }
}