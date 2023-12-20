//Accessing Fields and Methods
/*Once you have a reference to an object, you can use and manipulate its variables and
methods using the dot notation we saw in Chapter 4. Let’s create a new class, PrintAp
pleDetails2, provide some values for the mass and position of our a1 instance, and
then print the new details:
 */
package ch05;
public class PrintAppleDetails2 {
 public static void main(String args[]) {
 Apple a1 = new Apple();
 System.out.println("Apple a1:");
 System.out.println(" mass: " + a1.mass);
 System.out.println(" diameter: " + a1.diameter);
 System.out.println(" position: (" + a1.x + ", " + a1.y +")");
 // fill in some information on a1
 a1.mass = 10.0f;
 a1.x = 20;
 a1.y = 42;
 System.out.println("Updated a1:");
 System.out.println(" mass: " + a1.mass);
 System.out.println(" diameter: " + a1.diameter);
 System.out.println(" position: (" + a1.x + ", " + a1.y +")");
 }
}

//package ch05;
public class PrintAppleDetails2 {
    public static void main(String args[]) {
    Apple a1 = new Apple();
    System.out.println("Apple a1:");
    System.out.println(" mass: " + a1.mass);
    System.out.println(" diameter: " + a1.diameter);
    System.out.println(" position: (" + a1.x + ", " + a1.y +")");
    // fill in some information on a1
    a1.mass = 10.0f;
    a1.x = 20;
    a1.y = 42;
    System.out.println("Updated a1:");
    System.out.println(" mass: " + a1.mass);
    System.out.println(" diameter: " + a1.diameter);
    System.out.println(" position: (" + a1.x + ", " + a1.y +")");
    }
   }
   //We could improve the Apple class to provide these printstatements:



   public class Apple {
    float mass;
    float diameter = 1.0f;
    int x, y;

    public void PrintAppleDetails(){
        System.out.println(" mass: " + mass);
        System.out.println(" diameter: " + diameter);
        System.out.println(" position: (" + x + ", " + y +")");
    }

}
/*With those detail statements relocated, we can create PrintAppleDetails3 more suc‐
cinctly than its predecessor: */

public class PrintAppleDetails3(){
    public static void main(String args[]){
        Apple a1 = new Apple();
        System.out.println("Apple a1:");
 a1.printDetails();
 // fill in some information on a1
 a1.mass = 10.0f;
 a1.x = 20;
 a1.y = 42;
 System.out.println("Updated a1:");
 a1.printDetails();

    }
}

/*Take another look at the printDetails() method we added to the Apple class. Inside
a class, we can access variables and call methods of the class directly by name. The
print statements just use the simple names like mass and diameter. Or consider fill‐
ing out the isTouching() method. We can use our own x and y coordinates without
any special prefix. But to access the coordinates of some other apple, we need to go
back to the dot notation.  */


public boolean isTouching(Apple other) {
 double xdiff = x - other.x;
 double ydiff = y - other.y;
 double distance = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
 if (distance < diameter / 2 + other.diameter / 2) {
 return true;
 } else {
 return false;
 }
 }


 /*Let’s fill out a bit more of our game and create our Field class that uses a few Apple
objects. It creates instances as member variables and works with those objects in the
setupApples() and detectCollision() methods, invoking Apple methods and
accessing variables of those objects through the references a1 and a2, visualized in */

public class Field {
    Apple a1 = new Apple();
    Apple a2 = new Apple();

    public void setupApples(){
        a1.diameter = 3.0f;
        a1.mass = 5.0f;
        a1.x = 20;
        a1.y = 40;
        a2.diameter = 8.0f;
        a2.mass = 10.0f;
        a2.x = 70;
        a2.y = 200;
    }


public void detectCollision(){
    if (a1.isTouching(a2)){
        System.out.println("collision detected!");

    }else {
        System.out.println("Aples are not touching ");

    }
}}

/*We can prove that Field has access to the apples’ variables and methods with another
iteration of our application, PrintAppleDetails4:
 */

 public class PrintAppleDetails4 {
    public static void main(String args[]) {
    Field f = new Field();
    f.setupApples();
    System.out.println("Apple a1:");
    f.a1.printDetails();
    System.out.println("Apple a2:");
    f.a2.printDetails();
    f.detectCollisions();
    }
   }