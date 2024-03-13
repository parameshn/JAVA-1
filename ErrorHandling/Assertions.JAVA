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


 ////////////////////////////////////////////////////////////////////////
 //Enabling and Disabling Assertions

 /*Assertions are turned on or off at runtime. When disabled, assertions still exist in the
class files but are not executed and consume no time. You can enable and disable
assertions for an entire application or on a package-by-package or even class-by-class
basis. By default, assertions are turned off in Java. To enable them for your code, use
the java command flag -ea or -enableassertions */

% java -ea MyApplication

//To turn on assertions for a particular class, append the class name:

 % java -ea:com.oreilly.examples.Myclass MyApplication

//To turn on assertions just for particular packages, append the package name with
//trailing ellipses (. . .):

 % java -ea:com.oreilly.examples... MyApplication

/*When you enable assertions for a package, Java also enables all subordinate package
names (e.g., com.oreilly.examples.text). However, you can be more selective by
using the corresponding -da or -disableassertions flag to negate individual pack‐
ages or classes. You can combine all this to achieve arbitrary groupings like this: */

 % java -ea:com.oreilly.examples...
 -da:com.oreilly.examples.text -ea:com.oreilly.examples.text.MonkeyTypewriters MyApplication

/*This example enables assertions for the com.oreilly.examples package as a whole,
excludes the package com.oreilly.examples.text, and then turns exceptions on for
just one class, MonkeyTypewriters, in that package */


/*Using Assertions
An assertion enforces a rule about something that should be unchanging in your code
and would otherwise go unchecked. You can use an assertion for added safety
anywhere you want to verify your assumptions about program behavior that can’t be
checked by the compiler. */

/*A common situation that cries out for an assertion is testing for multiple conditions
or values where one should always be found. In this case, a failing assertion as the
default or “fall through” behavior indicates the code is broken. For example, suppose
we have a value called direction that should always contain either the constant value
LEFT or RIGHT: */


if ( direction == LEFT )
 doLeft();
 else if ( direction == RIGHT )
 doRight()
 else
 assert false : "bad direction";


 //The same applies to the default case of a switch:
 switch ( direction ) {
    case LEFT:
    doLeft();
    break;
    case RIGHT:
    doRight();
    break;
    default:
    assert false;
    }

    /*In general, you should not use assertions for checking the validity of arguments to
methods because you want that behavior to be part of your application, not just a test
for quality control that can be turned off. The validity of input to a method is called
its preconditions, and you should usually throw an exception if they are not met; this
elevates the preconditions to part of the method’s “contract” with the user. However,
checking the correctness of the results of your methods with assertions before return‐
ing them is a good idea; these are called postconditions. */