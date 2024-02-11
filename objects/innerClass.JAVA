//inner class 

/*All of the classes we’ve seen so far in this book have been top-level, “freestanding”
classes declared at the file and package level. But classes in Java can actually be
declared at any level of scope, within any set of curly braces (i.e., almost anywhere
that you could put any other Java statement). These inner classes belong to another
class or method as a variable would and may have their visibility limited to its scope
in the same way. Inner classes are a useful and aesthetically pleasing facility for struc‐
turing code. Their cousins, anonymous inner classes, are an even more powerful
shorthand that make it seem as if you can create new kinds of objects dynamically
within Java’s statically typed environment. In Java, anonymous inner classes play part
of the role of closures in other languages, giving the effect of handling state and
behavior independently of classes.
 */

 /*However, as we delve into their inner workings, we’ll see that inner classes are not
quite as aesthetically pleasing or dynamic as they seem. Inner classes are pure syntac‐
tic sugar; they are not supported by the VM and are instead mapped to regular Java
classes by the compiler. As a programmer, you may never need be aware of this; you
can simply rely on inner classes like any other language construct. However, you
should know a little about how inner classes work to better understand the compiled
code and a few potential side effects.
Inner classes are essentially nested classes. For example: */

Class Animal {
    Class Brain {
    ...
    }
    }

    /*Here, the class Brain is an inner class: it is a class declared inside the scope of class
Animal. Although the details of what that means require a bit of explanation, we’ll
start by saying that Java tries to make the meaning, as much as possible, the same as
for the other members (methods and variables) living at that level of scope. For exam‐
ple, let’s add a method to the Animal class: */

Class Animal {
    Class Brain {
    ...
    }
    void performBehavior() { ... }
    }
   

    /*Both the inner class Brain and the method performBehavior() are within the scope
of Animal. Therefore, anywhere within Animal, we can refer to Brain and performBe
havior() directly, by name. Within Animal, we can call the constructor for Brain
(new Brain()) to get a Brain object or invoke performBehavior() to carry out that
method’s function. But neither Brain nor performBehavior() are generally accessible
outside of the class Animal without some additional qualification. */

/*Within the body of the inner Brain class and the body of the performBehavior()
method, we have direct access to all the other methods and variables of the Animal
class. So, just as the performBehavior() method could work with the Brain class and
create instances of Brain, methods within the Brain class can invoke the performBe
havior() method of Animal as well as work with any other methods and variables
declared in Animal. The Brain class “sees” all of the methods and variables of the Ani
mal class directly in its scope. */

/*That last bit has important consequences. From within Brain, we can invoke the
method performBehavior(); that is, from within an instance of Brain, we can invoke
the performBehavior() method of an instance of Animal. Well, which instance of Ani
mal? If we have several Animal objects around (say, a few Cats and Dogs), we need to
know whose performBehavior() method we are calling. What does it mean for a
class definition to be “inside” another class definition? The answer is that a Brain
object always lives within a single instance of Animal: the one that it was told about
when it was created. We’ll call the object that contains any instance of Brain its
enclosing instance */

/*A Brain object cannot live outside of an enclosing instance of an Animal object. Any‐
where you see an instance of Brain, it will be tethered to an instance of Animal.
Although it is possible to construct a Brain object from elsewhere (i.e., another class),
Brain always requires an enclosing instance of Animal to “hold” it. We’ll also say now
that if Brain is to be referred to from outside of Animal, it acts something like an
Animal.Brain class. And just as with the performBehavior() method, modifiers can
be applied to restrict its visibility. All of the usual visibility modifiers apply, and inner
classes can also be declared static, as we’ll discuss later. */