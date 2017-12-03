package net.vmjlabs.components;

import net.vmjlabs.components.components.EditorMenuBar;
import net.vmjlabs.components.components.MTextArea;

import javax.swing.*;

public class ComponentTester extends JFrame{

    EditorMenuBar menuBar;
    MTextArea textArea;
    JScrollPane pane;

    public ComponentTester(){
        this.setTitle("Tester");
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
