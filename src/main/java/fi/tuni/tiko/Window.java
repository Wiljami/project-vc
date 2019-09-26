package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class Window extends JFrame {

    JButton calcButton;
    Container container;
    JTextArea inputField;
    JPanel panel;
    CardLayout cardLayout;

    public Window(String title) {
        super(title);
        setSize(600, 600);

        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
        container = getContentPane();

        setVisible(true);
    }

}