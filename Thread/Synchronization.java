//package thread;
//package ch09;


/* Synchronization
 Every thread has a mind of its own. Normally, a thread goes about its business
 without any regard for what other threads in the application are doing. Threads may
 be time-sliced, which means they can run in arbitrary spurts and bursts as directed by
 the OS. On a multiprocessor or multicore system, it is even possible for many differ
ent threads to be running simultaneously on different CPUs. This section is about
coordinating the activities of two or more threads so that they can work together and
 not collide in their use of the same variables and methods (coordinating their play on
 the golf course).
 Java provides a few simple structures for synchronizing the activities of threads. They
 are all based on the concept of monitors, a widely used synchronization scheme. You
 don’t have to know the details about how monitors work to be able to use them, but it
 may help you to have a picture in mind.
 A monitor is essentially a lock. The lock is attached to a resource that many threads
 may need to access, but that should be accessed by only one thread at a time. It’s very
 much like a restroom with a lock on the door; if it’s unlocked, you can enter and lock
 the door while you are using it. If the resource is not being used, the thread can
 acquire the lock and access the resource. When the thread is done, it relinquishes the
 lock, just as you unlock the restroom door and leave it open for the next person.
 However, if another thread already has the lock for the resource, all other threads
 must wait until the current thread is done and has released the lock. This is just like
 when the restroom is occupied when you arrive: you have to wait until the current
 user is done and unlocks the door.
 Fortunately, Java makes the process of synchronizing access to resources fairly easy.
 The language handles setting up and acquiring locks; all you need to do is specify the
 resources that require synchronization. */

public class Synchronization {

}


class SpeechSynthesizer {
    synchronized void say(String words) {
        //speak

    }
}

/* Because say() is an instance method, a thread must acquire the lock on the Speech
 Synthesizer instance it’s using before it can invoke the say() method. When say()
 has completed, it gives up the lock, which allows the next waiting thread to acquire
 the lock and run the method. It doesn’t matter whether the thread is owned by the
 SpeechSynthesizer itself or some other object; every thread must acquire the same
 lock, that of the SpeechSynthesizer instance. If say() were a class (static) method
 instead of an instance method, we could still mark it as synchronized. In this case,
 because no instance object is involved, the lock is on the class object itself.
 Often, you want to synchronize multiple methods of the same class so that only one
 method modifies or examines parts of the class at a time. All static synchronized
 methods in a class use the same class object lock. By the same token, all instance
 methods in a class use the same instance object lock. In this way, Java can guarantee
 that only one of a set of synchronized methods is running at a time. For example, a
 SpreadSheet class might contain a number of instance variables that represent cell
 values as well as some methods that manipulate the cells in a row:
  */


class SpreadSheet {
    int cellA1, cellA2, cellA3;
    int myObject;

    synchronized int sumRow() {
        return cellA1 + cellA2 + cellA3;
    }

    synchronized void setRow(int a1, int a2, int a3) {
        cellA1 = a1;
        cellA2 = a2;
        cellA3 = a3;
    }

    /* In this example, methods setRow() and sumRow() both access the cell values. You can
     see that problems might arise if one thread were changing the values of the variables
     in setRow() at the same moment another thread was reading the values in sumRow().
     To prevent this, we have marked both methods as synchronized. When threads are
     synchronized, only one runs at a time. If a thread is in the middle of executing
     setRow() when another thread calls sumRow(), the second thread waits until the first
     one finishes executing setRow() before it runs sumRow(). This synchronization allows
     us to preserve the consistency of the SpreadSheet. The best part is that all this lock
    ing and waiting is handled by Java; it’s invisible to the programmer 
    In addition to synchronizing entire methods, the synchronized keyword can be used
     in a special construct to guard arbitrary blocks of code. In this form, it also takes an
     explicit argument that specifies the object for which it is to acquire a lock:*/

    // synchronized ( myObject)

    // {
    //     // Functionality that needs exclusive access to resources
    // }

    /* This code block can appear in any method. When it is reached, the thread has to
     acquire the lock on myObject before proceeding. In this way, we can synchronize
     methods (or parts of methods) in different classes in the same way as methods in the
     same class.
     A synchronized instance method is, therefore, equivalent to a method with its state
    ments synchronized on the current object. Thus: */

    /* This code block can appear in any method. When it is reached, the thread has to
     acquire the lock on myObject before proceeding. In this way, we can synchronize
     methods (or parts of methods) in different classes in the same way as methods in the
     same class.
     A synchronized instance method is, therefore, equivalent to a method with its state
    ments synchronized on the current object. Thus: */

    synchronized void myMethod() {

    }
    // is equivalent to :

    void myMethod1() {
        synchronized (this) {

        }
    }
}


