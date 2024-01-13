/*Static Methods



Static methods (class methods), like static variables, belong to the class and not to
individual instances of the class. What does this mean? Well, foremost, a static
method lives outside of any particular class instance. It can be invoked by name,
through the class name, without any objects around. Because it is not bound to a par‐
ticular object instance, a static method can directly access only other static members
(static variables and other static methods) of the class. It can’t directly see any
instance variables or call any instance methods, because to do so we’d have to ask, “on
which instance?” Static methods can be called from instances, syntactically just like
instance methods, but the important thing is that they can also be used
independently. */

/*Static methods are particularly
useful for utility methods that perform work that is useful either independently of
instances or in working on instances.  */

class Apple {
    ...
    public static String[] getAppleSizes() {
    // Return names for our constants
    // The index of the name should match the value of the constant
    return new String[] { "SMALL", "MEDIUM", "LARGE" };
    }
    ...
    }
/*Here, we’ve defined a static method, getAppleSizes(), that returns an array of
strings containing apple size names. We make the method static because the list of
sizes is the same regardless of what size any given instance of Apple might be. We can
still use getAppleSizes() from within an instance of Apple if we wanted, just like an
instance method. We could change the (nonstatic) printDetails method to print a
size name rather than an exact diameter, for example:
 */   
public void printDetails() {
    System.out.println(" mass: " + mass);
    // Print the exact diameter:
    //System.out.println(" diameter: " + diameter);
    // Or a nice, human-friendly approximate
    String niceNames[] = getAppleSizes();
    if (diameter < 5.0f) {
    System.out.println(niceNames[SMALL]);
    } else if (diameter < 10.0f) {
    System.out.println(niceNames[MEDIUM]);
    } else {
    System.out.println(niceNames[LARGE]);
    }
    System.out.println(" position: (" + x + ", " + y +")");
    }

    
    /*However, we can also call it from other classes, using the Apple class name with the
dot notation. For example, the very first PrintAppleDetails class could use similar
logic to print a summary statement using our static method and static variables, like
so: */
public class PrintAppleDetails {
    public static void main(String args[]) {
    String niceNames[] = Apple.getAppleSizes();
    Apple a1 = new Apple();
    System.out.println("Apple a1:");
    System.out.println(" mass: " + a1.mass);
    System.out.println(" diameter: " + a1.diameter);
    System.out.println(" position: (" + a1.x + ", " + a1.y +")");
    if (a1.diameter < 5.0f) {
    System.out.println("This is a " + niceNames[Apple.SMALL] + " apple.");
    } else if (a1.diameter < 10.0f) {
    System.out.println("This is a " + niceNames[Apple.MEDIUM] + " apple.");
    } else {
    System.out.println("This is a " + niceNames[Apple.LARGE] + " apple.");
    }
    }
   }
/*Here we have our trusty instance of the Apple class, a1, but it is not needed to get the
list of our sizes. Notice that we load the list of nice names before we create a1. But
everything still works as seen in the output:
Apple a1:
 mass: 0.0
 diameter: 1.0
 position: (0, 0)
This is a SMALL apple.
 */   