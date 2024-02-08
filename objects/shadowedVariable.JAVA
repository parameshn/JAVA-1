/*Shadowed variables
We have seen that a local variable of the same name as an instance variable shadows
(hides) the instance variable. Similarly, an instance variable in a subclass can shadow
an instance variable of the same name in its parent class, */

/*the variable weight is declared in three places: as a local variable in the
method foodConsumption() of the class Mammal, as an instance variable of the class
Mammal, and as an instance variable of the class Animal. The actual variable selected
when you reference it in the code would depend on the scope in which we are work‐
ing and how you qualify the reference to it.
 */

 /*In the previous example, all variables were of the same type. A slightly more plausible
use of shadowed variables would involve changing their types. We could, for example,
shadow an int variable with a double variable in a subclass that needs decimal values
instead of integer values. We can do this without changing the existing code because,
as its name suggests, when we shadow variables, we don’t replace them but instead
mask them. Both variables still exist; methods of the superclass see the original vari‐
able, and methods of the subclass see the new version. The determination of what
variables the various methods see occurs at compile time.
 */

 //Here’s a simple example:
 class IntegerCalculator {
 int sum;
 ...
 }
 class DecimalCalculator extends IntegerCalculator {
 double sum;
 ...
 }

 /*In this example, we shadow the instance variable sum to change its type from int to
double.
6
 Methods defined in the class IntegerCalculator see the integer variable
sum, while methods defined in DecimalCalculator see the floating-point variable
sum. However, both variables actually exist for a given instance of DecimalCalcula
tor, and they can have independent values. In fact, any methods that DecimalCalcu
lator inherits from IntegerCalculator actually see the integer variable sum.

Because both variables exist in DecimalCalculator, we need a way to reference the
variable inherited from IntegerCalculator. We do that using the super keyword as
a qualifier on the reference: */
int s = super.sum;


/*Inside of DecimalCalculator, the super keyword used in this manner selects the sum
variable defined in the superclass. We’ll explain the use of super more fully in a bit.


Another important point about shadowed variables has to do with how they work
when we refer to an object by way of a less derived type (a parent type). For example,
we can refer to a DecimalCalculator object as an IntegerCalculator by using it via
a variable of type IntegerCalculator. If we do so and then access the variable sum,
we get the integer variable, not the decimal one: */

DecimalCalculator dc = new DecimalCalculator();
 IntegerCalculator ic = dc;
 int s = ic.sum; // accesses IntegerCalculator sum

 /*The same would be true if we accessed the object using an explicit cast to the Integer
Calculator type or when passing an instance into a method that accepts that parent
type.

To reiterate, the usefulness of shadowed variables is limited. It’s much better to
abstract the use of variables like this in other ways than to use tricky scoping rules.
However, it’s important to understand the concepts here before we talk about doing
the same thing with methods. We’ll see a different and more dynamic type of behav‐
ior when methods shadow other methods, or to use the correct terminology, override
other methods. */