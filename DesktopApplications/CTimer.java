package DesktopApplications;

import javax.swing.*;
//import javax.swing.Timer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
public class CTimer extends JFrame {

    /*Timers
    The Swing library also includes a timer that is designed to work in the UI space. The
    javax.swing.Timer class is fairly straightforward. It waits a specified period of time
    and then fires off an action event. It can fire that action once or repeatedly. There are
    many reasons to use timers with graphical applications. Besides an animation loop,
    you might want to automatically cancel some action, like loading a network resource
    if it is taking too long. Or conversely, you might put up a little “please wait” spinner
    or message to let the user know the operation is ongoing. You might want to take
    down a modal dialog if the user doesn’t respond within a specified time span. In all
    these cases, simple one-time timers are great. Swing’s Timer can handle all of them. */
 
 private JLabel timerLabel;
    private int countdownValue = 10; // Starting value of the countdown in seconds

    public  CTimer() {
        super("Countdown Timer Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 100);

        timerLabel = new JLabel("Time remaining: " + countdownValue + " seconds", JLabel.CENTER);
        add(timerLabel);

        // Create a timer that fires every 1000 milliseconds (1 second)
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (countdownValue > 0) {
                    countdownValue--;
                    timerLabel.setText("Time remaining: " + countdownValue + " seconds");
                } else {
                    ((Timer)e.getSource()).stop(); // Stop the timer when the countdown reaches zero
                    timerLabel.setText("Time's up!");
                }
            }
        });

        // Start the timer
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CTimer frame = new CTimer();
                frame.setVisible(true);
            }
        });
    }
    

    
}
