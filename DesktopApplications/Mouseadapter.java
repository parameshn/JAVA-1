package DesktopApplications;

/* Mouse adapters
 If we want to try the helper class approach, we could add another, separate class to
 our file and implement MouseListener in that class. But if we’re going to create a sep
arate class, we can take advantage of a shortcut Swing provides for many listeners.
 The MouseAdapter class is a simple, empty implementation of the MouseListener
 interface with empty methods written for every type of event. When you extend this
 class, you are free to override only the methods you care about. That can make for a
 cleaner handler. */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* Mouse adapters
 If we want to try the helper class approach, we could add another, separate class to
 our file and implement MouseListener in that class. But if we’re going to create a sep
arate class, we can take advantage of a shortcut Swing provides for many listeners. */

public class Mouseadapter extends MouseAdapter {
/* The MouseAdapter class is a simple, empty implementation of the MouseListener
 interface with empty methods written for every type of event. When you extend this
 class, you are free to override only the methods you care about.
  */

    JLabel labelToMove;

    public Mouseadapter(JLabel label)
    {
        labelToMove = label;
    }

    public void mouseClicked(MouseEvent e)
    {
        labelToMove.setLocation(e.getX(),e.getY());
    }


    public static void main(String [] main)
    {
        JFrame frame = new JFrame("MouseEvent Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300, 300);

        JLabel label = new JLabel("Hello,Mouse!", JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        label.setSize(100, 20);
        label.setLocation(100, 100);
        frame.add(label);

        Mouseadapter mover = new Mouseadapter(label);
        frame.getContentPane().addMouseListener(mover);
        frame.setVisible(true);

    }
    
    
}
