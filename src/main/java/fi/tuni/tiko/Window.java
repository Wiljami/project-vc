package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    JButton calcButton;
    Container container;
    JTextArea inputField;
    JPanel panel;
    CardLayout cards;

    public Window(String title) {
        super(title);
        setSize(600, 600);

        cards = new CardLayout();
        panel = new JPanel(cards);
        container = getContentPane();

        calcButton = new JButton("=");
        calcButton.addActionListener(this::buttonClicked);
        panel.add(calcButton);
        container.add(panel);

        setVisible(true);
    }

    public void buttonClicked(ActionEvent e) {}

}