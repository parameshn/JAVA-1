//The Classpath


/*
The concept of a path should be familiar to anyone who has worked on a DOS or
Unix platform. It’s an environment variable that provides an application with a list of
places to look for some resource. The most common example is a path for executable
programs. In a Unix shell, the PATH environment variable is a colon-separated list of
directories that are searched, in order, when the user types the name of a command.
The Java CLASSPATH environment variable, similarly, is a list of locations that are
searched for Java class files. Both the Java interpreter and the Java compiler use the
CLASSPATH when searching for packages and Java classes.


An element of the classpath can be a directory or a JAR file. Java also supports
archives in the conventional ZIP format, but JAR and ZIP are really the same format.
JARs are simple archives that include extra files (metadata) that describe each archi‐
ve’s contents. JAR files are created with the JDK’s jar utility; many tools for creating
ZIP archives are publicly available and can be used to inspect or create JAR files as
well. The archive format enables large groups of classes and their resources to be dis‐
tributed in a single file; the Java runtime automatically extracts individual class files
from the archive as needed.
 */