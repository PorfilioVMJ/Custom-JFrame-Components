package net.vmjlabs.examples;

import net.vmjlabs.components.ComponentTester;
import net.vmjlabs.components.components.EditorMenuBar;
import net.vmjlabs.components.components.MTextArea;

import javax.swing.*;

public class ExampleClass1 extends JFrame{

    EditorMenuBar menuBar;
    MTextArea textArea;
    JScrollPane pane;

    //Add Custom Menus
    JMenu customMenu;

    public ExampleClass1(){
        this.setTitle("Example Window");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);

        textArea = new MTextArea();
        menuBar = new EditorMenuBar(this, textArea);
        pane = new JScrollPane(textArea);

        //Initialize your custom menu
        customMenu = new JMenu();
        customMenu.setText("Window");

        menuBar.add(customMenu);

        this.setJMenuBar(menuBar);
        this.add(pane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new ExampleClass1();
    }
}
