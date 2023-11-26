//Interfaces

/*Now it’s time to face the question we avoided earlier: how does the system know to
call mouseDragged() when a mouse event occurs? Is it simply a matter of knowing
that mouseDragged() is some magic name that our event-handling method must
have? Not quite; the answer to the question touches on the discussion of interfaces,
which are one of the most important features of the Java language.
The first sign of an interface comes on the line of code that introduces the HelloCom
ponent2 class: we say that the class implements the MouseMotionListener interface: */

class HelloComponent2 extends JComponent implements MouseMotionListener{

}

/*Essentially, an interface is a list of methods that the class must have; this particular
interface requires our class to have methods called mouseDragged() and mouse
Moved(). The interface doesn’t say what these methods have to do; indeed, mouse
Moved() doesn’t do anything. It does say that the methods must take a MouseEvent as
an argument and return no value (that’s what void means).
An interface is a contract between you, the code developer, and the compiler. By say‐
ing that your class implements the MouseMotionListener interface, you’re saying that
these methods will be available for other parts of the system to call. If you don’t pro‐
vide them, a compilation error will occur.
That’s not the only way interfaces impact this program. An interface also acts like a
class. For example, a method could return a MouseMotionListener or take a MouseMo
tionListener as an argument. When you refer to an object by an interface name in
this way, it means that you don’t care about the object’s actual class; the only require‐
ment is that the class implements that interface. addMouseMotionListener() is such a
method: its argument must be an object that implements the MouseMotionListener
interface. The argument we pass is this, the HelloComponent2 object itself. The fact
that it’s an instance of JComponent is irrelevant; it could be a Cookie, an Aardvark, or
any other class we dream up. What’s important is that it implements MouseMotionLis
tener and, thus, declares that it will have the two named methods. That’s why we
need a mouseMoved() method; even though the one we supplied doesn’t do anything,
the MouseMotionListener interface says we must have one. */

/*The Java distribution comes with many interfaces that define what classes have to do.
This idea of a contract between the compiler and a class is very important. There are
many situations like the one we just saw where you don’t care what class something is,
you just care that it has some capability, such as listening for mouse events. Interfaces
give us a way of acting on objects based on their capabilities without knowing or car‐
ing about their actual type. They are a tremendously important concept in how we
use Java as an object-oriented language. We’ll talk about them in detail in Chapter 5.
Chapter 5 also discusses how interfaces provide a sort of escape clause to the Java rule
that any new class can extend only a single class (“single inheritance”). A class in Java
can extend only one class, but can implement as many interfaces as it wants. Inter‐
faces can be used as data types, can extend other interfaces (but not classes), and can
be inherited by classes (if class A implements interface B, subclasses of A also imple‐
ment B). The crucial difference is that classes don’t actually inherit methods from
interfaces; the interfaces merely specify the methods the class must have.
 */