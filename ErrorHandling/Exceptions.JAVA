//Exceptions


/*In this chapter we’ll consider how Java tackles the problem of, well, problems. We’ll
go over the notion of exceptions to look at how and why they occur as well as how
and where to handle them. We’ll also be looking at errors and assertions. Errors rep‐
resent more serious problems that often cannot be fixed at runtime but can still be
logged for debugging. Assertions are a popular way of innoculating your code against
exceptions or errors by verifying that safe conditions exist ahead of time. */


/*Java offers an elegant solution to aid the programmer in addressing common coding
and runtime problems through exceptions. (Java exception handling is similar to, but
not quite the same as, exception handling in C++.) An exception indicates an unusual
condition or an error condition. Program control becomes unconditionally transfer‐
red or “thrown” to a specially designated section of code where that condition is
caught and handled. In this way, error handling is independent of the normal flow of
the program. We don’t need special return values for all of our methods; errors are
handled by a separate mechanism. Control can be passed a long distance from a
deeply nested routine and handled in a single location when that is desirable, or an
error can be handled immediately at its source. A few standard Java API methods still
return -1 as a special value, but these are generally limited to situations where we are
expecting a special value and the situation is not really out of bounds.2


A Java method is required to specify the checked exceptions it can throw, and the
compiler makes sure that callers of the method handle them. In this way, the informa‐
tion about what errors a method can produce is promoted to the same level of impor‐
tance as its argument and return types. You may still decide to punt and ignore
obvious errors, but in Java you must do so explicitly. (We’ll discuss runtime excep‐
tions and errors, which are not required to be declared or handled by the method, in
a moment.)
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*Exceptions and Error Classes */

 /*Exceptions are represented by instances of the class java.lang.Exception and its
subclasses. Subclasses of Exception can hold specialized information (and possibly
behavior) for different kinds of exceptional conditions. However, more often they are
simply “logical” subclasses that serve only to identify a new exception type. Figure 6-1
shows the subclasses of Exception in the java.lang package. It should give you a feel
for how exceptions are organized; we’ll go into more details on class organization in
the next chapter. Most other packages define their own exception types, which usu‐
ally are subclasses of Exception itself or of its important subclass RuntimeException,
which we’ll get to in a moment */

/*For example, another important exception class is IOException in the package
java.io. The IOException class extends Exception and has many subclasses for typi‐
cal I/O problems (such as a FileNotFoundException) and networking problems
(such as a MalformedURLException). Network exceptions belong to the java.net
package. */

/*An Exception object is created by the code at the point where the error condition
arises. It can be designed to hold any information that is necessary to describe the
exceptional condition and also includes a full stack trace for debugging. A stack trace
is the (occasionally unwieldy) list of all the methods called and the order in which
they were called up to the point where the exception was thrown. We’ll look at these
useful lists in more detail in “Stack Traces” on page 176. The Exception object is
passed as an argument to the handling block of code, along with the flow of control.
This is where the terms throw and catch come from: the Exception object is thrown
from one point in the code and caught by the other, where execution resumes */

/*The Java API also defines the java.lang.Error class for unrecoverable errors. The
subclasses of Error in the java.lang package are shown in Figure 6-2. A notable
Error type is AssertionError, which is used by the Java assert statement to indicate
a failure (assertions are discussed later in this chapter). A few other packages define
their own subclasses of Error, but subclasses of Error are much less common (and
less useful) than subclasses of Exception. You generally needn’t worry about these
errors in your code (i.e., you do not have to catch them); they are intended to indicate
fatal problems or virtual machine errors. An error of this kind usually causes the Java
interpreter to display a message and exit. You are actively discouraged from trying to
catch or recover from them because they are supposed to indicate a fatal program
bug, not a routine condition.

Both Exception and Error are subclasses of Throwable. The Throwable class is the
base class for objects that can be “thrown” with the throw statement. In general, you
should extend only Exception, Error, or one of their subclasses.*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//Exception Handling

/*The try/catch guarding statements wrap a block of code and catch designated types
of exceptions that occur within it: */
try {
    readFromFile("foo");
    ...
    }
    catch ( Exception e ) {
        // Handle error
        System.out.println( "Exception while reading file: " + e );
        ...
        }

        /*In this example, exceptions that occur within the body of the try portion of the state‐
ment are directed to the catch clause for possible handling. The catch clause acts like
a method; it specifies as an argument the type of exception it wants to handle and if
it’s invoked, it receives the Exception object as an argument. Here, we receive the
object in the variable e and print it along with a message. */

/*We can try this ourselves. Recall the simple program to calculate the greatest com‐
mon denominator using the Euclid algorithm back in Chapter 4. We could augment
that program to allow the user to pass in the two numbers a and b as command-line
arguments via that args[] array in the main() method. However, that array is of type
String. If we cheat a little bit and jump forward a couple chapters, we can use a pars‐
ing method we cover in “Parsing Primitive Numbers” on page 229 to turn those argu‐
ments into int values. However, that parsing method can throw an exception if we
don’t pass a valid number. Here’s a look at our new Euclid2 class: */


public class Euclid2 {
    public static void main(String args[]) {
    int a = 2701;
    int b = 222;
    // Only try to parse arguments if we have exactly 2
    if (args.length == 2) {
    try {
    a = Integer.parseInt(args[0]);
    b = Integer.parseInt(args[1]);
    } catch (NumberFormatException nfe) {
    System.err.println("Arguments were not both numbers.
    Using defaults.");
    }
    } else {
        System.err.println("Wrong number of arguments (expected 2).
        Using defaults.");
        }
        System.out.print("The GCD of " + a + " and " + b + " is ");
        while (b != 0) {
            if (a > b) {
                a = a - b;
                } else {
                b = b - a;
                }
                }
                System.out.println(a);
                }
               }


   //A try statement can have multiple catch clauses that specify different types (sub‐classes) of Exception:
   try {
    readFromFile("foo");
    ...
    }
    catch ( FileNotFoundException e ) {
    // Handle file not found
    ...
    }
    catch ( IOException e ) {
    // Handle read error
    ...
    }
    catch ( Exception e ) {
    // Handle all other errors
    ...
    }
   
    /*The catch clauses are evaluated in order, and the first assignable match is taken. At
most, one catch clause is executed, which means that the exceptions should be listed
from most to least specific. In the previous example, we anticipate that the hypotheti‐
cal readFromFile() can throw two different kinds of exceptions: one for a file not
found and another for a more general read error. In the preceding example, FileNot
FoundException is a subclass of IOException, so if the first catch clause were not
there, the exception would be caught by the second in this case. Similarly, any sub‐
class of Exception is assignable to the parent type Exception, so the third catch
clause would catch anything passed by the first two. It acts here like the default
clause in a switch statement and handles any remaining possibilities. We’ve shown it
here for completeness, but in general you want to be as specific as possible in the
exception types you catch. */

/*One advantage of the try/catch scheme is that any statement in the try block can
assume that all previous statements in the block succeeded. A problem won’t arise
suddenly because a programmer forgot to check the return value from a method. If
an earlier statement fails, execution jumps immediately to the catch clause; later
statements are never executed.
 */

 /*Starting with Java 7, there is an alternative to using multiple catch clauses, and that is
to handle multiple discrete exception types in a single catch clause using the “|” or
syntax: */
try {
    // read from network...
    // write to file..
}
    catch ( ZipException | SSLException e ) {
    logException( e );
    }

    /*Using this “|” or syntax, we receive both types of exception in the same catch clause.
So, what is the actual type of the e variable that we are passing to our log method?
(What can we do with it?) In this case, it will be neither ZipException nor SSLExcep
tion but IOException, which is the two exceptions’ nearest common ancestor (the
closest parent class type to which they are both assignable). In many cases, the nearest
common type among the two or more argument exception types may simply be
Exception, the parent of all exception types. The difference between catching these
discrete exception types with a multiple-type catch clause and simply catching the
common parent exception type is that we are limiting our catch to only these specifi‐
cally enumerated exception types and we will not catch all the other IOException
types, as would be the alternative in this case. The combination of multiple-type
catch and ordering your catch clauses from most specific to most broad (“narrow”
to “wide”) types gives you great flexibility to structure your catch clauses. You can
consolidate error-handling logic where it is appropriate and to not repeat code. There
are more nuances to this feature, and we will return to it after we have discussed
“throwing” and “rethrowing” exceptions. */