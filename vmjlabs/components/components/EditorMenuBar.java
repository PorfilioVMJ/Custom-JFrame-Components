package net.vmjlabs.components.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public EditorMenuBar(JFrame frame){

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
                openFile.showDialog(frame, "Open");
            }
        });

        save = new JMenuItem();
        save.setText("Save");
        saveAs = new JMenuItem();
        saveAs.setText("Save As");
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

}
