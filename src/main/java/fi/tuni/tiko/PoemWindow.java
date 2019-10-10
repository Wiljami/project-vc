package fi.tuni.tiko;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

class PoemWindow extends JFrame{
    JButton generateBtn;

    public PoemWindow(){
    setSize(300, 300);
    setTitle("Poem generator");

    setLayout(new BorderLayout());

    generateBtn = new JButton("Generate poem");
    }
    
}