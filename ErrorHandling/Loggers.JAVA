//The Logging API

/*The java.util.logging package provides a highly flexible and easy-to-use logging
framework for system information, error messages, and fine-grained tracing (debug‐
ging) output. With the logging package, you can apply filters to select log messages,
direct their output to one or more destinations (including files and network services),
and format the messages appropriately for their consumers. */

/*Most importantly, much of this basic logging configuration can be set up externally at
runtime through the use of a logging setup properties file or an external program. For
example, by setting the right properties at runtime, you can specify that log messages
are to be sent both to a designated file in XML format and also logged to the system
console in a digested, human-readable form. Furthermore, for each of those destina‐
tions, you can specify the level or priority of messages to be logged, discarding those
below a certain threshold of significance. By following the correct source conventions
in your code, you can even make it possible to adjust the logging levels for specific
parts of your application, allowing you to target individual packages and classes for
detailed logging without being overwhelmed by too much output. The Java Logging
API can even be controlled remotely via Java Management Extensions MBean APIs.
 */

 /*Overview


Any good logging API must have at least two guiding principles. First, performance
should not inhibit the developer from using log messages freely. As with Java lan‐
guage assertions, when log messages are turned off, they should not consume any sig‐
nificant amount of processing time. This means that there’s no performance penalty
for including logging statements as long as they’re turned off. Second, although some
users may want advanced features and configuration, a logging API must have some
simple mode of usage that is convenient enough for time-starved developers to use in
lieu of the old standby System.out.println(). Java’s Logging API provides a simple
model and many convenience methods that make it very tempting */
/////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*Loggers */
/*The heart of the logging framework is the logger, an instance of java.util.log
ging.Logger. In most cases, this is the only class your code will ever have to deal
with. A logger is constructed from the static Logger.getLogger() method, with a
logger name as its argument. Logger names place loggers into a hierarchy with a
global, root logger at the top and a tree and children below. This hierarchy allows the
configuration to be inherited by parts of the tree so that logging can be automatically
configured for different parts of your application. The convention is to use a separate
logger instance in each major class or package and to use the dot-separated package
and/or class name as the logger name. For example: */
package com.oreilly.learnjava;
 public class Book {
 static Logger log = Logger.getLogger("com.oreilly.learnjava.Book");

 /*The logger provides a wide range of methods to log messages; some take very detailed
information, and some convenience methods take only a string for ease of use. For
example: */

log.warning("Disk 90% full.");
 log.info("New user joined chat room.");

 }
 /*We cover methods of the logger class in detail a bit later. The names warning and
info are two examples of logging levels; there are seven levels ranging from SEVERE
at the top to FINEST at the bottom. Distinguishing log messages in this way allows us
to select the level of information that we want to see at runtime. Rather than simply
logging everything and sorting through it later (with negative performance impact),
we can tweak which messages are generated */

/*We should also mention that for convenience in very simple applications or experi‐
ments, a logger for the name “global” is provided in the static field Logger.global.
You can use it as an alternative to the old standby System.out.println() for those
cases where that is still a temptation: */

Logger.global.info("Doing foo...")