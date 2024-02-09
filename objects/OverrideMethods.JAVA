/*Overriding methods



We have seen that we can declare overloaded methods (i.e., methods with the same
name but a different number or type of arguments) within a class. Overloaded
method selection works in the way we described on all methods available to a class,
including inherited ones. This means that a subclass can define additional overloaded
methods that add to the overloaded methods provided by a superclass.
 */

/*A subclass can do more than that; it can define a method that has exactly the same
method signature (name and argument types) as a method in its superclass. In that
case, the method in the subclass overrides the method in the superclass and effectively
replaces its implementation, */

//Overriding methods to change the behavior of objects is called subtype polymorphism.


/*From what you’ve seen so far, overridden methods probably look like they shadow
methods in superclasses, just as variables do. But overridden methods are actually
more powerful than that. When there are multiple implementations of a method in
the inheritance hierarchy of an object, the one in the “most derived” class (the fur‐
thest down the hierarchy) always overrides the others, even if we refer to the object
through a reference of one of the superclass types. */

/*For example, if we have a Cat instance assigned to a variable of the more general type
Animal, and we call its sleep() method, we still get the sleep() method imple‐
mented in the Cat class, not the one in Animal:
 */

 Cat simon = new Cat();
 Animal creature = simon;
 ...
 creature.sleep(); // accesses Cat sleep();


 /*In other words, for purposes of behavior (invoking methods), a Cat acts like a Cat,
regardless of whether you refer to it as such. In other respects, the variable creature
here may behave like an Animal reference. As we explained earlier, access to a shad‐
owed variable through an Animal reference would find an implementation in the Ani
mal class, not the Cat class. However, because methods are located dynamically,
searching subclasses first, the appropriate method in the Cat class is invoked, even
though we are treating it more generally as an Animal object. This means that the
behavior of objects is dynamic. We can deal with specialized objects as if they were
more general types and still take advantage of their specialized implementations of 
behavior. */