/*A local variable is temporary; it exists only within the scope (the
block) of its method. Local variables are allocated when a method is invoked; they are
normally destroyed when the method returns.

They can’t be referenced from outside
the method itself. If the method is executing concurrently in different threads, each
thread has its own version of the method’s local variables.

A method’s arguments also
serve as local variables within the scope of the method; the only difference is that they
are initialized by being passed in from the caller of the method.

An object created within a method and assigned to a local variable may or may not
persist after the method has returned.
*/






//Initializing Local Variables
/*Unlike instance variables that receive default values if we don’t provide an explicit
one, local variables must be initialized before they can be used. It’s a compile-time
error to try to access a local variable without first assigning it a value */

int foo;
 void myMethod() {
 int bar;
 foo += 1; // This is ok, foo has the default 0
 bar += 1; // compile-time error, bar is uninitialized
 bar = 99;
 bar += 1; // Now this calculation would be ok
 }

 //Notice that this doesn’t imply local variables have to be initialized when declared,
 // just that the first time they are referenced must be in an assignment.


 //More subtle possibilities arise when making assignments inside conditionals:

 void myMethod {
    int bar;
    if ( someCondition ) {
    bar = 42;
    ...
    }
    bar += 1; // Still a compile-time error, foo may not be initialized
    }
    /*In this example, bar is initialized only if someCondition is true. The compiler doesn’t
let you make this wager, so it flags the use of bar as an error. We could correct this
situation in several ways */

//We could initialize the variable to a default value in advance or move the usage inside the conditional

/*We could also make sure the path of execu‐
tion doesn’t reach the uninitialized variable through some other means, depending on
what makes sense for our particular application.
For example, 

we could simply make
sure that we assign bar a value in both the if and else branch.
or 
we could return
from the method abruptly:  */
void myMethod {
    int bar;
    ...
    if ( someCondition ) {
        bar = 42;
        ...
        } else {
        return;
        }
        bar += 1; // This is ok!
        ...
        }   

        /*In this case, there’s no chance of reaching bar in an uninitialized state, so the com‐
piler allows the use of bar after the conditional.
 */