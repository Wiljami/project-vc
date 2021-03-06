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
    SecretPoemGenerator poemGen;

    String firstLine;
    String secondLine;
    String thirdLine;
    String fourthLine;
    String fifthLine;

    JComboBox<String> poetsBox1;
    JComboBox<String> poetsBox2;
    JComboBox<String> themesBox;

    public PoemWindow(){
    poemGen = new SecretPoemGenerator();
    setTitle("Poem generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(100, 100);
    createGUI();
    setSize(500, 400);

    poemGen.readPoemFiles();

    generateBtn.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            onGenerateBtnClick();
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
        poetsBox1 = new JComboBox<String>(poets1);

        String[] poets2 = {"John Keats","Walt Whitman", "Emily Dickinson","William Shakespeare"};
        poetsBox2 = new JComboBox<String>(poets2);

        String[] themes = { "LOVE","DEATH               "};
        themesBox = new JComboBox<String>(themes);

        topPanel.add(poetsBox1);
        topPanel.add(poetsBox2);
        topPanel.add(themesBox);
        btnPanel.add(generateBtn);
        mainContainer.add(topPanel, BorderLayout.PAGE_START);
        mainContainer.add(poemTextArea, BorderLayout.CENTER);
        mainContainer.add(btnPanel, BorderLayout.PAGE_END);
        
    }

    public void onGenerateBtnClick(){
        String poet1_raw = poetsBox1.getSelectedItem().toString();
        String[] poet1Parts = poet1_raw.split(" ");
        String poet1 = poet1Parts[1];
        String theme = themesBox.getSelectedItem().toString().replaceAll(" ", "");
        String strObject1 = poemGen.userInputToPoet(poet1, theme);
        String poet2_raw = poetsBox2.getSelectedItem().toString();
        String[] poet2Parts = poet2_raw.split(" ");
        String poet2 = poet2Parts[1];
        String strObject2 = poemGen.userInputToPoet(poet2, theme);
        System.out.println(strObject1);
        System.out.println(strObject2);

        firstLine = poemGen.poetsAndThemesList.get(0).getRandomVerseLine();
        poemTextArea.setText("<html>" + firstLine + "<br>" + secondLine +
         "<br>" + thirdLine + "<br>" + "<br>" + fourthLine + "<br>" + 
         fifthLine + "<br>" + "</html>");
    }

    // public static void main (String [] args){
    //     PoemWindow win = new PoemWindow();
    // }
    
}