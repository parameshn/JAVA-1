/*try with Resources */

/*A common use of the finally clause is to ensure that resources used in a try clause
are cleaned up, no matter how the code exits the block. */

try {
    // Socket sock = new Socket(...);
    // work with sock
    } catch( IOException e ) {
    ...
    }
    finally {
    if ( sock != null ) { sock.close(); }
    }
   

    /*What we mean by “cleaned up” here is to deallocate expensive resources or close con‐
nections such as files, sockets, or database connections. In some cases, these resources
might get cleaned up on their own eventually as Java reclaims the garbage, but that
would at best be at an unknown time in the future and at worst may never happen or
may not happen before you run out of resources. So it is always best to guard against
these situations. There are two problems with this venerable approach: first, it
requires extra work to carry out this pattern in all of your code, including important
things like null checks, as shown in our example, and second, if you are juggling mul‐
tiple resources in a single finally block, you have the possibility of your cleanup
code throwing an exception (e.g., on close()) and leaving the job unfinished. */

/*In Java 7, things have been greatly simplified via the new “try with resources” form of
the try clause. In this form, you may place one or more resource initialization state‐
ments within parentheses after a try keyword, and those resources will automatically
be “closed” for you when control leaves the try block: */

try (
    Socket sock = new Socket("128.252.120.1", 80);
    FileWriter file = new FileWriter("foo");
    )
    {
    // work with sock and file
    } catch ( IOException e ) {
    ...
    }



    /*In this example, we initialize both a Socket object and a FileWriter object within the
try-with-resources clause and use them within the body of the try statement. When
control leaves the try statement, either after successful completion or via an excep‐
tion, both resources are automatically closed by calling their close() method.
Resources are closed in the reverse of the order in which they were constructed, so
dependencies among them can be accommodated. This behavior is supported for any
class that implements the AutoCloseable interface (which, at current count, over one
hundred different built-in classes do). The close() method of this interface is pre‐
scribed to release all resources associated with the object, and you can implement this
easily in your own classes as well. When using try with resources, we don’t have to
add any code specifically to close the file or socket; it is done for us automatically.


Another problem that try with resources solves is the pesky situation we alluded to
where an exception may be thrown during a close operation. Looking back to the
prior example in which we used a finally clause to do our cleanup, if an exception
had been raised by the close() method, it would have been thrown at that point,
completely abandoning the original exception from the body of the try clause. But in
using try with resources, we preserve the original exception. If an exception occurs
while within the body of the try and one or more exceptions is raised during the sub‐
sequent auto-closing operations, it is the original exception from the body of the try
that is bubbled up to the caller. Let’s look at an example: */

try (
 Socket sock = new Socket("128.252.120.1", 80); // potential exception #3
 FileWriter file = new FileWriter("foo"); // potential exception #2
 )
 {
 // work with sock and file // potential exception #1
 }

 /*Once the try has begun, if an exception occurs as exception point #1, Java will
attempt to close both resources in reverse order, leading to potential exceptions at
locations #2 and #3. In this case, the calling code will still receive exception #1. Excep‐
tions #2 and #3 are not lost, however; they are merely “suppressed” and can be
retrieved via the Throwable getSuppressed() method of the exception thrown to the
caller. This returns an array of all of the supressed exceptions. */