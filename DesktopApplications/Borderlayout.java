package DesktopApplications;

import java.awt.*;
import javax.swing.*;

public class Borderlayout {
    
    public static void main(String [] args)
    {

        JFrame frame = new JFrame("BorderLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JLabel northLabel = new JLabel("Top - North", JLabel.CENTER);
        JLabel southLabel = new JLabel("Bottom - south",JLabel.CENTER);
        JLabel eastLabel = new JLabel("Right _ East",JLabel.CENTER);
        JLabel westLabel = new JLabel("Left - West", JLabel.CENTER);
        JLabel centerLabel = new JLabel("Center (everything else)",JLabel.CENTER);

        northLabel.setOpaque(true);
        northLabel.setBackground(Color.GREEN);
 
        southLabel.setOpaque(true);
 
        southLabel.setBackground(Color.GREEN);
 
 
        eastLabel.setOpaque(true);
 
        eastLabel.setBackground(Color.RED);

        westLabel.setOpaque(true);


        westLabel.setBackground(Color.RED);

        centerLabel.setOpaque(true);
        centerLabel.setBackground(Color.YELLOW);
 
 
        frame.add(northLabel, BorderLayout.NORTH);
 
        frame.add(southLabel, BorderLayout.SOUTH);
 
        frame.add(eastLabel, BorderLayout.EAST);
 
        frame.add(westLabel, BorderLayout.WEST);

        frame.add(centerLabel, BorderLayout.CENTER);
        frame.setVisible(true);

        /* 
         We’ve already seen the FlowLayout in action (at least in its horizontal orientation, one
        of its constructors can make a column of components). We were also using another
        layout manager without really knowing it. The content pane of a JFrame uses the Bor
        derLayout by default. Figure 10-23 shows the five areas controlled by BorderLayout,
        along with the names of their region. Notice that the NORTH and SOUTH regions are as
        wide as the application window, but only as tall as required to fit the label. Similarly,
        the EAST and WEST regions fill the vertical gap between the NORTH and SOUTH regions,
        but are only as wide as required, leaving the remaining space to be filled both hori
        zontally and vertically by the CENTER region.
        
    
        Notice the add() method in this case takes an extra argument. That argument is
        passed to the layout manager. Not all managers need this argument, as we saw with
        FlowLayout.
        Here is an example where nesting JPanel objects can be very handy—main app in a
        JPanel in the center, toolbar in a JPanel along the top, status bar in a JPanel along
        the bottom, project manager in a JPanel on the side, etc. BorderLayout defines those
        regions using compass directions. Figure 10-24 shows a very simple example of such
        container nesting. We use a text area for a large message in the center and then add
        some action buttons to a panel along the bottom. Again, without the events we’ll
        cover in the next section, none of these buttons do anything, but we want to show
        */





    }
}
