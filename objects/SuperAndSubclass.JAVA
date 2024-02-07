//Subclassing

/*Classes in Java exist in a hierarchy. A class in Java can be declared as a subclass of
another class using the extends keyword. A subclass inherits variables and methods
from its superclass and can use them as if they were declared within the subclass itself:
 */

 class Animal {
    float weight;
    ...
    void eat() {
    ...
    }
    ...
    }

    class Mammal extends Animal {
        // inherits weight
        int heartRate;
        ...
        // inherits eat()
        void breathe() {
        ...
        }
        }

        /*In this example, an object of type Mammal has both the instance variable weight and
the method eat(). They are inherited from Animal.


A class can extend only one other class. To use the proper terminology, Java allows
single inheritance of class implementation. Later in this chapter, we’ll talk about inter‐
faces, which take the place of multiple inheritance as it’s primarily used in other
languages.


A subclass can be further subclassed. Normally, subclassing specializes or refines a
class by adding variables and methods (you cannot remove or hide variables or meth‐
ods by subclassing). For example: */

class Cat extends Mammal {
    // inherits weight and heartRate
    boolean longHair;
    ...
    // inherits eat() and breathe()
    void purr() {
    ...
    }
    }

    /*The Cat class is a type of Mammal that is ultimately a type of Animal. Cat objects
inherit all the characteristics of Mammal objects and, in turn, Animal objects. Cat also
provides additional behavior in the form of the purr() method and the longHair
variable */

/*A subclass inherits all members of its superclass not designated as private. As we’ll
discuss shortly, other levels of visibility affect which inherited members of the class
can be seen from outside of the class and its subclasses, but at a minimum, a subclass
always has the same set of visible members as its parent. For this reason, the type of a
subclass can be considered a subtype of its parent, and instances of the subtype can be
used anywhere instances of the supertype are allowed. Consider the following
example: */

Cat simon = new Cat();
 Animal creature = simon;


 /*The Cat instance simon in this example can be assigned to the Animal type variable
creature because Cat is a subtype of Animal. Similarly, any method accepting an Ani
mal object would accept an instance of a Cat or any Mammal type as well. This is an
important aspect of polymorphism in an object-oriented language such as Java. We’ll
see how it can be used to refine a class’s behavior, as well as add new capabilities to it. */