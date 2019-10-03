package fi.tuni.tiko;
import java.util.ArrayList;
import java.lang.Math;

public class PoetAndTheme{
    ArrayList<String> verseLines;
    String nameAndTheme;

    public PoetAndTheme(String themeAndPoet){
        verseLines = new ArrayList<>();
        this.nameAndTheme = themeAndPoet;
    }

    public String getNameAndTheme(){
        return this.nameAndTheme;
    }

    public void addVerseLine(String verseLine){
        this.verseLines.add(verseLine);
    }

    public String getRandomVerseLine(){
        double rndDouble = Math.random() * (this.verseLines.size() - 1);
        int rnd = (int) rndDouble;
        return this.verseLines.get(rnd);
    }
}