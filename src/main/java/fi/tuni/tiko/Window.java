package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    JButton calcButton;
    Container container;
    JTextArea textField;
    JPanel pane;
    Border border;

    public Window(String title) {
        super(title);

        pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        container = getContentPane();
        addComponentsToPane();

        container.add(pane);
        pack();
        setVisible(true);
    }

    private void addComponentsToPane() {
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