/*Throwing Exceptions


We can throw our own exceptions—either instances of Exception, one of its existing
subclasses, or our own specialized exception classes. All we have to do is create an
instance of the Exception and throw it with the throw statement:
 */

 throw new IOException();
/*Execution stops and is transferred to the nearest enclosing try/catch statement that
can handle the exception type. (There is little point in keeping a reference to the
Exception object we’ve created here.) An alternative constructor lets us specify a
string with an error message: */

throw new IOException("Sunspots!");
/*You can retrieve this string by using the Exception object’s getMessage() method.
Often, though, you can just print (or toString()) the exception object itself to get
the message and stack trace.
By convention, all types of Exception have a String constructor like this. The pre‐
ceding String message is not very useful. Normally, it will throw a more specific sub‐
class Exception, which captures details or at least a more specific string explanation.
Here’s another example: */

public void checkRead( String s ) {
    if ( new File(s).isAbsolute() || (s.indexOf("..") != -1) )
    throw new SecurityException(
    "Access to file : "+ s +" denied.");
    }

    /*In this code, we partially implement a method to check for an illegal path. If we find
one, we throw a SecurityException with some information about the transgression.
Of course, we could include any other information that is useful in our own special‐
ized subclasses of Exception. Often, though, just having a new type of exception is
good enough because it’s sufficient to help direct the flow of control. For example, if
we are building a parser, we might want to make our own kind of exception to indi‐
cate a particular kind of failure: */

class ParseException extends Exception {
    private int lineNumber;
    ParseException() {
    super();
    this.lineNumber = -1;
    }
    ParseException( String desc, int lineNumber ) {
    super( desc );
    this.lineNumber = lineNumber;
    }
    public int getLineNumber() {
    return lineNumber;
    }
    }

    /*The body of our Exception class here simply allows a ParseException to be created
in the conventional ways we’ve created exceptions previously (either generically or
with a little extra information). Now that we have our new exception type, we can
guard like this: */
// Somewhere in our code
...
try {
parseStream( input );
} catch ( ParseException pe ) {
// Bad input...
// We can even tell them which line was bad!
} catch ( IOException ioe ) {
// Low-level communications problem
}

/*As you can see, even without the special information like the line number where our
input caused a problem, our custom exception lets us distinguish a parse error from
an arbitrary I/O error in the same chunk of code.
 */