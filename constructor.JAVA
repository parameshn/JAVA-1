//Constructors 

/*The HelloComponent2 class includes a special kind of a method called a constructor. A
constructor is called to set up a new instance of a class. When a new object is created,
Java allocates storage for it, sets instance variables to their default values, and calls the
constructor method for the class to do whatever application-level setup is required.
A constructor always has the same name as its class. For example, the constructor for
the HelloComponent2 class is called HelloComponent2(). Constructors don’t have a
return type, but you can think of them as creating an object of their class’s type. Like
other methods, constructors can take arguments. Their sole mission in life is to con‐
figure and initialize newly born class instances, possibly using information passed to
them in these parameters.
An object is created with the new operator specifying the constructor for the class and
any necessary arguments. The resulting object instance is returned as a value. In our
example, a new HelloComponent2 instance is created in the main() method by this
line:
 */

 frame.add( new HelloComponent2("Hello, Java!") );
/*This line actually does two things. We could write them as two separate lines that are
a little easier to understand: */

HelloComponent2 newObject = new HelloComponent2("Hello, Java!");
 frame.add( newObject );


 /*The first line is the important one, where a new HelloComponent2 object is created.
The HelloComponent2 constructor takes a String as an argument and, as we have
arranged it, uses it to set the message that is displayed in the window. With a little
magic from the Java compiler, quoted text in Java source code is turned into a String
object. (See Chapter 8 for a discussion of the String class.) The second line simply
adds our new component to the frame to make it visible, as we did in the previous
examples.
While we’re on the topic, if you’d like to make our message configurable, you can
change the constructor line to the following:
 */

 HelloComponent2 newobj = new HelloComponent2( args[0] );

 /*Now you can pass the text on the command line when you run the application using
the following command:
 C:\> java HelloJava2 "Hello, Java!"
args[0] refers to the first command-line parameter. Its meaning will become clearer
when we discuss arrays in Chapter 4. If you are using an IDE, you will need to config‐
ure it to accept your parameters before running it, as shown for IntelliJ IDEA in HelloComponent2’s constructor then does two things: it sets the text of theMessage
instance variable and calls addMouseMotionListener(). This method is part of the
event mechanism, which we discuss next. It tells the system, “Hey, I’m interested in
anything that happens involving the mouse.” */
public HelloComponent2(String message) {
    theMessage = message;
    addMouseMotionListener( this );
    }

    /*The special, read-only variable called this is used to explicitly refer to our object (the
“current” object context) in the call to addMouseMotionListener(). A method can
use this to refer to the instance of the object that holds it. The following two state‐
ments are therefore equivalent ways of assigning the value to theMessage instance
variable:
 */

 theMessage = message;

 //or 

 this.message = message ;

 /*We’ll normally use the shorter, implicit form to refer to instance variables, but we’ll
need this when we have to explicitly pass a reference to our object to a method in another class. We often do this so that methods in other classes can invoke our public
methods or use our public variables. */