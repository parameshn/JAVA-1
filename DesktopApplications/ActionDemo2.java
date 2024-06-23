package DesktopApplications;

import javax.swing.*;
import java.awt.FlowLayout;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.*;

public class ActionDemo2 {

    public static void main(String [] args)
    {
        JFrame frame = new JFrame("ActionListener demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 180);

        JLabel label = new JLabel("Results go here", JLabel.CENTER);
        ActionCommandHelper helper = new ActionCommandHelper(label);
        JButton simpleButton = new JButton("Button");
        simpleButton.addActionListener(helper);
        JTextField simpleField = new JTextField(10);
        simpleField.addActionListener(helper);
        frame.add(simpleButton);
        frame.add(simpleField);
        frame.add(label);
        frame.setVisible(true);

        /*Notice a very interesting thing about this code: we used one ActionListener object
        to handle the events for both the button and the text field. This is a great feature of
        the listener approach that Swing takes to handling events. Any component that gener
        ates a given type of event can report to any listener that receives that type. Sometimes
        the event handlers are unique and you’ll build a separate handler for each compo
        nent. But many applications offer multiple ways to accomplish the same task. You can
        often handle those different inputs with a single listener. And the less code you have,
        the less that can go wrong!
        */

    }
    
}
