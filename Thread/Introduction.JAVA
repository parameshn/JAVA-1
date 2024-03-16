//Introducing Threads

/*Conceptually, a thread is a flow of control within a program. A thread is similar to the
more familiar notion of a process, except that threads within the same application are
much more closely related and share much of the same state. It’s kind of like a golf
course, which many golfers use at the same time. The threads cooperate to share a
working area. They have access to the same objects, including static and instance
variables, within their application. However, threads have their own copies of local
variables, just as players share the golf course but do not share some personal items
like clubs and balls.

Multiple threads in an application have the same problems as the golfers—in a word,
synchronization. Just as you can’t have two sets of players blindly playing the same
green at the same time, you can’t have several threads trying to access the same vari‐
ables without some kind of coordination. Someone is bound to get hurt. A thread can
reserve the right to use an object until it’s finished with its task, just as a golf party
gets exclusive rights to the green until it’s done. And a thread that is more important
can raise its priority, asserting its right to play through.

The devil is in the details, of course, and those details have historically made threads
difficult to use. Fortunately, Java makes creating, controlling, and coordinating
threads simpler by integrating some of these concepts directly into the language.
It is common to stumble over threads when you first work with them because creat‐
ing a thread exercises many of your new Java skills all at once. You can avoid confu‐
sion by remembering that two players are always involved in running a thread: a Java
language Thread object that represents the thread itself and an arbitrary target object
that contains the method that the thread is to execute. Later, you will see that it is pos‐
sible to play some sleight of hand and combine these two roles, but that special case
just changes the packaging, not the relationship. */

/*The Thread Class and the Runnable Interface
All execution in Java is associated with a Thread object, beginning with a “main”
thread that is started by the Java VM to launch your application. A new thread is born
when we create an instance of the java.lang.Thread class. The Thread object
represents a real thread in the Java interpreter and serves as a handle for controlling
and coordinating its execution. With it, we can start the thread, wait for it to com‐
plete, cause it to sleep for a time, or interrupt its activity. The constructor for the
Thread class accepts information about where the thread should begin its execution.
Conceptually, we would like to simply tell it what method to run. There are a number
of ways to do this; Java 8 allows method references that would do the trick. Here we
will take a short detour and use the java.lang.Runnable interface to create or mark
an object that contains a “runnable” method. Runnable defines a single, generalpurpose run() method:
 */
public interface Runnable {
    abstract public void run();
    }

    /*Every thread begins its life by executing the run() method in a Runnable object,
which is the “target object” that was passed to the thread’s constructor. The run()
method can contain any code, but it must be public, take no arguments, have no
return value, and throw no checked exceptions.
Any class that contains an appropriate run() method can declare that it implements
the Runnable interface. An instance of this class is then a runnable object that can
serve as the target of a new thread. If you don’t want to put the run() method directly
in your object (and very often you don’t), you can always make an adapter class that
serves as the Runnable for you. The adapter’s run() method can then call any method
it wants after the thread is started. We’ll show examples of these options later */



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Creating and starting threads
/*
A newly born thread remains idle until we give it a figurative slap on the bottom by
calling its start() method. The thread then wakes up and proceeds to execute the
run() method of its target object. start() can be called only once in the lifetime of a
thread. Once a thread starts, it continues running until the target object’s run()
method returns (or throws an unchecked exception of some kind). The start()
method has a sort of evil twin method called stop(), which kills the thread perma‐
nently. However, this method is deprecated and should no longer be used. We’ll
explain why and give some examples of a better way to stop your threads later in this
chapter. We will also look at some other methods you can use to control a thread’s
progress while it is running.
Let’s look at an example. The following class, Animator, implements a run() method
to drive a drawing loop we could use in our game for updating the Field: */
class Animator implements Runnable {
    boolean animating = true;
    public void run() {
        while ( animating ) {
            // move apples one "frame"
            // repaint field
            // pause
            ...
            }
            }
            }
         //   To use it, we create a Thread object, passing it an instance of Animator as its target
          //  object, and invoke its start() method. We can perform these steps explicitly:
          Animator myAnimator = new Animator();
          Thread myThread = new Thread(myAnimator);
          myThread.start();

          /*We created an instance of our Animator class and passed it as the argument to the
constructor for myThread. As shown in Figure 9-1, when we call the start() method,
myThread begins to execute Animator’s run() method. Let the show begin!
 */