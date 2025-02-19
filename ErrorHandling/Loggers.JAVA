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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//Handlers
/*
Loggers represent the client interface to the logging system, but the actual work of
publishing messages to destinations (such as files or the console) is done by handler
objects. Each logger may have one or more Handler objects associated with it, which
includes several predefined handlers supplied with the Logging API: ConsoleHan
dler, FileHandler, StreamHandler, and SocketHandler. Each handler knows how to
deliver messages to its respective destination. ConsoleHandler is used by the default
configuration to print messages on the command line or system console. FileHan
dler can direct output to files using a supplied naming convention and automatically
rotate the files as they become full. The others send messages to streams and sockets,
respectively. There is one additional handler, MemoryHandler, that can hold a number
of log messages in memory. MemoryHandler has a circular buffer, which maintains a
certain number of messages until it is triggered to publish them to another designated
handler. */
/*As we said, loggers can be set to use one or more handlers. Loggers also send mes‐
sages up the tree to each of their parent logger’s handlers. In the simplest configura‐
tion, this means that all messages end up distributed by the root logger’s handlers. */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Filters

/*
Before a logger hands off a message to its handlers or its parent’s handlers, it first
checks whether the logging level is sufficient to proceed. If the message doesn’t meet
the required level, it is discarded at the source. In addition to level, you can imple‐
ment arbitrary filtering of messages by creating Filter classes that examine the log
message before it is processed. A Filter class can be applied to a logger externally at
runtime in the same way that the logging level, handlers, and formatters, which are
discussed next, can be. A Filter may also be attached to an individual Handler to
filter records at the output stage (as opposed to the source). */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*Formatters
Internally, messages are carried in a neutral format, including all the source informa‐
tion provided. It is not until they are processed by a handler that they are formatted
for output by an instance of a Formatter object. The logging package comes with two
basic formatters: SimpleFormatter and XMLFormatter. The SimpleFormatter is the
default used for console output. It produces short, human-readable summaries of log
messages. XMLFormatter encodes all the log message details into an XML record for‐
mat. */

/*Logging Levels


Level      Meaning

SEVERE    Application failure
WARNING   Notification of potential problem
INFO      Messages of general interest to end users
CONFIG    Detailed system configuration information for administrators
FINE,     Successively more detailed application tracing information for developers
FINER,
FINEST   
 */

 /*These levels fall into three camps: end user, administrator, and developer. Applica‐
tions often default to logging only messages of the INFO level and above (INFO,
WARNING, and SEVERE). 

These levels are generally seen by end users, and messages log‐
ged to them should be suitable for general consumption. In other words, they should
be written clearly so they make sense to an average user of the application.

 Often these kinds of messages are presented to the end user on a system console or in a
pop-up message dialog */

/*The CONFIG level should be used for relatively static but detailed system information
that could assist an administrator or installer. This might include information about
the installed software modules, host system characteristics, and configuration param‐
eters. These details are important, but probably not as meaningful to an end user.
 */

 /*The FINE, FINER, and FINEST levels are for developers or others with knowledge of
the internals of the application. These should be used for tracing the application at
successive levels of detail. */


//A Simple Example

import java.util.logging.*;
 public class LogTest {
 public static void main(String argv[])
 {
 Logger logger = Logger.getLogger("com.oreilly.LogTest");
 logger.severe("Power lost - running on backup!");
 logger.warning("Database connection lost, retrying...");
 logger.info("Startup complete.");
 logger.config("Server configuration: standalone, JVM version 1.5");
 logger.fine("Loading graphing package.");
 logger.finer("Doing pie chart");
 logger.finest("Starting bubble sort: value ="+42);
 }
 }


 /*There’s not much to this example. We ask for a logger instance for our class using the
static Logger.getLogger() method, specifying a class name. The convention is to use
the fully qualified class name, so we’ll pretend that our class is in a com.oreilly
package. */


//output 
/*Jan 6, 2019 3:24:36 PM LogTest main
 SEVERE: Power lost - running on backup!
 Jan 6, 2019 3:24:37 PM LogTest main
 WARNING: Database connection lost, retrying...
 Jan 6, 2019 3:24:37 PM LogTest main
 INFO: Startup complete. */


 /*Mar 15, 2024 12:15:14 AM abc main      
SEVERE: Power lost - running on backup!
Mar 15, 2024 12:15:15 AM abc main
WARNING: Database connection lost, retrying...
Mar 15, 2024 12:15:15 AM abc main
INFO: Startup complete. */

/*We see the INFO, WARNING, and SEVERE messages, each identified with a date and time‐
stamp and the name of the class and method (LogTest main) from which they came.
Notice that the lower-level messages did not appear. This is because the default log‐
ging level is normally set to INFO, meaning that only messages of severity INFO and
above are logged. Also note that the output went to the system console and not to a
logfile somewhere; that’s also the default. */


//Logging Setup Properties

/*As we said in the introduction, probably the most important feature of the Logging
API is the ability to configure so much of it at runtime through the use of external
properties or applications. The default logging configuration is stored in the file
jre/lib/logging.properties in the directory where Java is installed. It’s a standard Java
properties file (of the kind we described earlier in this chapter).
The format of this file is simple. You can make changes to it, but you don’t have to.
Instead, you can specify your own logging setup properties file on a case-by-case
basis using a system property at runtime, as follows: */
% java -Djava.util.logging.config.file=myfile.properties
/*
In this command line, myfile is your properties file that contains the directive, which
we’ll describe next. If you want to make this file designation more permanent, you
can do so by setting the filename in the corresponding entry using the Java Preferen‐
ces API. You can go even further and instead of specifying a setup file, supply a class
that is responsible for setting up all logging configuration, but we won’t get into that
here.
A very simple logging properties file might look like this: */

# Set the default logging level
 .level = FINEST
 # Direct output to the console
 handlers = java.util.logging.ConsoleHandler

 /*Here, we have set the default logging level for the entire application using the .level
(that’s dot-level) property. We have also used the handlers property to specify that an
instance of the ConsoleHandler should be used (just like the default setup) to show
messages on the console */

# Set the default logging level
 .level = INFO
 # Ouput to file and console
 handlers = java.util.logging.FileHandler, java.util.logging.ConsoleHandler
 # Configure the file output
 java.util.logging.FileHandler.level = FINEST
 java.util.logging.FileHandler.pattern = %h/Test.log
 java.util.logging.FileHandler.limit = 25000
 java.util.logging.FileHandler.count = 4
 java.util.logging.FileHandler.formatter = java.util.logging.XMLFormatter
 # Configure the console output
 java.util.logging.ConsoleHandler.level = WARNING
 # Levels for specific classes
 com.oreilly.LogTest.level = FINEST

 /*In this example, we have configured two log handlers: a ConsoleHandler with the
logging level set to WARNING and also an instance of FileHandler that sends the out‐
put to an XML file. The file handler is configured to log messages at the FINEST level
(all messages) and to rotate logfiles every 25,000 lines, keeping a maximum of 4 files.
The filename is controlled by the pattern property. Forward slashes in the filename
are automatically localized to backslash (\) if necessary. The special symbol %h refers
to the user home. You can use %t to refer to the system temporary directory. If file‐
names conflict, a number is appended automatically after a dot (starting at zero).
Alternatively, you can use %u to indicate where a unique number should be inserted
into the name. Similarly, when files rotate, a number is appended after a dot at the
end. You can take control of where the rotation number is placed with the %g
identifier.
In our example, we specified the XMLFormatter class. We could also have used the
SimpleFormatter class to send the same kind of simple output to the console. The
ConsoleHandler also allows us to specify any formatter we wish, using the formatter
property.
Finally, we promised earlier that you could control logging levels for parts of your
applications. To do this, set properties on your application loggers using their hier‐
archical names: */
# Levels for specific logger (class) names
 com.oreilly.LogTest.level = FINEST

 /# Levels for specific logger (class) names
 com.oreilly.LogTest.level = FINEST


 /*Here, we’ve set the logging level for just our test logger, by name. The log properties
follow the hierarchy, so we could set the logging level for all classes in the oreilly
package with: */

 com.oreilly.level = FINEST

 /*
Logging levels are set in the order in which they are read in the properties file, so set
the general ones first. Note that the levels set on the handlers allow the file handler to
filter only the messages being supplied by the loggers. Therefore, setting the file han‐
dler to FINEST won’t revive messages squelched by a logger set to SEVERE (only the
SEVERE messages will make it to the handler from that logger). */

/*The Logger
In our example, we used the seven convenience methods named for the various log‐
ging levels. There are also three groups of general methods that can be used to pro‐
vide more detailed information. The most general are:
 */
log(Level level, String msg)
 log(Level level, String msg, Object param1)
 log(Level level, String msg, Object params[])
 log(Level level, String msg, Throwable thrown)
 /*These methods accept as their first argument a static logging level identifier from the
Level class, followed by a parameter, array, or exception type. The level identifier is
one of Level.SEVERE, Level.WARNING, Level.INFO, and so on.
In addition to these four methods, there are convenience methods called entering(),
exiting(), and throwing() that developers can use to log detailed trace information.  */