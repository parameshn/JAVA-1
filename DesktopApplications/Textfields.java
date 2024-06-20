package DesktopApplications;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;

public class Textfields {

    public static void main(String [] args)
    {
        JFrame  frame = new JFrame("Jframe text feilds");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);

        JLabel nameLabel = new JLabel("name:");
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(24);
        JTextField nameField = new JTextField(10);


        //position of text field depends on the frame.add 
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);

        frame.setVisible(true);

    }
    
}
