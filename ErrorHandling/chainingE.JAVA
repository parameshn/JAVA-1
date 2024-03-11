/*Chaining and rethrowing exceptions
Sometimes you’ll want to take some action based on an exception and then turn
around and throw a new exception in its place. This is common when building
frameworks where low-level detailed exceptions are handled and represented by
higher-level exceptions that can be managed more easily. For example, you might
want to catch an IOException in a communications package, possibly perform some
cleanup, and ultimately throw a higher-level exception of your own, maybe some‐
thing like LostServerConnection.


You can do this in the obvious way by simply catching the exception and then throw‐
ing a new one, but then you lose important information, including the stack trace of
the original “causal” exception. To deal with this, you can use the technique of excep‐
tion chaining. This means that you include the causal exception in the new exception
that you throw. Java has explicit support for exception chaining. The base Exception
class can be constructed with an exception as an argument or the standard String
message and an exception: */

throw new Exception( "Here's the story...", causalException );


/*You can get access to the wrapped exception later with the getCause() method. More
importantly, Java automatically prints both exceptions and their respective stack
traces if you print the exception or if it is shown to the user.


You can add this kind of constructor to your own exception subclasses (delegating to
the parent constructor) or you can take advantage of this pattern by using the 
Throwable method initCause() to set the causal exception explicitly after construct‐
ing your exception and before throwing it:
*/

try {
    // ...
    } catch ( IOException cause ) {
    Exception e =
    new IOException("What we have here is a failure to communicate...");
    e.initCause( cause );
    throw e;
    }
   


   // Sometimes it’s enough to simply do some logging or take some action and then
//rethrow the original exception:
 try {
 // ...
 } catch ( IOException cause ) {
 log( cause ); // Log it
 throw cause; // rethrow it
 }



 /*Narrowed rethrow


Prior to Java 7, if you wanted to handle a bunch of exception types in a single catch
clause and then rethrow the original exception, you would inevitably end up widen‐
ing the declared exception type to what was required to catch them all or having to do
a lot of work to avoid that. In Java 7, the compiler has become smarter and can now
do most of the work for us by allowing us to narrow the type of exceptions thrown
back to the original types in most cases. This is best explained by example:
 */

 void myMethod() throws ZipException, SSLException
 {
 try {
 // Possible cause of ZipException or SSLException
 } catch ( Exception e ) {
 log( e );
 throw e;
 }
 }


 /*In this example, we are exceedingly lazy and simply catch all exceptions with a broad
catch Exception clause in order to log them prior to rethrowing. Prior to Java 7, the
compiler would have insisted that the throws clause of our method declare that it
throws the broad Exception type as well. However, the Java compiler is now smart
enough in most cases to analyze the actual types of exceptions that may be thrown
and allow us to prescribe the precise set of types. The same would be true if we had
used the mutiple-type catch clause in this example, as you might have guessed. The
preceding is a bit less intuitive, but very useful in shoring up the specificity of
exception handling of code, including code written prior to Java 7, without requiring
potentially tricky reworking of catch clauses. */