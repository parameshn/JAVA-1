//Controlling Threads

/*We have seen the start() method used to begin execution of a new thread. Several
other instance methods let us explicitly control a thread’s execution:
• The static Thread.sleep() method causes the currently executing thread to wait
for a designated period of time (give or take), without consuming much (or pos‐
sibly any) CPU time.
• The methods wait() and join() coordinate the execution of two or more
threads. We’ll discuss them in detail when we talk about thread synchronization
later in this chapter.
• The interrupt() method wakes up a thread that is sleeping in a sleep() or
wait() operation or is otherwise blocked on a long I/O operation.*/



//Deprecated methods

/*We should also mention three deprecated thread control methods: stop(), sus
pend(), and resume(). The stop() method complements start(); it destroys the
thread. start() and the deprecated stop() method can be called only once in the
thread’s life cycle. By contrast, the deprecated suspend() and resume() methods were
used to arbitrarily pause and then restart the execution of a thread.
Although these deprecated methods still exist in the latest version of Java (and will
probably be there forever), they shouldn’t be used in new code development. The
problem with both stop() and suspend() is that they seize control of a thread’s exe‐
cution in an uncoordinated, harsh way. This makes programming difficult; it’s not
always easy for an application to anticipate and properly recover from being interrup‐
ted at an arbitrary point in its execution. Moreover, when a thread is seized using one
of these methods, the Java runtime system must release all its internal locks used for
thread synchronization. This can cause unexpected behavior and, in the case of sus
pend(), which does not release these locks, can easily lead to deadlock.

A better way to affect the execution of a thread—which requires just a bit more work
on your part—is by creating some simple logic in your thread’s code to use monitor
variables (if these variables are boolean, you might see them referred to as “flags”),
possibly in conjunction with the interrupt() method, which allows you to wake up
a sleeping thread. In other words, you should cause your thread to stop or resume
what it is doing by asking it nicely rather than by pulling the rug out from under it
unexpectedly. The thread examples in this book use this technique in one way or
another.*/

/*The sleep() method
We often need to tell a thread to sit idle, or “sleep,” for a fixed period of time. While a
thread is asleep, or otherwise blocked from input of some kind, it doesn’t consume
CPU time or compete with other threads for processing. For this, we can call the
static method Thread.sleep(), which affects the currently executing thread. The call
causes the thread to go idle for a specified number of milliseconds:*/
try {
 // The current thread
 Thread.sleep( 1000 );
 } catch ( InterruptedException e ) {
 // someone woke us up prematurely
 }
/*
The sleep() method may throw an InterruptedException if it is interrupted by
another thread via the interrupt() method (more below). As you saw in the previ‐
ous code, the thread can catch this exception and take the opportunity to perform
some action—such as checking a variable to determine whether or not it should exit
—or perhaps just perform some housekeeping and then go back to sleep */
