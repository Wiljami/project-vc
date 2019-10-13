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

        add(generateBtn);
        add(poemTextArea);
    }
    
}