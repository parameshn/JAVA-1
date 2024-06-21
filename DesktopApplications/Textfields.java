package DesktopApplications;

import javax.swing.*;

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
        /*that the size of a text field is dictated by the number of columns
        we specified in its constructor. That’s not the only way to initialize a text field, but it is
        useful when there are no other layout mechanisms dictating the width of the field.
        (Here the FlowLayout failed us a bit—the “Email:” label did not stay on the same line
        as the email text field. But again, more on layouts soon.) Go ahead and type some
        thing! You can enter and delete text; cut, copy, and paste as you’d expect; and high
        light stuff inside the field with your mouse. 
        */

        //Text areas

        JLabel bodyLabel = new JLabel("Body:");
        JTextArea bodyArea = new JTextArea(10, 30);

        frame.add(bodyLabel);
        frame.add(bodyArea);
        bodyArea.setLineWrap(true);
        String text = bodyArea.getText();
        System.out.println(text);


        /*lineWrap false Whether lines longer than the table should wrap at all
        wrapStyleWord false If lines do wrap, whether the line breaks should be on word or character boundarie
        */

        /* So let’s start fresh and turn on the word wrap. We can use setLineWrap(true) to
        make sure the text wraps. But that’s probably not enough. Use setWrapStyle
        Word(true) in addition to make sure the text area doesn’t just break words in the
        middle. 
        */

        JScrollPane Scroll = new JScrollPane(bodyArea);
        Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
        frame.add(Scroll);

        /*that we no longer grow beyond the bounds of the frame.
        You can also see the standard scroll bars along the side and bottom. If you just need
        simple scrolling, you’re done! But like most other components in Swing, JScrollPane
        has many fine details you can adjust as needed. We won’t cover most of those here,
        but we do want to show you how to tackle a common setup for text areas: line wrap
        ping (breaking on words) with vertical scrolling—meaning no horizontal scrolling.
        */

        //Jslider
        /*
         * A component that lets the user graphically select a value by sliding a knob
         * within a bounded interval. The knob is always positioned at the points that
         * match integer values within the specified interval.
         */
        JSlider slide = new JSlider(10,1000,500);
        slide.setMajorTickSpacing(100000);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        //JLabel Lal = new JLabel("java time");
        //  slide.setLabelTable(100);
       // int k = slide.getValue();
       // System.out.println(k);
        
        frame.add(slide);
      


        /*JList
        If you have a range of values but those values are not simple, contiguous integers, the
        “list” UI element is a great choice. JList is the Swing implementation of this input
        type. You can set it to allow single or multiple selections, and if you dig deeper into
        
        Swing’s features, you can produce custom views that display the items in your list
        with extra information or details. (For example, you can make lists of icons, or icons
        and text, or multiline text, etc., etc.)
        Unlike the other components we’ve seen so far, JList requires a little more informa
        tion to get started. To make a useful list component, you need to use one of the con
        structors that takes the data you intend to show. The simplest such constructor
        accepts an Object array. While you can pass an array of strange objects, the default
        behavior of JList will be to show the output of your objects’ toString() method in
        the list. Using an array of String objects is very common and produces the expected
        results
        
        */
        String[] cities = new String [] {"Atlanta","Boston","citadel","nevada"};
        JList cityList = new JList<String>(cities);
        
        cityList.setSelectedIndex(100);
        frame.add(cityList);

        /*doesn’t stop your code from compiling or running, but you will receive the same
        unchecked warning message at compile time.
        Similar to getting the current value of a slider, you can retrieve the selected item or
        items in a list using one of four methods:
        • getSelectedIndex() for single-select lists, returns an int
        • getSelectedIndices() for multiselect lists, returns an array of int
        • getSelectedValue() for single-select lists, returns an object
        • getSelectedValues() for multiselect lists, returns an array of objects
        Obviously the main difference is whether the index of the selected item(s) or the
        actual value(s) is more useful to you. Playing with our city list in jshell, we can pull
        */

    }
    
}
