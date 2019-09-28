package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    JButton calcButton;
    Container container;
    JTextArea textField;
    JPanel panel;
    CardLayout cards;
    Border border;

    public Window(String title) {
        super(title);

        cards = new CardLayout();
        panel = new JPanel(cards);
        container = getContentPane();

        calcButton = new JButton("=");
        calcButton.addActionListener(this::buttonClicked);
        panel.add(calcButton);

        border = BorderFactory.createLineBorder(Color.GRAY, 1);
        textField = new JTextArea("0", 1,1);
        textField.setEditable(true);
        textField.setBorder(border);
        panel.add(textField);

        container.add(panel);

        pack();
        setVisible(true);
    }

    public void buttonClicked(ActionEvent e) { System.out.println("click"); }

}