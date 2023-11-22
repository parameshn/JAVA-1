// The main() Method

/*
 * As we saw when we ran our example, running a Java application means picking a
 * par‐
 * ticular class and passing its name as an argument to the Java virtual
 * machine. When
 * we did this, the java command looked in our HelloJava class to see if it
 * contained
 * the special method named main() of just the right form. It did, and so it was
 * exe‐
 * cuted. If it had not been there, we would have received an error message. The
 * main()
 * method is the entry point for applications. Every standalone Java application
 * includesat least one class with a main() method that performs the necessary
 * actions to start
 * the rest of the program.at least one class with a main() method that performs
 * the necessary actions to start
 * the rest of the program.
 */

/*
 * Our main() method sets up a window (a JFrame) to hold the visual output of
 * the
 * HelloJava class. Right now, it’s doing all the work in the application. But
 * in an object oriented application, we normally delegate responsibilities to
 * many different classes.
 * In the next incarnation of our example, we’re going to perform just such a
 * split—cre‐
 * ating a second class—and we’ll see that as the example subsequently evolves,
 * the
 * main() method remains more or less the same, simply holding the startup
 * procedure.Our main() method sets up a window (a JFrame) to hold the visual
 * output of the
 * HelloJava class. Right now, it’s doing all the work in the application. But
 * in an object oriented application, we normally delegate responsibilities to
 * many different classes.
 * In the next incarnation of our example, we’re going to perform just such a
 * split—cre‐
 * ating a second class—and we’ll see that as the example subsequently evolves,
 * the
 * main() method remains more or less the same, simply holding the startup
 * procedure.
 */

/*Let’s quickly walk through our main() method, just so we know what it does. First,
main() creates a JFrame, the window that will hold our example:
*/

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainMethod {
    public static void main(String[] args) {
        JFrame frame = new JFrame("hello! java");

        /*
         * The word new in this line of code is very important. JFrame is the name of a
         * class that
         * represents a window on the screen, but the class itself is just a template,
         * like a build‐
         * ing plan. The new keyword tells Java to allocate memory and actually create a
         * particu‐
         * lar JFrame object. In this case, the argument inside the parentheses tells
         * the JFrame
         * what to display in its title bar. We could have left out the “Hello, Java”
         * text and used
         * empty parentheses to create a JFrame with no title, but only because the
         * JFrame
         * specifically allows us to do that.
         */
        // When frame windows are first created, they are very small. Before we show the
        // JFrame, we set its size to something reasonable:

        frame.setSize(300, 300);
        /*
         * This is an example of invoking a method on a particular object. In this case,
         * the set
         * Size() method is defined by the JFrame class, and it affects the particular
         * JFrame
         * object we’ve placed in the variable frame. Like the frame, we also create an
         * instance of
         * JLabel to hold our text inside the window:
         */

        JLabel label = new JLabel("Hello, Java!", JLabel.CENTER);
        /*
         * JLabel is much like a physical label. It holds some text at a particular
         * position—in
         * this case, on our frame. This is a very object-oriented concept: using an
         * object to hold
         * some text, instead of simply invoking a method to “draw” the text and moving
         * on.
         * The rationale for this will become clearer later.
         */

        // Next, we have to place the label into the frame we created
        frame.add(label);
        /*
         * Here, we’re calling a method named add()to place our label inside the JFrame.
         * The
         * JFrame is a kind of container that can hold things. We’ll talk more about
         * that later.
         * main()’s final task is to show the frame window and its contents, which
         * otherwise
         * would be invisible. An invisible window makes for a pretty boring
         * application.
         */
        frame.setVisible(true);
        /*
         * That’s the whole main() method. As we progress through the examples in this
         * chap‐
         * ter, it will remain mostly unchanged as the HelloJava class evolves around
         * it.
         */
    }
}
