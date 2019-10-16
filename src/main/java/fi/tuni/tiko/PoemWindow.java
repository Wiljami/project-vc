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
    setLocation(100, 100);
    createGUI();
    setSize(500, 400);
    setVisible(true);
    }

    public void createGUI(){
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(8));
        
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