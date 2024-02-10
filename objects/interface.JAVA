/*Interfaces
Java expands on the concept of abstract methods with interfaces. It’s often desirable to
specify a group of abstract methods defining some behavior for an object without
tying it to any implementation at all. In Java, this is called an interface. An interface
defines a set of methods that a class must implement. A class in Java can declare that
it implements an interface if it implements the required methods. Unlike extending an
abstract class, a class implementing an interface doesn’t have to inherit from any par‐
ticular part of the inheritance hierarchy or use a particular implementation. */


/*Interfaces are kind of like Boy Scout or Girl Scout merit badges. A scout who has
learned to build a birdhouse can walk around wearing a little sleeve patch with a pic‐
ture of one. This says to the world, “I know how to build a birdhouse.” Similarly, an
interface is a list of methods that define some set of behavior for an object. Any class
that implements each method listed in the interface can declare at compile time that it
implements the interface and wear, as its merit badge, an extra type—the interface’s
type. */

/*Interface types act like class types. You can declare variables to be of an interface type,
you can declare arguments of methods to accept interface types, and you can specify
that the return type of a method is an interface type. In each case, what is meant is
that any object that implements the interface (i.e., wears the right merit badge) can fill
that role. In this sense, interfaces are orthogonal to the class hierarchy. They cut
across the boundaries of what kind of object an item is and deal with it only in terms
of what it can do. A class can implement as many interfaces as it desires. In this way, 
interfaces in Java replace much of the need for multiple inheritance in other lan‐
guages (and all its messy complications) */

/*An interface looks, essentially, like a purely abstract class (i.e., a class with only
abstract methods). You define an interface with the interface keyword, and list its
methods with no bodies, just prototypes (signatures): */

interface Driveable {
    boolean startEngine();
    void stopEngine();
 float accelerate( float acc );
 boolean turn( Direction dir );
 }

 /*The previous example defines an interface called Driveable with four methods. It’s
acceptable, but not necessary, to declare the methods in an interface with the
abstract modifier; we haven’t done that here. More importantly, the methods of an
interface are always considered public, and you can optionally declare them as so.
Why public? Well, the user of the interface wouldn’t necessarily be able to see them
otherwise, and interfaces are generally intended to describe the behavior of an object,
not its implementation. */

/*Interfaces define capabilities, so it’s common to name interfaces after their capabili‐
ties. Driveable, Runnable, and Updateable are good interface names. Any class that
implements all the methods can then declare that it implements the interface by using
a special implements clause in its class definition. For example:
 */

 class Automobile implements Driveable {
    ...
    public boolean startEngine() {
    if ( notTooCold )
    engineRunning = true;
    ...
    }
    public void stopEngine() {
    engineRunning = false;
    }
    public float accelerate( float acc ) {
    ...
    }
    public boolean turn( Direction dir ) {
    ...
    }
    ...
    }

    /*Here, the class Automobile implements the methods of the Driveable interface and
declares itself a type of Driveable using the implements keyword. */



/*After declaring the interface, we have a new type, Driveable. We can declare vari‐
ables of type Driveable and assign them any instance of a Driveable object:
 */

 Automobile auto = new Automobile();
 Lawnmower mower = new Lawnmower();
 Driveable vehicle;
 vehicle = auto;
 vehicle.startEngine();
 vehicle.stopEngine();
 vehicle = mower;
 vehicle.startEngine();
 vehicle.stopEngine();

 /*Both Automobile and Lawnmower implement Driveable, so they can be considered
interchangeable objects of that type. */