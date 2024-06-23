package DesktopApplications;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modallabel extends JFrame implements ActionListener{
    
    JLabel modalLabel;

    public Modallabel()
    {
        super("Modal Dialog Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 100);

        modalLabel = new JLabel("Press 'go' to show the popup!", JLabel.CENTER);
        add(modalLabel);

        JButton goButton = new JButton("go");
        goButton.addActionListener(this);
        add(goButton);
    }

    public void actionPerformed(ActionEvent ae)
    {
        // JOptionPane.showMessageDialog(this, "we.re going!", "Alert", JOptionPane.ERROR_MESSAGE);

        // int answer = JOptionPane.showConfirmDialog(null, "Are you sure?");// Confirmation Dialogs

        // if (answer == JOptionPane.YES_OPTION) {
        //     modalLabel.setText("They said yes!");
        // } else {
        //     modalLabel.setText("They said no or canceled. :(");
        // }

        // modalLabel.setText("Go pressed! Press again if you like.");

        String pin = JOptionPane.showInputDialog(null, "Please enter your PIN:");// type in an answer
        System.out.println(pin);

    }

    public static void main(String args[]) {
        Modallabel demo = new Modallabel();
        demo.setVisible(true);
    }
}


/*Hopefully, you recognize the code connecting our goButton to the this listener. It’s
 the same pattern we used with our very first ActionEvent. What is new is what we do
 with that event. We show our message dialog and then update our label to indicate
 that we successfully presented the dialog.
 The showMessageDialog() call takes four arguments. The this argument you see in
 the first position is the frame or window “owning” the pop up; the alert will try to
 center itself over its owner when shown. We specify our application itself as the
 owner. The second and third arguments are Strings for the dialog’s message and title,
 respectively. The final argument indicates the “type” of pop up, which mostly affects
 the icon you see. You can specify several types:
  */

  /*
   * ERROR_MESSAGE, red Stop icon
   * • INFORMATION_MESSAGE, Duke6 icon
   * • WARNING_MESSAGE, yellow triangle icon
   * • QUESTION_MESSAGE, Duke icon
   * • PLAIN_MESSAGE, no icon
   */

   /*There are other standard confirmation dialogs that can be shown with an extra pair
   of arguments: a String title to show on the dialog, and one of the following option
   types:
   • YES_NO_OPTION
   • YES_NO_CANCEL_OPTION
   • OK_CANCEL_OPTION
   */