//Events

/*The last two methods of HelloComponent2, mouseDragged() and mouseMoved(), let
us get information from the mouse. Each time the user performs an action, such as
pressing a key on the keyboard, moving the mouse, or perhaps banging their head
against a touch screen, Java generates an event. An event represents an action that has
occurred; it contains information about the action, such as its time and location.
Most events are associated with a particular GUI component in an application. A key‐
stroke, for instance, can correspond to a character being typed into a particular text
entry field. Clicking a mouse button can activate a particular button on the screen.
Even just moving the mouse within a certain area of the screen can trigger effects
such as highlighting or changing the cursor’s shape.

To work with these events, we’ve imported a new package, java.awt.event, which
provides specific Event objects that we use to get information from the user. (Notice
that importing java.awt.* doesn’t automatically import the event package. Imports
are not recursive. Packages don’t really contain other packages, even if the hierarchi‐
cal naming scheme would imply that they do.)

There are many different event classes, including MouseEvent, KeyEvent, and Action
Event. For the most part, the meaning of these events is fairly intuitive. A MouseEvent
occurs when the user does something with the mouse, a KeyEvent occurs when the
user presses a key, and so on. ActionEvent is a little special; we’ll see it at work in
Chapter 10. For now, we’ll focus on dealing with MouseEvents */

/*GUI components in Java generate events for specific kinds of user actions. For exam‐
ple, if you click the mouse inside a component, the component generates a mouse
event. Objects can ask to receive the events from one or more components by regis‐
tering a listener with the event source. For example, to declare that a listener wants to
receive a component’s mouse-motion events, you invoke that component’s addMouse
MotionListener() method, specifying the listener object as an argument. That’s what
our example is doing in its constructor. In this case, the component is calling its own
addMouseMotionListener() method, with the argument this, meaning “I want to
receive my own mouse-motion events.”
That’s how we register to receive events. But how do we actually get them? That’s
what the two mouse-related methods in our class are for. The mouseDragged()
method is called automatically on a listener to receive the events generated when the
user drags the mouse—that is, moves the mouse with any button clicked. The mouse
Moved() method is called whenever the user moves the mouse over the area without
clicking a button. In this case, we’ve placed these methods in our HelloComponent2
class and had it register itself as the listener. This is entirely appropriate for our new
text-dragging component. More generally, good design usually dictates that event lis‐
teners be implemented as adapter classes that provide better separation of GUI and
“business logic.” We’ll discuss that in detail in Chapter 10.
Our mouseMoved() method is boring: it doesn’t do anything. We ignore simple mouse
motions and reserve our attention for dragging. mouseDragged() has a bit more meat
to it. This method is called repeatedly by the windowing system to give us updates on
the position of the mouse. Here it is: */

public void mouseDragged(MouseEvent e){
    messageX = e.gtx();
    messageY = e.getY();
    repaint();
}

/*The first argument to mouseDragged() is a MouseEvent object, e, that contains all the
information we need to know about this event. We ask the MouseEvent to tell us the x
and y coordinates of the mouse’s current position by calling its getX() and getY()
methods. We save these in the messageX and messageY instance variables for use else‐
where.
The beauty of the event model is that you have to handle only the kinds of events you
want. If you don’t care about keyboard events, you just don’t register a listener for
them; the user can type all they want and you won’t be bothered. If there are no lis‐
teners for a particular kind of event, Java won’t even generate it. The result is that
event handling is quite efficient.2
While we’re discussing events, we should mention another small addition we slipped
into HelloJava2: */

frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

/*This line tells the frame to exit the application when its Close button is clicked. It’s
called the “default” close operation because this operation, like almost every other
GUI interaction, is governed by events. We could register a window listener to get
notification of when the user clicks on the Close button and take whatever action we
like, but this convenience method handles the common cases.
Finally, we’ve danced around a couple of questions here: how does the system know
that our class contains the necessary mouseDragged() and mouseMoved() methods
(where do these names come from)? And why do we have to supply a mouseMoved()
method that doesn’t do anything? The answer to these questions has to do with interfaces. We’ll discuss interfaces after clearing up some unfinished business with
repaint() */