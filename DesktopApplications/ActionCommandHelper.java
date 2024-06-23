package DesktopApplications;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ActionCommandHelper implements ActionListener {
     JLabel resultLabel;
 public ActionCommandHelper(JLabel label) {
 resultLabel = label;
 }
 public void actionPerformed(ActionEvent ae) {
 resultLabel.setText(ae.getActionCommand());
 }
    
}
