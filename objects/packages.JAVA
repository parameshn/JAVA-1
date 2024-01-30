//Packages

/*For more complex
applications or libraries, you can have hundreds or even thousands of classes. You
need a way to organize things, and Java uses the notion of a package to accomplish
this task. */

/*Recall our second Hello World example in Chapter 2. The first few lines in the file
show us a lot of information on where the code will live */

import javax.swing.*;
 public class HelloJava {
 public static void main( String[] args ) {
 JFrame frame = new JFrame("Hello, Java!");
 JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
 }
}

/**We named the Java file according to the main class in that file. When we talk about
organizing things that go in files, you might naturally think of using folders to orga‐
nize those files in turn. That is essentially what Java does. Packages map onto folder
names much the way classes map onto filenames. If you were looking at the Java
source code for the Swing components we used in HelloJava, for example, you
would find a folder named javax, and under that, one named swing, and under that
you would find files like JFrame.java and JLabel.java.
 */

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Importing Classes

 //Importing individual classes

 /*In programming, you’ll often hear the maxim that “less is more.” Less code is more
maintainable. Less overhead means more throughput, etc., etc. (Although in pursuing
this way of coding, we do want to remind you to follow another famous quote from
no less a thinker than Einstein: “Everything should be made as simple as possible, but
no simpler.”) If you only need one or two classes from an external package, you can
import exactly those classes. This makes your code a little more readable—others
know exactly what classes you’ll be using.
 */

 /*Let’s re-examine that snippet of HelloJava above. We used a blanket import (more on
that in the next section), but we could tighten things up a bit by importing just the
classes we need, like so */

import javax.swing.JFrame;
 import javax.swing.JLabel;
 public class HelloJava {
 public static void main( String[] args ) {
 JFrame frame = new JFrame("Hello, Java!");
 JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
 }
}

/*This type of import setup is certainly more verbose when writing and reading, but
again, it means anyone reading or compiling your code knows exactly what other
dependencies exist. Many IDEs even have an “Optimize Imports” function that will
automatically find those dependencies and list them individually. Once you get in the
habit of listing and seeing these explicit imports, it is suprising how useful they
become when orienting yourself in a new (or perhaps long-forgotten) class. */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Importing entire packages
//You can import every class in the package using the syntax we glossed over earlier:
import javax.swing.*;
 public class HelloJava {
 public static void main( String[] args ) {
 JFrame frame = new JFrame("Hello, Java!");
 JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
 ...
 }
}

/*The * is a sort of wildcard for class imports. This version of the import statement tells
the compiler to have every class in the package ready to use. You’ll see this type of
import quite often for many of the common Java packages such as AWT, Swing, Utils,
and I/O. Again, it works for any package, but where it makes sense to be more spe‐
cific, you’ll gain some compile-time performance boosts and improve the readability
of your code.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 //Skipping imports

 /*You have another option for using external classes from other packages—you do not
have to import them at all. You can use their fully qualified names right in your code.
For example, our HelloJava class used the JFrame and JLabel classes from the
javax.swing package. We could import only the JLabel class if we wanted: */

import javax.swing.JLabel;
 public class HelloJava {
 public static void main( String[] args ) {
 javax.swing.JFrame frame = new javax.swing.JFrame("Hello, Java!");
 JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
 }
}
/*This might seem overly verbose for one line where we create our frame, but in larger
classes with an already lengthy list of imports, one-off usages can actually make your
code more readable. Such a fully qualified entry often points to the sole use of this
class within a file. If you were using it many times, you would import it. This type of
usage is never a requirement, but you will see it in the wild from time to time. */


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Custom Packages
/*As you continue learning Java and write more code and solve larger problems, you
will undoubtedly start to collect a larger and larger number of classes. You can use
packages yourself to help organize that collection. You use the package keyword to
declare a custom package. As noted at the top of this section, you then place the file
with your class inside a folder structure corresponding to the package name. As a
quick reminder, packages use all lowercase names (by convention) separated by peri‐
ods, such as in our graphical interface package, javax.swing */

/*Another convention applied widely to package names is something called “reverse
domain name” naming. Apart from the packages associated directly with Java, thirdparty libraries and other contributed code is usually organized using the domain
name of the company or individual’s email address. For example, the Mozilla Founda‐
tion has contributed a variety of Java libraries to the open source community. Most of
those libraries and utilities will be in packages starting with Mozilla’s domain,
mozilla.org, in reverse order: org.mozilla. This reverse naming has the handy (and
intended) side effect of keeping the folder structure at the top fairly small. It is not
uncommon to have good-sized projects that use libraries from only the com and org
top-level domains. */

/*If you are building your own packages separate from any company or contract work,
you can use your email address and reverse it, similar to company domain names.
Another popular option for code distributed online is to use the domain of your
hosting provider. GitHub, for example, hosts many, many Java projects for hobbyists
and enthusiasts. You might create a package named com.github.myawesomeproject
where “myawesomeproject” would obviously be replaced by your actual project
name. Be aware that repositories at sites like GitHub often allow names that are not
valid in package names. You might have a project named my-awesome-project, but
dashes are not allowed in any portion of a package name. Often such illegal charac‐
ters are simply omitted to create a valid name. */

/*You may have already taken a peek at more of the examples in the code archive for
this book. If so, you will have noticed we placed them in packages. While the organiz‐
ing of classes within packages is a woolly topic with no great best practices available,
we’ve taken an approach designed to make the examples easy to locate as you’re read‐
ing the book. For small examples in a chapter, you’ll see a package like ch05. For the
ongoing game example, we use game. We could rewrite our very first examples to fit
into this scheme quite easily: */

package ch02;
 import javax.swing.*;
 public class HelloJava {
 public static void main( String[] args ) {
 JFrame frame = new JFrame("Hello, Java!");
 JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
 }
}
/*We would need to create the folder structure ch02 and then place our HelloJava.java
file in that ch02 folder. We could then compile and run the example at the command
line by staying at the top of the folder hierarchy and using the fully qualified path of
the file and name of the class, like so */

//%javac ch02/HelloJava.java
 //%java ch02.HelloJava