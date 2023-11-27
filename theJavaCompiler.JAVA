//The Java Compiler

/*In this section, we’ll say a few words about javac, the Java compiler in the JDK. The
javac compiler is written entirely in Java, so it’s available for any platform that sup‐
ports the Java runtime system. javac turns Java source code into a compiled class that
contains Java bytecode. By convention, source files are named with a .java extension;
the resulting class files have a .class extension. Each source code file is considered a
single compilation unit. As you’ll see in Chapter 5, classes in a given compilation unit
share certain features, such as package and import statements.
javac allows one public class per file and insists that the file has the same name as the
class. If the filename and class name don’t match, javac issues a compilation error. A
single file can contain multiple classes, as long as only one of the classes is public and
is named for the file. Avoid packing too many classes into a single source file. Packing
classes together in a .java file only superficially associates them. In Chapter 5, we’ll
talk about inner classes—classes that contain other classes and interfaces.
As an example, place the following source code in the file BigBird.java: */

package animals.birds;
 public class BigBird extends Bird {
 
 }

 /*Next, compile it with:
 % javac BigBird.java
Unlike the Java interpreter, which takes just a class name as its argument, javac needs
a filename (with the .java extension) to process. The previous command produces the
class file BigBird.class in the same directory as the source file. While it’s nice to see the
class file in the same directory as the source for this example, for most real applica‐
tions, you need to store the class file in an appropriate place in the classpath.
You can use the -d option with javac to specify an alternative directory for storing the
class files javac generates. The specified directory is used as the root of the class hier‐
archy, so .class files are placed in this directory or in a subdirectory below it, depend‐
ing on whether the class is contained in a package. (The compiler creates
intermediate subdirectories automatically, if necessary.) For example, we can use the
following command to create the BigBird.class file at /home/vicky/Java/classes/
animals/birds/BigBird.class:
 % javac -d /home/vicky/Java/classes BigBird.java
You can specify multiple .java files in a single javac command; the compiler creates a
class file for each source file. But you don’t need to list the other classes your class
references as long as they are in the classpath in either source or compiled form. Dur‐
ing compilation, Java resolves all other class references using the classpath.
The Java compiler is more intelligent than your average compiler, replacing some of
the functionality of a make utility. For example, javac compares the modification
times of the source and class files for all classes and recompiles them as necessary. A
compiled Java class remembers the source file from which it was compiled, and as
long as the source file is available, javac can recompile it if necessary. If, in the previ‐
ous example, class BigBird references another class, animals.furry.Grover, javac
looks for the source file Grover.java in an animals.furry package and recompiles it,
if necessary, to bring the Grover.class class file up-to-date.
By default, however, javac checks only source files that are referenced directly from
other source files. This means that if you have an out-of-date class file that is refer‐
enced only by an up-to-date class file, it may not be noticed and recompiled. For that
and many other reasons, most projects use a real build utility such as Gradle to man‐
age builds, packaging, and more.
Finally, it’s important to note that javac can compile an application even if only the
compiled (binary) versions of some of the classes are available. You don’t need source
code for all your objects. Java class files contain all the data type and method signa‐
ture information that source files contain, so compiling against binary class files is as
type safe (and exception safe) as compiling with Java source code.
 */