//Assertions

/*An assertion is a simple pass/fail test of some condition, performed while your appli‐
cation is running. Assertions can be used to “sanity check” your code anywhere you
believe certain conditions are guaranteed by correct program behavior. Assertions are
distinct from other kinds of tests because they check conditions that should never be
violated at a logical level: if the assertion fails, the application is to be considered bro‐
ken and generally halts with an appropriate error message. Assertions are supported
directly by the Java language and they can be turned on or off at runtime to remove
any performance penalty of including them in your code.


/*Using assertions to test for the correct behavior of your application is a simple but
powerful technique for ensuring software quality. It fills a gap between those aspects
of software that can be checked automatically by the compiler and those more gener‐
ally checked by “unit tests” and human testing. Assertions test assumptions about
program behavior and make them guarantees (at least while they are activated).
*/

if ( !condition )
 throw new AssertionError("fatal error: 42");

 /*An assertion in Java is equivalent to this example, but is performed with the assert
language keyword. It takes a Boolean condition and an optional expression value. If
the assertion fails, an AssertionError is thrown, which usually causes Java to bail out
of the application. */

/*The optional expression may evaluate to either a primitive or object type. Either way,
its sole purpose is to be turned into a string and shown to the user if the assertion
fails; most often you’ll use a string message explicitly. Here are some examples:
 */
assert false;
 assert ( array.length > min );
 assert a > 0 : a // shows value of a to the user
 assert foo != null : "foo is null!" // shows message "foo is null!" to user

 /*In the event of failure, the first two assertions print only a generic message, whereas
the third prints the value of a, and the last prints the foo is null! message.


Again, the important thing about assertions is not just that they are more terse than
the equivalent if condition, but that they can be enabled or disabled when you run
the application. Disabling assertions means that their test conditions are not even
evaluated, so there is no performance penalty for including them in your code (other
than, perhaps, space in the class files when they are loaded).*/

/*If you have done some programming, hopefully you have not written such opaque error messages! The more
helpful and explanatory your messages, the better.
 */