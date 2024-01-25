/*Method Overloading
Method overloading is the ability to define multiple methods with the same name in a
class; when the method is invoked, the compiler picks the correct one based on the
arguments passed to the method. This implies that overloaded methods must have
different numbers or types of arguments. */

/*Method overloading (also called ad hoc polymorphism) is a powerful and useful fea‐
ture. The idea is to create methods that act in the same way on different types of argu‐
ments. This creates the illusion that a single method can operate on many types of
arguments. The print() method in the standard PrintStream class is a good exam‐
ple of method overloading in action. As you’ve probably deduced by now, you can
print a string representation of just about anything using this expression:
 */

 System.out.print( argument )
/*The variable out is a reference to an object (a PrintStream) that defines nine differ‐
ent, “overloaded” versions of the print() method. The versions take arguments of
the following types: Object, String, char[], char, int, long, float, double, and
boolean. */

class PrintStream {
    void print( Object arg ) { ... }
    void print( String arg ) { ... }
    void print( char [] arg ) { ... }
    ...
    }

    /*You can invoke the print() method with any of these types as an argument, and it’s
printed in an appropriate way. In a language without method overloading, this
requires something more cumbersome, such as a uniquely named method for print‐
ing each type of object. In that case, it’s your responsibility to figure out what method
to use for each data type.
 */