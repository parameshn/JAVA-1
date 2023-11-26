// Package and Imports

/*We mentioned earlier that the first line of our example tells Java where to find some
of the classes that we’ve been using: */

 import javax.swing.*;
 
/*Specifically, it tells the compiler that we are going to be using classes from the Swing
GUI toolkit (in this case, JFrame, JLabel, and JComponent). These classes are organ‐
ized into a Java package called javax.swing. A Java package is a group of classes that
are related by purpose or by application. Classes in the same package have special
access privileges with respect to one another and may be designed to work together
closely.
Packages are named in a hierarchical fashion with dot-separated components, such as
java.util and java.util.zip. Classes in a package must follow conventions about
where they are located in the classpath. They also take on the name of the package as
part of their “full name” or, to use the proper terminology, their fully qualified name.
For example, the fully qualified name of the JComponent class is javax.swing.JCompo
nent. We could have referred to it by that name directly, in lieu of using the import
statement: */

public class HelloComponent extends javax.swing.JComponent {...}

/*The statement import javax.swing.* enables us to refer to all the classes in the
javax.swing package by their simple names. So we don’t have to use fully qualified
names to refer to the JComponent, JLabel, and JFrame classes.
As we saw when we added our second example class, there may be one or more
import statements in a given Java source file. The imports effectively create a “search
path” that tells Java where to look for classes that we refer to by their simple, unquali‐
fied names. (It’s not really a path, but it avoids ambiguous names that can create
errors.) The imports we’ve seen use the dot star (.*) notation to indicate that the
entire package should be imported. But you can also specify just a single class. For
example, our current example uses only the Graphics class from the java.awt pack‐
age. So we could have used import java.awt.Graphics instead of using the wildcard
* to import all the Abstract Window Toolkit (AWT) package’s classes. However, we
are anticipating using several more classes from this package later.
The java. and javax. package hierarchies are special. Any package that begins with
java. is part of the core Java API and is available on any platform that supports Java.
The javax. package normally denotes a standard extension to the core platform,
which may or may not be installed. However, in recent years, many standard 
extensions have been added to the core Java API without renaming them. The
javax.swing package is an example; it is part of the core API in spite of its name.
Figure 2-14 illustrates some of the core Java packages, showing a representative class
or two from each 
java.lang contains fundamental classes needed by the Java language itself; this pack‐
age is imported automatically, and that is why we didn’t need an import statement to
use class names such as String or System in our examples. The java.awt package
contains classes of the older, graphical AWT; java.net contains the networking
classes; and so on.
As you gain more experience with Java, you will come to realize that having a com‐
mand of the packages available to you, what they do, when to use them, and how to
use them is a critical part of becoming a successful Java developer.
*/