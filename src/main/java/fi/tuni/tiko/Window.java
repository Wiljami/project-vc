package fi.tuni.tiko;
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {

    JButton calcButton;
    Container container;
    JTextArea inputField;

    public Window(String title) {
        super(title);
        setSize(600, 600);
        setVisible(true);
    }

}