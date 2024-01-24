/*there is a schism in the Java world between class types
(i.e., objects) and primitive types (i.e., numbers, characters, and boolean values). Java
accepts this trade-off simply for efficiency reasons. When you’re crunching numbers,
you want your computations to be lightweight; having to use objects for primitive
types complicates performance optimizations. For the times you want to treat values
as objects, Java supplies a standard wrapper class for each of the primitive types, */

/*Primitive type wrappers
Primitive Wrapper
void java.lang.Void
boolean java.lang.Boolean
char java.lang.Character
byte java.lang.Byte
short java.lang.Short
int java.lang.Integer
long java.lang.Long
float java.lang.Float
double java.lang.Double
 */

 /*An instance of a wrapper class encapsulates a single value of its corresponding type.
It’s an immutable object that serves as a container to hold the value and let us retrieve
it later. You can construct a wrapper object from a primitive value or from a String
representation of the value. The following statements are equivalent: */
Float pi = new Float( 3.14 );
 Float pi = new Float( "3.14" );

 /*The wrapper constructors throw a NumberFormatException when there is an error in
parsing a string.
Each of the numeric type wrappers implements the java.lang.Number interface,
which provides “value” methods access to its value in all the primitive forms. You can
retrieve scalar values with the methods doubleValue(), floatValue(), longValue(),
intValue(), shortValue(), and byteValue(): */

Double size = new Double ( 32.76 );
 double d = size.doubleValue(); // 32.76
 float f = size.floatValue(); // 32.76
 long l = size.longValue(); // 32
 int i = size.intValue(); // 32

 /*This code is equivalent to casting the primitive double value to the various types.
The most common need for a wrapper is when you want to pass a primitive value to a
method that requires an object.

The Collections API works on object types, so primitives must be
wrapped when stored in them.
wrapping process automatic. For now, however, let’s do it ourselves. As we’ll see, a
List is an extensible collection of Objects. We can use wrappers to hold numbers in a
List (along with other objects):*/
// Simple Java code
List myNumbers = new ArrayList();
Integer thirtyThree = new Integer( 33 );
myNumbers.add( thirtyThree );

/*Here, we have created an Integer wrapper object so that we can insert the number
into the List, using the add() method, which accepts an object. Later, when we are
extracting elements from the List, we can recover the int value as follows:
 */
// Simple Java code
Integer theNumber = (Integer)myNumbers.get(0);
int n = theNumber.intValue(); // 33

/*As we alluded to earlier, allowing Java to do this for us (“autoboxing”) makes the code
more concise and safer. The usage of the wrapper class is mostly hidden from us by
the compiler, but it is still being used internally: */
// Java code using autoboxing and generics
List<Integer> myNumbers = new ArrayList<Integer>();
myNumbers.add( 33 );
int n = myNumbers.get( 0 );
