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

 /*In the previous example, print() has been overloaded to support two reference
types: Object and String. What if we try to call print() with some other reference
type? Say, a Date object? When there’s not an exact type match, the compiler searches
for an acceptable, assignable match. Since Date, like all classes, is a subclass of Object,
a Date object can be assigned to a variable of type Object. It’s therefore an acceptable
match, and the Object method is selected. */

/*What if there’s more than one possible match? For example, what if we want to print
the literal "Hi there"? That literal is assignable to either String (since it is a String)
or to Object. Here, the compiler makes a determination as to which match is “better”
and selects that method. In this case, it’s the String method. */

/*The intuitive explanation for this is that the String class is “closer” to the literal "Hi
there" in the inheritance hierarchy. It is a more specific match. A slightly more rigor‐
ous way of specifying it would be to say that a given method is more specific than
another method if the argument types of the first method are all assignable to the
argument types of the second method. In this case, the String method is more spe‐
cific because type String is assignable to type Object. The reverse is not true. */

/*If you’re paying close attention, you may have noticed we said that the compiler
resolves overloaded methods. Method overloading is not something that happens at
runtime; this is an important distinction. It means that the selected method is chosen
once, when the code is compiled. Once the overloaded method is selected, the choice
is fixed until the code is recompiled, even if the class containing the called method is
later revised and an even more specific overloaded method is added. This is in con‐
trast to overridden methods, which are located at runtime and can be found even if
they didn’t exist when the calling class was compiled. In practice, this distinction will
not usually be relevant to you, as you will likely recompile all of the necessary classes
at the same time. */