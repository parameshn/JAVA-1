//Arrays

/*An array is a special type of object that can hold an ordered collection of elements.
The type of the elements of the array is called the base type of the array; the number
of elements it holds is a fixed attribute called its length. Java supports arrays of all
primitive and reference types.

If you have done any programming in C or C++, the basic syntax of arrays looks sim‐
ilar. We create an array of a specified length and access the elements with the index
operator, []. Unlike other languages, however, arrays in Java are true, first-class
objects. An array is an instance of a special Java array class and has a corresponding
type in the type system. This means that to use an array, as with any other object, we
first declare a variable of the appropriate type and then use the new operator to create
an instance of it. */

//Array objects differ from other objects in Java in three respects:

/*• Java implicitly creates a special array class type for us whenever we declare a new
type of array. It’s not strictly necessary to know about this process in order to use
arrays, but it helps in understanding their structure and their relationship to
other objects in Java later.

• Java lets us use the [] operator to access array elements so that arrays look as we
expect. We could implement our own classes that act like arrays, but we would
have to settle for having methods such as get() and set() instead of using the
special [] notation

• Java provides a corresponding special form of the new operator that lets us con‐
struct an instance of an array with a specified length with the [] notation, or ini‐
tialize it directly from a structured list of values.

*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*Array Types



An array type variable is denoted by a base type followed by the empty brackets, [].
Alternatively, Java accepts a C-style declaration with the brackets placed after the
array name. */
//The following are equivalent:
int [] arrayofInt ;  //preferred 
int arrayofInt []; // c style 

/*In each case, arrayOfInts is declared as an array of integers. The size of the array is
not yet an issue because we are declaring only the array type variable. We have not yet
created an actual instance of the array class, with its associated storage. It’s not even
possible to specify the length of an array when declaring an array type variable. The
size is strictly a function of the array object itself, not the reference to it.
 */

 //An array of reference types can be created in the same way:
 String []somestring ;
 Button []somebutton;


 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 //Array Creation and Initialization

 /*Thenew operator is used to create an instance of an array. After the new operator, we
specify the base type of the array and its length with a bracketed integer expression:
 */
arrayofInt = new int [20];
somestring = new String [30];
//We can, of course, combine the steps of declaring and allocating the array:
double [] someNumbers = new int [60];
Component []someComponents = new Component[20];

/*Array indices start with zero. Thus, the first element of someNumbers[] is 0, and the
last element is 19. After creation, the array elements are initialized to the default val‐
ues for their type. For numeric types, this means the elements are initially zero: */

int [] grades = new int [20];

grades[0] = 1;
grades[1] = 2;
//grades[2] == NULL;

/*The elements of an array of objects are references to the objects—just like individual
variables they point to—but do not actually contain instances of the objects. The
default value of each element is therefore null until we assign instances of appropri‐
ate objects: */

String [] name  = new String[30];
name[0]  = new String();
name[1] = "hahah haha oo";
name[2] = someObject.toString();
// names[3] == null

/*This is an important distinction that can cause confusion. In many other languages,
the act of creating an array is the same as allocating storage for its elements. In Java, a
newly allocated array of objects actually contains only reference variables, each with
the value null.
5
 That’s not to say that there is no memory associated with an empty
array; memory is needed to hold those references (the empty “slots” in the array).
Figure 4-3 illustrates the names array of the previous example.
names is a variable of type String[] (i.e., a string array). This particular String[]
object contains four String type variables. We have assigned String objects to the
first three array elements. The fourth has the default value null. */

//Java supports the C-style curly braces {} construct for creating an array and initializ‐
//ing its elements:
int [] primes = {1,2,3,4,5,6,9,8};   // e.g., primes[2] = 3


/*An array object of the proper type and length is implicitly created, and the values of
the comma-separated list of expressions are assigned to its elements. Note that we did
not use the new keyword or the array type here. The type of the array was inferred
from the assignment. 
We can use the {} syntax with an array of objects. In this case, each expression must
evaluate to an object that can be assigned to a variable of the base type of the array or
the value null. Here are some examples:*/

String []verbs = {"hhhhhaa","jump", someWord.toString()};
Button []controls = {stopButton, new Button("Forwards"),
new Button("Backwards")};
 // All types are subtypes of Object
 Object [] objects = { stopButton, "A word", null };

 //The following are equivalent:
 Button [] threeButtons = new Button [3];
 Button [] threeButtons = { null, null, null };

 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 //Using Arrays

//The size of an array object is available in the public variable length:

char [] alphabet = new char[26];
int alphalen = alphabet.length;  // alphaLen == 26


Stirng [] musketeers = {"one","two","three"};
int num = musketeers.length; //num == 3


//length is the only accessible field of an array; it is a variable, not a method.

/*Array access in Java is just like array access in other languages; you access an element
by putting an integer-valued expression between brackets after the name of the array.
The following example creates an array of Button objects called keyPad and then fills
the array with Button objects */
Button [] keyPad = new Button [ 10 ];
 for ( int i=0; i < keyPad.length; i++ )
 keyPad[ i ] = new Button( Integer.toString( i ) );


 /*Remember that we can also use the enhanced for loop to iterate over array values.
Here we’ll use it to print all the values we just assigned: */

for (Button b : keyPad)
 System.out.println(b);


 /*Attempting to access an element that is outside the range of the array generates an
ArrayIndexOutOfBoundsException. This is a type of RuntimeException, so you can
either catch and handle it yourself if you really expect it, or ignore it, as we will
 */

 /*Here’ a taste of the try/catch syntax Java uses to wrap such
potentially problematic code: */
String [] states = new String [50];
 try {
 states[0] = "California";
 states[1] = "Oregon";
 ...
 states[50] = "McDonald's Land"; // Error: array out of bounds
 }
 catch ( ArrayIndexOutOfBoundsException err ) {
 System.out.println( "Handled error: " + err.getMessage() );
 }
/*It’s a common task to copy a range of elements from one array into another. One way
to copy arrays is to use the low-level arraycopy() method of the System class:
 */
System.arraycopy( source, sourceStart, destination, destStart, length );

//The following example doubles the size of the names array from an earlier example:
String [] tmpVar = new String [ 2 * names.length ];
 System.arraycopy( names, 0, tmpVar, 0, names.length );
 names = tmpVar;
/*A new array, twice the size of names, is allocated and assigned to a temporary variable,
tmpVar. The arraycopy() method is then used to copy the elements of names to the
new array. Finally, the new array is assigned to names. If there are no remaining refer‐
ences to the old array object after names has been copied, it is garbage-collected on
the next pass. */

//An easier way is to use the java.util.ArrayscopyOf() and copyOfRange() methods:
byte [] bar = new byte[] { 1, 2, 3, 4, 5 };
 byte [] barCopy = Arrays.copyOf( bar, bar.length );
 // { 1, 2, 3, 4, 5 }
 byte [] expanded = Arrays.copyOf( bar, bar.length+2 );
 // { 1, 2, 3, 4, 5, 0, 0 }
 byte [] firstThree = Arrays.copyOfRange( bar, 0, 3 );
 // { 1, 2, 3 }
 byte [] lastThree = Arrays.copyOfRange( bar, 2, bar.length );
 // { 3, 4, 5 }
 byte [] lastThreePlusTwo = Arrays.copyOfRange( bar, 2, bar.length+2 );
 // { 3, 4, 5, 0, 0 }

 /*The copyOf() method takes the original array and a target length. If the target length
is larger than the original array length, then the new array is padded (with zeros or
nulls) to the desired length. The copyOfRange() takes a starting index (inclusive) and
an ending index (exclusive) and a desired length, which will also be padded if
necessary.
 */

 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Anonymous Arrays

/*Often it is convenient to create “throwaway” arrays, arrays that are used in one place
and never referenced anywhere else. Such arrays don’t need a name because you
never need to refer to them again in that context. For example, you may want to cre‐
ate a collection of objects to pass as an argument to some method. It’s easy enough to
create a normal, named array, but if you don’t actually work with the array (if you use
the array only as a holder for some collection), you shouldn’t need to do this. Java
makes it easy to create “anonymous” (i.e., unnamed) arrays.
Let’s say you need to call a method named setPets(), which takes an array of Animal
objects as arguments. Provided Cat and Dog are subclasses of Animal, here’s how to
call setPets() using an anonymous array: */
Dog pokey = new Dog ("gray");
 Cat boojum = new Cat ("grey");
 Cat simon = new Cat ("orange");
 setPets ( new Animal [] { pokey, boojum, simon });
/*The syntax looks similar to the initialization of an array in a variable declaration. We
implicitly define the size of the array and fill in its elements using the curly-brace
notation. However, because this is not a variable declaration, we have to explicitly use
the new operator and the array type to create the array object.
Anonymous arrays were sometimes used as a substitute for variable-length argument
lists to methods. Perhaps familiar to C programmers, a variable-length argument list
allows you to send an arbitrary amount of data to a method. An example might be a
method that calculates an average of a batch of numbers. You could put all the num‐
bers into one array, or you could allow your method to accept one or two or three or
many numbers as arguments. With the introduction of variable-length argument lists
in Java,6
, the usefulness of anonymous arrays has diminished. */