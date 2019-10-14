package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

class PoemWindow extends JFrame{
    JButton generateBtn;
    JTextArea poemTextArea;
    JPanel pane;

    public PoemWindow(){
    setTitle("Poem generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createGUI();
    pack();
    setVisible(true);
    }

    public void createGUI(){
        setLayout(new BorderLayout());
        pane = new JPanel();
        
        generateBtn = new JButton("Generate poem");
        poemTextArea = new JTextArea("test", 10, 10);

        String[] poets1 = { "Keats","Whitman", "Dickinson","Shakespeare"};
        final JComboBox<String> poetsBox1 = new JComboBox<String>(poets1);

        String[] poets2 = { "Keats","Whitman", "Dickinson","Shakespeare"};
        final JComboBox<String> poetsBox2 = new JComboBox<String>(poets2);

        String[] themes = { "LOVE","DEATH"};
        final JComboBox<String> themesBox = new JComboBox<String>(themes);

        add(generateBtn);
        add(poemTextArea);
        add(poetsBox1);
        add(poetsBox2);
        add(themesBox);
    }
    
}