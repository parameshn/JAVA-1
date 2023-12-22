//The “this” reference

/*You can use the special reference this any time you need to refer explicitly to the cur‐
rent object or a member of the current object. Often you don’t need to use this,
because the reference to the current object is implicit; such is the case when using
unambiguously named instance variables inside a class. But we can use this to refer
explicitly to instance variables in our object, even if they are shadowed. The following
example shows how we can use this to allow argument names that shadow instance
variable names. This is a fairly common technique because it saves having to make up
alternative names. Here’s how we could implement our moveTo() method with shad‐
owed variables: */

class Apple {
    int x, y;
    ...
    public void moveTo(int x, int y) {
    System.out.println("Moving apple to " + x + ", " + y);
    this.x = x;
    if (y > diameter / 2) {
    this.y = y;
    } else {
    this.y = (int)(diameter / 2);
    }
    }
    ...
    }

    /*In this example, the expression this.x refers to the instance variable x and assigns it
the value of the local variable x, which would otherwise hide its name. We do the
same for this.y but add a little protection to make sure we don’t move the apple
below our ground. The only reason we need to use this in the previous example is
because we’ve used argument names that hide our instance variables, and we want to
refer to the instance variables. You can also use the this reference any time you want
to pass a reference to “the current” enclosing object to some other method like we did
for the graphical version of our “Hello Java” application */