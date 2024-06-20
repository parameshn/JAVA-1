
package DesktopApplications;

import javax.swing.*;
import java.awt.*;

class LabelsAndButtons {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel Examples");
       // frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JLabel basic = new JLabel("Default Label");
        frame.add(basic);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(0, 1));
        frame.setSize(300, 300);

        JLabel simple = new JLabel("time ");
        frame.add(simple);
        


        JLabel basic2 = new JLabel("Default label");
        basic2.setOpaque(true);
        basic2.setBackground(Color.YELLOW);
        JLabel another = new JLabel("Another label");
        another.setOpaque(true);
        another.setBackground(Color.GREEN);

        frame.add(basic2);
        frame.add(another);

        JLabel centered = new JLabel("centered Text", JLabel.CENTER);
        centered.setPreferredSize(new Dimension(150, 24));
        centered.setOpaque(true);
        centered.setBackground(Color.WHITE);

        frame.add(centered);


        JLabel times = new JLabel("Times roman");
        times.setOpaque(true);
        times.setBackground(Color.WHITE);
        times.setFont(new Font("timesRoman", Font.BOLD, 18));

        frame.add(times);

        JLabel styled = new JLabel("<html>some<b><i>styling</i></b>" + "is also allowed</html>");
        styled.setOpaque(true);
        styled.setBackground(Color.WHITE);
        frame.add(styled);

        JLabel icon = new JLabel("verified", new ImageIcon("\"C:\\Users\\Paramesh\\OneDrive\\Pictures\\Saved Pictures\\9ODroua12j4.jpg\""), JLabel.LEFT);
        icon.setOpaque(false);
        icon.setBackground(Color.WHITE);



        frame.add(icon);


        JButton b1 = new JButton("try me!");
        b1.setSize(300, 800);

        frame.add(b1);
        b1.setBackground(Color.GRAY);

        frame.setVisible(true);

        /* You can control the colors, alignment, font, and so on for buttons in much the same
        way as you do for labels. The difference, of course, is that you can click on a button
        and react to that click in your program, whereas labels are static for the most part. Try
        running this example and clicking on the button. It should change color and feel
        “pressed” even though it does not perform any other function in our program yet.
        Hopefully you’ve used enough applications or websites to be familiar with buttons
        and their behavior. 
        */




    }

}

/* Briefly, the interesting parts are:

 Setting the layout manager for use by the frame.

 Setting the action taken when using the operating system’s “close” button (in this
 case, the red dot in the upper-left corner of the window). The action we selected
 here exits the application.
 
 Creating our simple label. */