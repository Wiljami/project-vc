package fi.tuni.tiko;

import javax.swing.JFrame;

public class SnakeUI extends JFrame {

    SecretSnake snake;

    public SnakeUI() {
        snake = new SecretSnake();
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String []args) {
        SnakeUI ui = new SnakeUI();
    }
}

