//Classes

/*Classes are the building blocks of a Java application. A class can contain methods
(functions), variables, initialization code, and, as we’ll discuss later, other classes. Sep‐
arate classes that describe individual parts of a more complex idea are often bundled
in packages, which help you organize larger projects. (Every class belongs to some
package, even the simple examples we’ve seen so far.) An interface can describe some
specific commonalities between otherwise disparate classes. Classes can be related to
each other by extension or to interfaces by implementation. Figure 5-1 illustrates the
ideas in this very dense paragraph.
 */

 /*In this figure, you can see the Object class in the upper-left corner. Object is the
foundational class at the heart of every other class in Java. It is part of the core Java
package, java.lang. Java also has a package for its graphical UI elements called
javax.swing. Inside that package the JComponent class defines all of the low-level,
common properties of graphical things like frames and buttons and canvases. The
JLabel class, for example, extends the JComponent class. That means JLabel inherits
details from JComponent but adds things specific to labels. You might have noticed
that JComponent itself extends from Object, or at least, it eventually extends back to
Object. For brevity’s sake we left out the intermediate classes and packages in
betweenWe can define our own classes and packages as well. The ch05 package in the lower right corner is a custom package we built. In it, we have our game classes like Apple
and Field. You can also see the GamePiece interface that will contain some common,
 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*A class serves as a blueprint for making instances, which are runtime objects (individ‐
ual copies) that implement the class structure. You declare a class with the class key‐
word and a name of your choosing. For example, our game allows physicists to throw
apples at trees. Each of the nouns in that sentence are good targets for becoming
classes. Inside a class, we add variables that store details or other useful information,
and methods that describe what we can do to and with instances of this class.

Let’s get started with a class for our apples. By (strong!) convention, class names start
with capital letters. That makes the word “Apple” a good name to use. We won’t try to
get everything we need to know about our game apples into the class right away, just a
few elements to help illustrate how a class, variables, and methods fit together. */



 //Declaring and Instantiating Classes
 package ch05;
class Apple {
 float mass;
 float diameter = 1.0f;
 int x, y;
 boolean isTouching(Apple other) {
 ...
 }
 ...
}
/*The Apple class contains four variables: mass, diameter, x, and y. It also defines a
method called isTouching(), which takes a reference to another Apple as an argu‐
ment and returns a boolean value as a result. Variables and method declarations can
appear in any order, but variable initializers can’t make “forward references” to other
variables that appear later. (In our little snippet, the diameter variable could use the
mass variable to help calculate its initial value, but mass could not use the diameter
variable to do the same.) Once we’ve defined the Apple class, we can create an Apple
object (an instance of that class) as follows: */


    Apple a1;
    a1 = new Apple();
    // Or all in one line...

    Apple a2 = new Apple();

    /*Recall that our declaration of the variable a1 doesn’t create an Apple object; it simply
creates a variable that refers to an object of type Apple. We still have to create the
object, using the new keyword, as shown in the second line of the preceding code
snippet. But you can combine those steps into a single line as we did for the a2 vari‐
able. The same separate actions occur under the hood, of course. Sometimes the com‐
bined declaration and initialization will feel more readable */


/*Now that we’ve created an Apple object, we can access its variables and methods, as
we’ve seen in several of our examples from Chapter 4 or even our graphical “Hello”
app from “HelloJava” on page 41. While not very exciting, we could now build
another class, PrintAppleDetails, that is a complete application to create an Apple
instance, and print its details: */

public class PrintAppleDetails{
    public static void main(Strin args[]){
        Apple a3 = new Apple();
        
        System.out.println("Apple a1 :");
        System.out.println("mass"+a3.mass);
        System.out.println("diameter"+a3.diameter);
        System.out.println("position ("+a3.x","+a3.y+")");

    }
}

/*If you compile and run this example, you should see the following output in your ter‐
minal or in the terminal window of your IDE:
Apple a1:
 mass: 0.0
 diameter: 1.0
 position: (0, 0)
But hmm, why don’t we have a mass? If you look back at how we declared the vari‐
ables for our Apple class, we only initialized diameter. All the other variables will get
the Java-assigned default value of 0 since they are numeric types. (Quickly, boolean
variables get a default of false and reference types get a default of null.) We would
ideally like to have a more interesting apple. Let’s see how to provide those interesting 
bits. */


