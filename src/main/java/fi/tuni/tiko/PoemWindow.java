package fi.tuni.tiko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


class PoemWindow extends JFrame{
    JButton generateBtn;
    JLabel poemTextArea;
    JPanel pane;
    Border border;

    String firstLine;
    String secondLine;
    String thirdLine;
    String fourthLine;
    String fifthLine;

    public PoemWindow(){
    setTitle("Poem generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(100, 100);
    createGUI();
    setSize(500, 400);

    generateBtn.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            generateBtn.setText("GENERATE NEW POEM");
        }
    });

    setVisible(true);
    }

    public void createGUI(){
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(8));
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(8));
        border = BorderFactory.createLineBorder(Color.GRAY, 1);
        
        generateBtn = new JButton("GENERATE POEM");
        firstLine = "* * * * * *";
        secondLine = "* * * * * *";
        thirdLine = "* * * * * *";
        fourthLine = "* * * * * *";
        fifthLine = "* * * * * *";
        poemTextArea = new JLabel("<html>" + firstLine + "<br>" + secondLine +
         "<br>" + thirdLine + "<br>" + "<br>" + fourthLine + "<br>" + 
         fifthLine + "<br>" + "</html>", SwingConstants.CENTER);
        poemTextArea.setBorder(border);

        String[] poets1 = { "John Keats","Walt Whitman", "Emily Dickinson","William Shakespeare"};
        final JComboBox<String> poetsBox1 = new JComboBox<String>(poets1);

        String[] poets2 = {"John Keats","Walt Whitman", "Emily Dickinson","William Shakespeare"};
        final JComboBox<String> poetsBox2 = new JComboBox<String>(poets2);

        String[] themes = { "LOVE","DEATH               "};
        final JComboBox<String> themesBox = new JComboBox<String>(themes);

        topPanel.add(poetsBox1);
        topPanel.add(poetsBox2);
        topPanel.add(themesBox);
        btnPanel.add(generateBtn);
        mainContainer.add(topPanel, BorderLayout.PAGE_START);
        mainContainer.add(poemTextArea, BorderLayout.CENTER);
        mainContainer.add(btnPanel, BorderLayout.PAGE_END);
        
    }

    public void onGenerateBtnClick(){

    }

    public static void main (String [] args){
        PoemWindow win = new PoemWindow();
    }
    
}