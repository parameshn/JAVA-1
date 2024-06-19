
package DesktopApplications;

import javax.swing.*;
import java.awt.*;

class LabelsAndButtons {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel Examples");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JLabel basic = new JLabel("Default Label");
        frame.add(basic);
        frame.setVisible(true);
    }

}

/* Briefly, the interesting parts are:

 Setting the layout manager for use by the frame.

 Setting the action taken when using the operating system’s “close” button (in this
 case, the red dot in the upper-left corner of the window). The action we selected
 here exits the application.
 
 Creating our simple label. */