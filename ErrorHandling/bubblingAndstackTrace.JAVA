/*What if we hadn’t caught the exception? Where would it have gone? Well, if there is
no enclosing try/catch statement, the exception pops up from the method in which
it originated and is thrown from that method up to its caller. If that point in the call‐
ing method is within a try clause, control passes to the corresponding catch clause.
Otherwise, the exception continues propagating up the call stack, from one method 
to its caller. In this way, the exception bubbles up until it’s caught, or until it pops out
of the top of the program, terminating it with a runtime error message.



In this figure, the second call to write() throws an IOException. Since sendRe
quest() doesn’t contain a try/catch statement to handle the exception, it’s thrown
again from the point where it was called in the method openConnection(). Since
openConnection() doesn’t catch the exception either, it’s thrown once more. Finally,
it’s caught by the try statement in getContent() and handled by its catch clause.


////////
Notice that each throwing method must declare with a throws clause that it can
throw the particular type of exception.*/


////////////////////////////////////////////
/*Stack Traces
Because an exception can bubble up quite a distance before it is caught and handled,
we may need a way to determine exactly where it was thrown. It’s also very important
to know the context of how the point of the exception was reached; that is, which
methods called which methods to get to that point. For these kinds of debugging and
logging purposes, all exceptions can dump a stack trace that lists their method of
origin and all the nested method calls it took to arrive there. Most commonly, the
user sees a stack trace when it is printed using the printStackTrace() method. */
try {
    // complex, deeply nested task
    } catch ( Exception e ) {
    // dump information about exactly where the exception occurred
    e.printStackTrace( System.err );
    ...
    }

   // For example, the stack trace for an exception might look like this:
 java.io.FileNotFoundException: myfile.xml
 at java.io.FileInputStream.<init>(FileInputStream.java)
 at java.io.FileInputStream.<init>(FileInputStream.java)
 at MyApplication.loadFile(MyApplication.java:137)
 at MyApplication.main(MyApplication.java:5)

 /*This stack trace indicates that the main() method of the class MyApplication called
the method loadFile(). The loadFile() method then tried to construct a FileIn
putStream, which threw the FileNotFoundException. Note that once the stack trace
reaches Java system classes (like FileInputStream), the line numbers may be lost.
This can also happen when the code is optimized by some virtual machines. Usually,
there is a way to disable the optimization temporarily to find the exact line numbers.
However, in tricky situations, changing the timing of the application can affect the
problem you’re trying to debug, and other debugging techniques may be required.


Methods on the exception allow you to retrieve the stack trace information program‐
matically as well by using the Throwable getStackTrace() method. (Throwable is
the base class of Exception and Error.) This method returns an array of StackTra
ceElement objects, each of which represents a method call on the stack. You can ask a
StackTraceElement for details about that method’s location using the methods getFi
leName(), getClassName(), getMethodName(), and getLineNumber(). Element zero
of the array is the top of the stack, the final line of code that caused the exception;
subsequent elements step back one method call each until the original main()
method is reached*/