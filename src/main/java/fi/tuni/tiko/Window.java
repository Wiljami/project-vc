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

        pane = new JPanel();
        setLayout(new FlowLayout());
        addComponentsToPane();

        add(pane);
        pack();
        setVisible(true);
    }

    private void addComponentsToPane() {
        for(int i=0; i<10; i++) {
            addButton(Integer.toString(i));
        }
        addButton("+");
        addButton("-");
        addButton("*");
        addButton("/");
        addButton("=");

        border = BorderFactory.createLineBorder(Color.GRAY, 1);
        textField = new JTextArea("0", 1,1);
        textField.setEditable(true);
        textField.setBorder(border);
        pane.add(textField);
    }

    private void addButton(String text) {
        JButton newButton = new JButton(text);
        newButton.addActionListener(this::buttonClicked);
        pane.add(newButton);
    }

    public void buttonClicked(ActionEvent e) { System.out.println("click"); }

}