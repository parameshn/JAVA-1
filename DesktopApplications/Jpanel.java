package DesktopApplications;

import java.awt.*;
import javax.swing.*;

public class Jpanel {

    /* tweak that object.
    JPanel
    The JPanel class is the go-to container in Swing. It is a component just like JButton
    or JLabel, so your panels can contain other panels. Such nesting often plays a big role
    in the layout of an application. For example, you could create a JPanel to house the
    formatting buttons of a text editor in a “toolbar” so that it is easy to move that toolbar
    around according to user preferences.
    JPanel gives you the ability to add and remove components from the screen. (More
    accurately, those add/remove methods are inherited from the Container class, but we
    access them through our JPanel objects.) You can also repaint() a panel if some
    thing has changed and you want to update your UI
    */

 
    public static void main(String [] args)
    {
        //Widget w = new Widget();
       // JFrame frame = new JFrame("Panel");

        // JLabel emailLabel = new JLabel("Email:");
        // JTextField emailField = new JTextField(15);
        // JButton submitButton = new JButton("submit");

        
        // frame.setLayout(new  FlowLayout());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400,200);
        
        // frame.add(emailLabel);
        // frame.add(emailField);
        // frame.add(submitButton);
        // frame.setVisible(true);
        // frame.remove(emailLabel);

        /* Here is an example where nesting JPanel objects can be very handy—main app in a
        JPanel in the center, toolbar in a JPanel along the top, status bar in a JPanel along
        the bottom, project manager in a JPanel on the side, etc. BorderLayout defines those
        regions using compass directions. Figure 10-24 shows a very simple example of such
        container nesting. We use a text area for a large message in the center and then add
        some action buttons to a panel along the bottom. Again, without the events we’ll
        cover in the next section, none of these buttons do anything, but we want to show
        you how to work with multiple containers. And you could continue nesting JPanel
        objects if you wanted; just make sure your hierarchy is readable. Sometimes a better
        top-level layout choice makes your app both more maintainable and more
        performant.
        
        */

        JFrame frame = new JFrame("Nested panel demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JTextArea messageArea = new JTextArea();
        frame.add(messageArea,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
     

        JButton sendButton = new JButton("send");
        JButton saveButton = new JButton("send");
        JButton resetButton = new JButton("reset");
        JButton cancelButton = new JButton("cancel");

        buttonPanel.add(sendButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(cancelButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);



       

    }
}
