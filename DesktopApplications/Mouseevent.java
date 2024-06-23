/* Events
 When thinking about the MVC architecture, we can see that the model and view ele
ments are straightforward. We’ve seen several Swing components already and
 touched on their view, as well as the model for more interesting components like
 JList. (Labels and buttons also have models, of course, they just aren’t very complex.)
 With that background in place, let’s look at the controller functionality. In Swing (and
 Java more generally), interaction between users and components is communicated via
 events. An event contains general information, such as when it occurred, as well as
 information specific to the event type, such as the point on your screen where you
 clicked your mouse. A listener (or handler) picks up the message and can respond in
 some useful way. 
 As you work through the examples below, you’ll likely notice that some of the events
 and listeners are part of the javax.swing.event package, while others live in
 java.awt.event. This reflects the fact that Swing succeeded AWT. The parts of AWT
 that are still relevant remain in use, but Swing added a number of new items to
 accommodate the expanding functionality provided by the library.*/


package DesktopApplications;


/* Mouse Events
 The easiest way to get started is just to generate and handle an event. Let’s return to
 our simple HelloJava application (updated to HelloMouse!) and add a listener for
 mouse events. When we click our mouse, we’ll use that click event to determine the
 position of our JLabel. (This will require removing the layout manager, by the way.
 We want to set the coordinates of our label manually.) Here is the code of our new,
 interactive application: */


import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouseevent extends JFrame implements MouseListener { //1
    JLabel label;

    public Mouseevent() {
        super("MouseEvent Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setLayout(null);
        setSize(300, 100);

        label = new JLabel("HEllo , Mouse!", JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        label.setLocation(100, 100);
        add(label);

        getContentPane().addMouseListener(this); //4
    }

    public void mouseClicked(MouseEvent e) {  //2
        label.setLocation(e.getX(), e.getY());
    }

    public void mousePressed(MouseEvent e) { //3
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        Mouseevent frame = new Mouseevent();
        frame.setVisible(true);
    }


    /*
    1
    As you click, your computer is generating low-level events that are handed to the
    JVM and end up in your code to be handled by a listener. In Java, listeners are
    interfaces, and you can make special classes just to implement the interface, or
    you can implement listeners as part of your main application class like we did
    here. Where you handle events really depends on what actions you need to take
    in response. You’ll see a number of examples of both approaches throughout the
    rest of this book.
    
    2
    We implemented the MouseListener interface in addition to extending JFrame.
    We had to provide a body for every method listed in MouseListener, but we do
    our real work in mouseClicked(). You can see we take the coordinates of the
    click from the event object, and use them to change the position of our label.
    The MouseEvent class contains a wealth of information about the event. When it
    occurred, which component it occurred on, which mouse button was involved,
    the (x,y) coordinate where the event occurred, etc. Try printing some of that
    information in some of the unimplemented methods, such as mouseDown().
    
    3
    You may have noticed that we added quite a few methods for other types of
    mouse events that we didn’t use. That’s common with lower-level events, such as
    mouse and keyboard events. The listener interfaces are designed to give you a
    central point to get many related events. You just respond to the particular events
    you care about and leave the other methods empty.
    
    4
    The other critical bit of new code is the call to addMouseListener() for our con
    tent pane. The syntax may look a little odd, but it’s a valid approach. The use of
    getContentPane() on the left says “this is where the events will be generated,”
    and the use of this as the argument says “this is where events will be delivered.”
    For our example, the events from the frame’s content pane will be delivered back
    to the same class, which is where we put all of the mouse-handling code.
    */
}
