package net.vmjlabs.components.components.menuBarObjects;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.event.*;

public class FindTextWindow extends JFrame{

    JTextField field1;
    JButton findButton;

    public FindTextWindow(JTextPane textPane){
        setTitle("Find");
        setSize(220, 70);
        setLocationRelativeTo(null);
        setResizable(false);
        Box box = Box.createHorizontalBox();

        field1 = new JTextField();
        findButton = new JButton();
        findButton.setText("Find");

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textPane.getText().contains(field1.getText())){
                    System.out.println("Found "+field1.getText());

                    String text = textPane.getText();
                    String[] words = text.split(" ");
                    for(int i=0;i<words.length;i++){
                        String word = words[i];
                        //Not working passed this point
                        if(word=="world"){
                            System.out.println("Found");

                        }
                    }
                }
            }
        });

        box.add(field1);
        box.add(findButton);
        add(box);
        setVisible(true);
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        };
        addWindowListener(exitListener);
    }

    public static void main(String[] args){
        JTextPane pane = new JTextPane();
        new FindTextWindow(pane);
    }
}
