package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    JButton calcButton;
    JTextArea textField;
    JPanel pane;
    JPanel side;
    Border border;

    public Window(String title) {
        super(title);
        setSize(200,400);

        setLayout(new BorderLayout());
        addComponents();

        setVisible(true);
    }

    private void addNumberPane() {
        pane = new JPanel();
        for(int i=0; i<10; i++) {
            addButtonToPane(Integer.toString(i));
        }
        add(pane, BorderLayout.CENTER);
    }

    private void addOperators() {
        side = new JPanel();
        addOperationButton("+");
        addOperationButton("-");
        addOperationButton("*");
        addOperationButton("/");
        side.setPreferredSize(new Dimension(50,200));
        add(side, BorderLayout.LINE_END);
    }

    private void addComponents() {

        border = BorderFactory.createLineBorder(Color.GRAY, 1);
        textField = new JTextArea("0", 5,10);
        textField.setEditable(true);
        textField.setBorder(border);
        add(textField, BorderLayout.PAGE_START);

        addOperators();
        addNumberPane();
        
        JButton resultButton = new JButton("=");
        add(resultButton, BorderLayout.PAGE_END);
    }

    private void addButtonToPane(String text) {
        JButton newButton = new JButton(text);
        newButton.addActionListener(this::buttonClicked);
        pane.add(newButton);
    }

    private void addOperationButton(String text) {
        JButton newButton = new JButton(text);
        newButton.addActionListener(this::buttonClicked);
        side.add(newButton);
    }

    public void buttonClicked(ActionEvent e) { System.out.println("click"); }

}