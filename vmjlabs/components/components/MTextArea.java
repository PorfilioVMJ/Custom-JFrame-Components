package net.vmjlabs.components.components;

import javax.swing.*;

public class MTextArea extends JTextPane{

    public MTextArea(){

    }

    public void append(String text){
        setText(getText()+text);
    }
    public void appendLine(String line){
        setText(getText()+line+"\n");
    }
}
