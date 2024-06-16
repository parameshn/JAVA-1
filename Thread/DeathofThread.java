package Thread;
 

/* Death of a Thread
 A thread continues to execute until one of the following happens:
 • It explicitly returns from its target run() method.
 • It encounters an uncaught runtime exception.
 •The evil and nasty deprecated stop() method is called.
 What happens if none of these things occurs, and the run() method for a thread
 never terminates? The answer is that the thread can live on, even after what is ostensi
bly the part of the application that created it has finished. This means we have to be
 aware of how our threads eventually terminate, or an application can end up leaving
 orphaned threads that unnecessarily consume resources or keep the application alive
 when it would otherwise quit.
 In many cases, we really want to create background threads that do simple, periodic
 tasks in an application. The setDaemon() method can be used to mark a thread as a 
 daemon thread that should be killed and discarded when no other nondaemon appli
cation threads remain. Normally, the Java interpreter continues to run until all
 threads have completed. But when daemon threads are the only threads still alive, the
 interpreter will exit.*/
public class DeathofThread extends Thread {

    DeathofThread() {
        setDaemon(true);
        start();
    }

    public void run() {
        System.out.println("lolo");
    }

}

/* In this example, the Devil thread sets its daemon status when it is created. If any
 Devil threads remain when our application is otherwise complete, the runtime sys
tem kills them for us. We don’t have to worry about cleaning them up.
 Daemon threads are primarily useful in standalone Java applications and in the
 implementation of server frameworks, but not in component applications (where a
 small piece of code runs inside a larger one). Since these components run inside
 another Java application, any daemon threads they might create can continue to live
 until the controlling application exits—probably not the desired effect. Any such
 application can use ThreadGroups to contain all the threads created by subsystems or
 components and then clean them up if necessary.
 One final note about killing threads gracefully. A very common problem new devel
opers encounter the first time they create an application using a Swing component is
 that their application never exits; the Java VM seems to hang indefinitely after every
thing is finished. When working with graphics, Java has created a UI thread to pro
cess input and painting events. The UI thread is not a daemon thread, so it doesn’t
 exit automatically when other application threads have completed, and the developer
 must call System.exit() explicitly.
  */
