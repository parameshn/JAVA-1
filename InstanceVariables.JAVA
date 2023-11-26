//Instance Variables

//We have added some variables to the HelloComponent2 class in our example:

int mesageX = 125, messageY = 95;
string theMessage;

/*messageX and messageY are integers that hold the current coordinates of our movable
message. We have crudely initialized them to default values that should place the
message somewhere near the center of the window. Java integers are 32-bit signed
numbers, so they can easily hold our coordinate values. The variable theMessage is of
type String and can hold instances of the String class.
You should note that these three variables are declared inside the braces of the class
definition, but not inside any particular method in that class. These variables are
called instance variables, and they belong to the object as a whole. Specifically, copies
of them appear in each separate instance of the class. Instance variables are always
visible to (and usable by) all the methods inside their class. Depending on their modi‐
fiers, they may also be accessible from outside the class.
Unless otherwise initialized, instance variables are set to a default value of 0, false, or
null, depending on their type. Numeric types are set to 0, Boolean variables are set to
false, and class type variables always have their value set to null, which means “no
value.” Attempting to use an object with a null value results in a runtime error.
Instance variables differ from method arguments and other variables that are
declared inside the scope of a particular method. The latter are called local variables.
They are effectively private variables that can be seen only by code inside a method or
other code block. Java doesn’t initialize local variables, so you must assign values
yourself. If you try to use a local variable that has not yet been assigned a value, your
code generates a compile-time error. Local variables live only as long as the method is
executing and then disappear, unless something else saves their value. Each time the
method is invoked, its local variables are recreated and must be assigned values.
We have used the new variables to make our previously stodgy paintComponent()
method more dynamic. Now all the arguments in the call to drawString() are deter‐
mined by these variables. */