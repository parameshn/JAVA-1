package DesktopApplications;

/* Menus
 While not technically required, most desktop applications have an application-wide
 menu of common tasks, such as saving changed files or setting preferences, and spe
cific features like spreadsheet apps that allow sorting the data in a column or selec
tion. The JMenu, JMenuBar, and JMenuItem classes help you add this functionality to
 your Swing apps. Menus go inside a menu bar, and menu items go inside menus.
 Swing has three prebuilt menu item classes: JMenuItem for basic menu entries, JCheck
 boxMenuItem for option items, and JRadioButtonMenuItem for grouped menu items
 such as you might see for the currently selected font or color theme. The JMenu class
 is itself a valid menu item so that you can build nested menus. JMenuItem behaves like
 a button (as do its menu item compatriots) and you can catch menu events using the
 same listeners. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo extends JFrame implements ActionListener {
    
    JLabel resultsLabel;

    public MenuDemo()
    {
        super("JMenu Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 180);

        resultsLabel = new JLabel("click a meu item!");
        add(resultsLabel);

        //menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("save");
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);
        JMenuItem quitItem = new JMenuItem("quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);


        JMenu editMenu = new JMenu("edit");
        JMenuItem cutItem = new JMenuItem("cut");
        cutItem.addActionListener(this);
        editMenu.add(cutItem);
        JMenuItem copyItem = new JMenuItem("copy");
        copyItem.addActionListener(this);
        editMenu.add(copyItem);
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        editMenu.add(pasteItem);

        //JMenuBar
        JMenuBar mainBar = new JMenuBar();
        mainBar.add(fileMenu);
        mainBar.add(editMenu);
        setJMenuBar(mainBar);

    }

    public void actionPerformed(ActionEvent event) {
        resultsLabel.setText("Menu selected: " + event.getActionCommand());
    }


    public static void main (String args[])
    {
        MenuDemo demo = new MenuDemo();
        demo.setVisible(true);
    }
}

