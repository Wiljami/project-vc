package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

class PoemWindow extends JFrame{
    JButton generateBtn;
    JTextArea poemTextArea;

    public PoemWindow(){
    setSize(300, 300);
    setTitle("Poem generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }

    public void createGUI(){
        setLayout(new BorderLayout());
        generateBtn = new JButton("Generate poem");
        poemTextArea = new JTextArea("test", 10, 10);

        add(generateBtn);
        add(poemTextArea);
    }
    
}