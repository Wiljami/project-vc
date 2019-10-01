package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    JButton calcButton;
    JTextArea textField;
    JPanel pane;
    Border border;

    public Window(String title) {
        super(title);

        setLayout(new BorderLayout());
        addComponents();

        pack();
        setVisible(true);
    }

    private void addNumberPane() {
        pane = new JPanel();
        add(pane);
    }

    private void addComponents() {

        border = BorderFactory.createLineBorder(Color.GRAY, 1);
        textField = new JTextArea("0", 1,1);
        textField.setEditable(true);
        textField.setBorder(border);
        add(textField, BorderLayout.PAGE_START);
        
        for(int i=0; i<10; i++) {
            addButton(Integer.toString(i));
        }
        addButton("+");
        addButton("-");
        addButton("*");
        addButton("/");
        
        JButton resultButton = new JButton("=");
        add(resultButton, BorderLayout.PAGE_END);
    }

    private void addButton(String text) {
        JButton newButton = new JButton(text);
        newButton.addActionListener(this::buttonClicked);
        add(newButton);
    }

    public void buttonClicked(ActionEvent e) { System.out.println("click"); }

}