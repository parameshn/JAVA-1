/*Inheritance
Java classes are arranged in a parent-child hierarchy in which the parent and child are
known as the superclass and subclass, respectively. We’ll explore these concepts more
in Chapter 5. In Java, every class has exactly one superclass (a single parent), but pos‐
sibly many subclasses. The only exception to this rule is the Object class, which sits
atop the entire class hierarchy; it has no superclass.
The declaration of our class in the previous example uses the keyword extends to
specify that HelloComponent is a subclass of the JComponent class: */

// public class HelloComponent extends JComponent {}

/*A subclass may inherit some or all the variables and methods of its superclass.
Through inheritance, the subclass can use those variables and methods as if it has
declared them itself. A subclass can add variables and methods of its own, and it can
also override or change the meaning of inherited methods. When we use a subclass,
overridden methods are hidden (replaced) by the subclass’s own versions of them. In
this way, inheritance provides a powerful mechanism whereby a subclass can refine
or extend the functionality of its superclass. */

/*For example, the hypothetical spreadsheet class might be subclassed to produce a new
scientific spreadsheet class with extra mathematical functions and special built-in
constants. In this case, the source code for the scientific spreadsheet might declare
methods for the added mathematical functions and variables for the special con‐
stants, but the new class automatically has all the variables and methods that consti‐
tute the normal functionality of a spreadsheet; they are inherited from the parent
spreadsheet class. This also means that the scientific spreadsheet maintains its iden‐
tity as a spreadsheet, and we can use the extended version anywhere the simpler
spreadsheet could be used. That last sentence has profound implications, which we’ll
explore throughout the book. It means that specialized objects can be used in place of
more generic objects, customizing their behavior without changing the underlying
application. This is called polymorphism and is one of the foundations of objectoriented programming.
Our HelloComponent class is a subclass of the JComponent class and inherits many
variables and methods not explicitly declared in our source code. This is what allows
our tiny class to serve as a component in a JFrame, with just a few customizations.
 */