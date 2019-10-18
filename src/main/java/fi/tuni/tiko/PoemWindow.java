package fi.tuni.tiko;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class PoemWindow extends JFrame{
    JButton generateBtn;
    JLabel poemTextArea;
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
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(8));
        
        generateBtn = new JButton("Generate poem");
        String firstLine = "What is called good is perfect, and what is called bad is just as perfect,";
        String secondLine = "The day is gone, and all its sweets are gone!";
        String thirdLine = "To think of to-day, and the ages continued henceforward!";
        poemTextArea = new JLabel("<html>" + firstLine + "<br>" + secondLine +
         "<br>" + thirdLine + "<br>" + "<br>" + "</html>", SwingConstants.CENTER);

        String[] poets1 = { "Keats","Whitman", "Dickinson","Shakespeare"};
        final JComboBox<String> poetsBox1 = new JComboBox<String>(poets1);

        String[] poets2 = { "Keats","Whitman", "Dickinson","Shakespeare"};
        final JComboBox<String> poetsBox2 = new JComboBox<String>(poets2);

        String[] themes = { "LOVE","DEATH"};
        final JComboBox<String> themesBox = new JComboBox<String>(themes);

        topPanel.add(poetsBox1);
        topPanel.add(poetsBox2);
        topPanel.add(themesBox);
        btnPanel.add(generateBtn);
        mainContainer.add(topPanel, BorderLayout.PAGE_START);
        mainContainer.add(poemTextArea, BorderLayout.CENTER);
        mainContainer.add(btnPanel, BorderLayout.PAGE_END);
        
    }
    
}