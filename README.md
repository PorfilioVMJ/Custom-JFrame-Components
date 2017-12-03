# Custom JFrame Components
Adds custom JFrame components for creating applications
This adds new components for your applications

# Current New Components
  -EditorMenuBar (Currently still adding features)
  
  -MTextArea

# Example class
package net.vmjlabs.components;

import net.vmjlabs.components.components.EditorMenuBar;
import net.vmjlabs.components.components.MTextArea;

import javax.swing.*;

public class MyNotepad extends JFrame{

    EditorMenuBar menuBar;
    MTextArea textArea;
    JScrollPane pane;

    public ComponentTester(){
        this.setTitle("Test Notepad");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);

        textArea = new MTextArea();
        menuBar = new EditorMenuBar(this, textArea);
        pane = new JScrollPane(textArea);

        this.setJMenuBar(menuBar);
        this.add(pane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new ComponentTester();
    }
}
