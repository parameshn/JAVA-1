//Reference Types
/* 
In an object-oriented language like Java, you create new, complex data types from
simple primitives by creating a class. Each class then serves as a new type in the lan‐
guage. For example, if we create a new class called Foo in Java, we are also implicitly
creating a new type called Foo. The type of an item governs how it’s used and where it
can be assigned. As with primitives, an item of type Foo can, in general, be assigned to
a variable of type Foo or passed as an argument to a method that accepts a Foo value. */


/*A type is not just a simple attribute. Classes can have relationships with other classes
and so do the types that they represent. All classes in Java exist in a parent-child hier‐
archy, where a child class or subclass is a specialized kind of its parent class. The cor‐
responding types have the same relationship, where the type of the child class is
considered a subtype of the parent class. Because child classes inherit all of the func‐
tionality of their parent classes, an object of the child’s type is in some sense equiva‐
lent to or an extension of the parent type. An object of the child type can be used in
place of an object of the parent’s type. For example, if you create a new class, Cat, that
extends Animal, the new type, Cat, is considered a subtype of Animal. Objects of type
Cat can then be used anywhere an object of type Animal can be used; an object of type
Cat is said to be assignable to a variable of type Animal. This is called subtype poly‐
morphism and is one of the primary features of an object-oriented language. */

/*Primitive types in Java are used and passed “by value.” In other words, when a primi‐
tive value like an int is assigned to a variable or passed as an argument to a method,
its value is simply copied. Reference types (class types), on the other hand, are always
accessed “by reference.” A reference is a handle or a name for an object. What a vari‐
able of a reference type holds is a “pointer” to an object of its type (or of a subtype, as
described earlier). When the reference is assigned to a variable or passed to a method,
only the reference is copied, not the object to which it’s pointing. A reference is like a
pointer in C or C++, except that its type is strictly enforced. The reference value itself
can’t be explicitly created or changed. A variable acquires a reference value only
through assignment to an appropriate object. */

/*Let’s run through an example. We declare a variable of type Foo, called myFoo, and
assign it an appropriate object:2 */

Foo myFoo = new Foo();
 Foo anotherFoo = myFoo;

 /*myFoo is a reference-type variable that holds a reference to the newly constructed Foo
object. (For now, don’t worry about the details of creating an object; again, we’ll cover
that in Chapter 5.) We declare a second Foo type variable, anotherFoo, and assign it
to the same object. There are now two identical references : myFoo and anotherFoo,
but only one actual Foo object instance. If we change things in the state of the Foo */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Passing References
/*Object references are passed to methods in the same way. In this case, either myFoo or
anotherFoo would serve as equivalent arguments */

myMethod( myFoo );
/*An important, but sometimes confusing, distinction to make at this point is that the
reference itself is a value and that value is copied when it is assigned to a variable or
passed in a method call. Given our previous example, the argument passed to a
method (a local variable from the method’s point of view) is actually a third reference
to the Foo object, in addition to myFoo and anotherFoo. The method can alter the
state of the Foo object through that reference (calling its methods or altering its vari‐
ables), but it can’t change the caller’s notion of the reference to myFoo: that is, the
method can’t change the caller’s myFoo to point to a different Foo object; it can change
only its own reference. This will be more obvious when we talk about methods later.
Java differs from C++ in this respect. If you need to change a caller’s reference to an
object in Java, you need an additional level of indirection. The caller would have to
wrap the reference in another object so that both could share the reference to it. */

/*Reference types always point to objects (or null), and objects are always defined by
classes. Similar to native types, instance or class variables that are not explicitly ini‐
tialized when they are declared will be assigned the default value of null. Also, like
native types, local variables that have a reference type are not initialized by default so
you must set your own value before using them. However, two special kinds of refer‐
ence types—arrays and interfaces—specify the type of object they point to in a
slightly different way.

Arrays in Java have a special place in the type system. They are a special kind of object
automatically created to hold a collection of some other type of object, known as the
base type. Declaring an array type reference implicitly creates the new class type
designed as a container for its base type, as you’ll see later in this chapter.
Interfaces are a bit sneakier. An interface defines a set of methods and gives it a corre‐
sponding type. An object that implements the methods of the interface can be
referred to by that interface type, as well as its own type. Variables and method argu‐
ments can be declared to be of interface types, just like other class types, and any
object that implements the interface can be assigned to them. This adds flexibility in
the type system and allows Java to cross the lines of the class hierarchy and make
objects that effectively have many types. We’ll cover interfaces in the next chapter as
well.

Generic types or parameterized types, as we mentioned earlier, are an extension of the
Java class syntax that allows for additional abstraction in the way classes work with
other Java types. Generics allow for specialization of classes by the user without
changing any of the original class’s code. */