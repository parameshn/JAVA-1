//Static Members
/*As we’ve said, instance variables and methods are associated with and accessed
through an instance of the class (i.e., through a particular object, like a1 or f in the
previous examples). In contrast, members that are declared with the static modifier
live in the class and are shared by all instances of the class. Variables declared with the
static modifier are called static variables or class variables; similarly, these kinds of
methods are called static methods or class methods. Static members are useful as flags
and identifiers, which can be accessed from anywhere. We can add a static variable to
our Apple example, maybe to store the value of acceleration due to gravity so we can
calculate the trajectory of a tossed apple when we start animating our game:
 */

 class Apple {
    ...
    static float gravAccel = 9.8f;
    ...}

    /*We have declared the new float variable gravAccel as static. That means that it is
associated with the class, not with an individual instance, and if we change its value
(either directly or through any instance of Apple), the value changes for all Apple
objects,

Static members can be accessed like instance members. Inside our Apple class, we can
refer to gravAccel like any other variable:
*/

class Apple {
    ...
    float getWeight () {
    return mass * gravAccel;
    }
    ...
    }

    /*However, since static members exist in the class itself, independent of any instance,
we can also access them directly through the class. If we want to toss apples on Mars,
for example, we don’t need an Apple object like a1 or a2 to get or set the variable
gravAccel. Instead, we can use the class to select the variable:
 */

 Apple.gravAccel = 3.7;


 /*This changes the value of gravAccel as seen by all instances. We don’t have to man‐
ually set each instance of Apple to fall on Mars. Static variables are useful for any kind
of data that is shared among classes at runtime. For instance, you can create methods
to register your object instances so that they can communicate, or so that you can
keep track of all of them. It’s also common to use static variables to define constant
values. In this case, we use the static modifier along with the final modifier. So, if
we cared only about apples under the influence of the Earth’s gravitational pull, we
might change Apple as follows: */

class Apple {
    ...
    static final float EARTH_ACCEL = 9.8f;
    ...}

    /*We have followed a common convention here and named our constant with capital
letters and underscores (if the name has more than one word). The value of
EARTH_ACCEL is a constant; it can be accessed through the class Apple or its instances,
but its value can’t be changed at runtime.
It’s important to use the combination of static and final only for things that are
really constant. The compiler is allowed to “inline” such values within classes that ref‐
erence them. This means that if you change a static final variable, you may have
to recompile all code that uses that class (this is really the only case where you have to
do that in Java). Static members are also useful for values needed in the construction
of an instance itself. In our example, we might declare a number of static values to
represent various sizes of Apple objects:
 */

 class Apple {
    ...
    static int SMALL = 0, MEDIUM = 1, LARGE = 2;
    ...}

    /*We might then use these options in a method that sets the size of an Apple, or in a
special constructor, as we’ll discuss shortly: */

Apple typicalApple = new Apple();
 typicalApple.setSize( Apple.MEDIUM );

 /*Again, inside the Apple class, we can use static members directly by name, as well;
there’s no need for the Apple. prefix: */

class Apple {
    ...
    void resetEverything() {
    setSize ( MEDIUM );
    ...
    }
    ...
    }
   