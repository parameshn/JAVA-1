/*A natural-born thread
The Runnable interface lets us make an arbitrary object the target of a thread, as we
did in the previous example. This is the most important general usage of the Thread
class. In most situations in which you need to use threads, you’ll create a class (possi‐
bly a simple adapter class) that implements the Runnable interface.

However, we’d be remiss not to show you the other technique for creating a thread.
Another design option is to make our target class a subclass of a type that is already
runnable. As it turns out, the Thread class itself conveniently implements the Runna
ble interface; it has its own run() method, which we can override directly to do our
bidding:*/
class Animator extends Thread {
 boolean animating = true;
 public void run() {
 while ( animating ) {
 // draw Frames
 ...
 }
 }
 }

 /*The skeleton of our Animator class looks much the same as before, except that our
class is now a subclass of Thread. To go along with this scheme, the default construc‐
tor of the Thread class makes itself the default target—that is, by default, the Thread
executes its own run() method when we call the start() method, as shown in
Figure 9-2. Now our subclass can just override the run() method in the Thread class.
(Thread itself defines an empty run() method.)
*/

/*Next, we create an instance of Animator and call its start() method (which it also
inherited from Thread):
 
*/
Animator bouncy = new Animator();
 bouncy.start();

 //Alternatively, we can have the Animator object start its thread when it is created:
Animator bouncy = new Animator();
 bouncy.start();
 class Animator extends Thread {
 Animator () {
 start();
 }
 ...
 }

 /*Here, our Animator object just calls its own start() method when an instance is cre‐
ated. (It’s probably better form to start and stop our objects explicitly after they’re cre‐
ated rather than starting threads as a hidden side effect of object creation, but this
serves the example well.)Subclassing Thread may seem like a convenient way to bundle a thread and its target
run() method. However, this approach often isn’t the best design. If you subclass
Thread to implement a thread, you are saying you need a new type of object that is a
kind of Thread, which exposes all of the public API of the Thread class. While there is
something satisfying about taking an object that’s primarily concerned with perform‐
ing a task and making it a Thread, the actual situations where you’ll want to create a
subclass of Thread should not be very common. In most cases, it is more natural to
let the requirements of your program dictate the class structure and use Runnables to
connect the execution and logic of your program.
8?