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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//Working with Overloaded Constructors

/*A constructor can refer to another constructor in the same class or the immediate
superclass using special forms of the this and super references.  */

/* A constructor can invoke another overloaded con‐
structor in its class using the self-referential method call this() with appropriate
arguments to select the desired constructor. If a constructor calls another constructor,
it must do so as its first statement: */

class Car {
    String model;
    int doors;
    Car( String model, int doors ) {
    this.model = model;
    this.doors = doors;
    // other, complicated setup
    
    }
    Car( String model ) {
    this( model, 4 /* doors */ );
    }
    
    }


 /*In this example, the class Car has two constructors. 

 The first, more explicit, one
accepts arguments specifying the car’s model and its number of doors. 

The second
constructor takes just the model as an argument and, in turn, calls the first construc‐
tor with a default value of four doors 

The advantage of this approach is that you can have a single constructor do all the complicated setup work; other auxiliary construc‐
tors simply feed the appropriate arguments to that constructor.
*/


/*The special call to this() must appear as the first statement in our delegating con‐
structor. The syntax is restricted in this way because there’s a need to identify a clear
chain of command in the calling of constructors. At the end of the chain, Java invokes
the constructor of the superclass (if we don’t do it explicitly) to ensure that inherited
members are initialized properly before we proceed. */

/*There’s also a point in the chain, just after invoking the constructor of the superclass,
where the initializers of the current class’s instance variables are evaluated. Before that
point, we can’t even reference the instance variables of our class */

/*For now, all you need to know is that you can invoke a second constructor (delegate
to it) only as the first statement of your constructor. For example, the following code
is illegal and causes a compile-time error: */

Car( String m ) {
    int doors = determineDoors();
    this( m, doors ); // Error: constructor call
    // must be first statement
    }

    /*The simple model name constructor can’t do any additional setup before calling the
more explicit constructor. It can’t even refer to an instance member for a constant
value: */

class Car {
    ...
    final int default_doors = 4;
    ...
    Car( String m ) {
    this( m, default_doors ); // Error: referencing
    // uninitialized variable
    }
    ...
    }

    /*The instance variable defaultDoors is not initialized until a later point in the chain of
constructor calls setting up the object, so the compiler doesn’t let us access it yet. For‐
tunately, we can solve this particular problem by using a static variable instead of an
instance variable:
 */

 class Car {
    ...
    static final int DEFAULT_DOORS = 4;
    ...
    Car( String m ) {
        this( m, DEFAULT_DOORS ); // Okay!
 }
 ...
}

//The static members of a class are initialized when the class is first loaded into the virtual machine, so it’s safe to access them in a constructor.
