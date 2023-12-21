//Shadowing
/*If a local variable or method argument and an instance variable have the same name,
the local variable shadows or hides the name of the instance variable within the scope
of the method. This might sound like an odd situation, but it happens fairly often
when the instance variable has a common or obvious name. For example, we could
add a move method to our Apple class. Our method will need the new coordinate tell‐
ing us where to place the apple. An easy choice for the coordinate arguments would
be x and y. But we already have instance variables of the same name:
 */

 class Apple {
    int x, y;
    ...
    public void moveTo(int x, int y) {
    System.out.println("Moving apple to " + x + ", " + y);
    }
}   
/*If the apple is currently at position (20, 40) and we call moveTo(40, 50), what do you
think that println() statement will show? Inside moveTo(), the x and y names refer
only to the arguments with those names. Our output would be:

Moving apple to 40, 50


If we can’t get to the x and y instance variables, how can we move the apple? Turns
out Java understands shadowing and provides a mechanism for working around
these situations.
 */