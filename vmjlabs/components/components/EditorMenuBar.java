package net.vmjlabs.components.components;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EditorMenuBar extends JMenuBar{

    JMenu file;
    JMenu edit;
    JMenu view;
    JMenu help;
    //File Menu
    JMenuItem open;
    JMenuItem save;
    JMenuItem saveAs;
    //Edit Menu
    JMenuItem undo;
    JMenuItem cut;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem delete;
    JMenuItem find;
    JMenuItem selectAll;
    //view
    JMenuItem statusBar;

    JFileChooser openFile;
    JFileChooser saveNewFile;

    private String filePath = "";
    private int openChooseValue;

    String currentSaveDirectory = "C:/";

    public EditorMenuBar(JFrame frame, MTextArea textPane){

        file = new JMenu();
        file.setText("File");
        edit = new JMenu();
        edit.setText("Edit");
        view = new JMenu();
        view.setText("View");
        help = new JMenu();
        help.setText("Help");
        //File Menu
        open = new JMenuItem();
        open.setText("Open");

        openFile = new JFileChooser();
        openFile.setName("Open File");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = openFile.showDialog(frame, "Open");
                openChooseValue = returnValue;
                if(returnValue == JFileChooser.APPROVE_OPTION) {
                    textPane.setText(null);
                    System.out.println(openFile.getSelectedFile().getPath());
                    filePath = openFile.getSelectedFile().getPath();
                    try {
                        System.out.println(openFile.getSelectedFile().getPath());
                        File file = new File(openFile.getSelectedFile().getPath());
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        StringBuffer stringBuffer = new StringBuffer();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuffer.append(line);
                            stringBuffer.append("\n");
                            textPane.appendLine(line);
                        }
                        fileReader.close();
                        System.out.println("Contents of file:");
                        System.out.println(stringBuffer.toString());
                        save.setEnabled(true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    currentSaveDirectory = openFile.getSelectedFile().getPath();
                }else {
                    System.out.println("Canceled");
                }
                currentSaveDirectory = openFile.getSelectedFile().getPath();
                filePath = openFile.getSelectedFile().getPath();
            }
        });

        save = new JMenuItem();
        save.setText("Save");
        save.setEnabled(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(filePath);
                FileWriter fw;
                try {
                    fw = new FileWriter(filePath, false);
                    textPane.write(fw);
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        saveAs = new JMenuItem();
        saveAs.setText("Save As");
        saveNewFile = new JFileChooser();
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNewFile.setName("Save as");
                int returnValue = saveNewFile.showDialog(frame, "Save");
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    System.out.println(saveNewFile.getSelectedFile().getPath());
                    String path = saveNewFile.getSelectedFile().getPath();
                    FileWriter fw;
                    try {
                        fw = new FileWriter(saveNewFile.getSelectedFile().getAbsoluteFile(), true);
                        textPane.write(fw);
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                    filePath = path;
                    currentSaveDirectory = path;
                }else {
                    System.out.println("Canceled Save Operation");
                }
                save.setEnabled(true);
            }
        });
        //Edit Menu
        undo = new JMenuItem();
        undo.setText("Undo");
        cut = new JMenuItem();
        cut.setText("Cut");
        copy = new JMenuItem();
        copy.setText("Copy");
        paste = new JMenuItem();
        paste.setText("Paste");
        delete = new JMenuItem();
        delete.setText("Delete");
        find = new JMenuItem();
        find.setText("Find");
        selectAll = new JMenuItem();
        selectAll.setText("Select All");
        //view
        statusBar = new JMenuItem();
        statusBar.setText("Status Bar");

        file.add(open);
        file.add(save);
        file.add(saveAs);
        edit.add(undo);
        edit.addSeparator();
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        edit.add(find);
        edit.addSeparator();
        edit.add(selectAll);
        view.add(statusBar);
        add(file);
        add(edit);
        add(view);
        add(help);
    }

    public String getFilePath(){
        return filePath;
    }
    public int getOpenChooseValue(){
        return openChooseValue;
    }

}
