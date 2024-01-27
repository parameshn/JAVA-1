/*Constructors


Objects are allocated with the new operator using a constructor. A constructor is a spe‐
cial method with the same name as its class and no return type. It’s called when a new
class instance is created, which gives the class an opportunity to set up the object for
use. Constructors, like other methods, can accept arguments and can be overloaded
(they are not, however, inherited like other methods). */

class Date {
    long time;
    Date() {
    time = currentTime();
    }
    Date( String date ) {
    time = parseDate( date );
    }
    ...
    }

    /*In this example, the class Date has two constructors. The first takes no arguments; it’s
known as the default constructor. Default constructors play a special role: if we don’t
define any constructors for a class, an empty default constructor is supplied for us.
The default constructor is what gets called whenever you create an object by calling
its constructor with no arguments. Here we have implemented the default construc‐
tor so that it sets the instance variable time by calling a hypothetical method, current
Time(), which resembles the functionality of the real java.util.Date class. The
second constructor takes a String argument. Presumably, this String contains a
string representation of the time that can be parsed to set the time variable. Given the
constructors in the previous example, we create a Date object in the following ways: */

Date now = new Date();
 Date christmas = new Date("Dec 25, 2020");


 /*In each case, Java chooses the appropriate constructor at compile time based on the
rules for overloaded method selection.
If we later remove all references to an allocated object, it’ll be garbage-collected, as
we’ll discuss shortly:
 */

 christmas = null; // fair game for the garbage collector

 /*Setting this reference to null means it’s no longer pointing to the "Dec 25, 2006"
date object. Setting the variable christmas to any other value would have the same
effect. Unless the original date object is referenced by another variable, it’s now inac‐
cessible and can be garbage-collected. We’re not suggesting that you have to set refer‐
ences to null to get the values garbage-collected. Often this just happens naturally
when local variables fall out of scope, but items referenced by instance variables of
objects live as long as the object itself lives (through references to it), and static vari‐
ables live effectively forever. */

/*A few more notes: constructors can’t be declared abstract, synchronized, or final
(we’ll define the rest of those terms later). Constructors can, however, be declared
with the visibility modifiers public, private, or protected, just like other methods,
to control their accessibility. We’ll talk in detail about visibility modifiers in the next
chapter */