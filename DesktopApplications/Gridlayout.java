package DesktopApplications;

import javax.swing.*;
import java.awt.*;

public class Gridlayout {

    public static void main(String [] args) {

        /*
         * GridLayout
         * Many times you need (or want) your components or labels to occupy symmetric
         * spaces. Think of the Yes, No, and Cancel buttons along the bottom of a
         * confirmation
         * dialog. The GridLayout class is one of the early layout managers that
         * helps with such even spacing. Let’s try using GridLayout for those buttons in
         * our pre
         * vious example. All we have to do is change one line
         */

        JFrame frame = new JFrame("Nested Panel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 300);

        JPanel phonePad = new JPanel(new GridLayout(4, 3));

        phonePad.add(new JButton("1"));
        phonePad.add(new JButton("2"));
        phonePad.add(new JButton("3"));
        phonePad.add(new JButton("4"));
        phonePad.add(new JButton("5"));

        phonePad.add(new JButton("6"));
        phonePad.add(new JButton("7"));
        phonePad.add(new JButton("8"));

        phonePad.add(new JButton("9"));
        phonePad.add(new JButton("*"));
        phonePad.add(new JButton("0"));
        phonePad.add(new JButton("#"));

        frame.add(phonePad, BorderLayout.CENTER);
        //frame.add(phonePad, BorderLayout.SOUTH);
        frame.setVisible(true);

    }
}
