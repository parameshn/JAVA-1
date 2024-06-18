public class ThreadSlicing {
    /* Time-Slicing
    In addition to prioritization, all modern systems (with the exception of some embed
    ded and “micro” Java environments) implement thread time-slicing. In a time-sliced
    system, thread processing is chopped up so that each thread runs for a short period of
    time before the context is switched to the next thread
     Higher-priority threads still preempt lower-priority threads in this scheme. The addi
    tion of time-slicing mixes up the processing among threads of the same priority; on a
    multiprocessor machine, threads may even be run simultaneously. This can introduce
    a difference in behavior for applications that don’t use threads and synchronization
    properly.
    Strictly speaking, because Java doesn’t guarantee time-slicing, you shouldn’t write
    code that relies on this type of scheduling; any software you write should function
    under round-robin scheduling. If you’re wondering what your particular flavor of
    Java does, try the following experiment:
    
    */

    public static void main(String args[]) {
        // new ShowThread("Foo").start();  //without priority
        // new ShowThread("Bar").start();

        //with priority
        Thread foo = new ShowThread("Foo");
        foo.setPriority(Thread.MIN_PRIORITY);
        Thread bar = new ShowThread("Bar");
        bar.setPriority(Thread.MAX_PRIORITY);
        foo.start();
        bar.start();
    }

    // static class ShowThread extends Thread {
    //     String message;

    //     ShowThread(String message) {
    //         this.message = message;
    //     }

    //     public void run() {
    //         while (true)

    //             System.out.println(message);
    //     }
    // }

    //We can change our previous example to include a yield() on each iteration
    static class ShowThread extends Thread {
        String message;

        ShowThread(String message) {
            this.message = message;
        }

        public void run() {
            while (true)
            {
                System.out.println(message);
               // yield();
            }

        }
    }

}
/*The Thready class starts up two ShowThread objects. ShowThread is a thread that goes
 into a hard loop (very bad form) and prints its message. Because we don’t specify a
 priority for either thread, they both inherit the priority of their creator, so they have
 the same priority. When you run this example, you will see how your Java implemen
tation does its scheduling. Under a round-robin scheme, only “Foo” should be
 printed; “Bar” never appears. In a time-slicing implementation, you should occasion
ally see the “Foo” and “Bar” messages alternate. */





/*
 Priorities
 As we said before, the priorities of threads exist as a general guideline for how the
 implementation should allocate time among competing threads. Unfortunately, with
 the complexity of how Java threads are mapped to native thread implementations,
 you cannot rely upon the exact meaning of priorities. Instead, you should only con
sider them a hint to the VM.




We would expect that with this change to our Thready class, the Bar thread would
 take over completely. If you run this code on an old Solaris implementation of Java
 5.0, that’s what happens. The same is not true on Windows or with some older ver
sions of Java. Similarly, if you change the priorities to values other than min and max,
 you may not see any difference at all. The subtleties relating to priority and perfor
mance relate to how Java threads and priorities are mapped to real threads in the OS.
 For this reason, thread priorities should be reserved for system and framework
 development. */



 /*Yielding
 Whenever a thread sleeps, waits, or blocks on I/O, it gives up its time slot and another
 thread is scheduled. As long as you don’t write methods that use hard loops, all
 threads should get their due. However, a thread can also signal that it is willing to give
 up its time voluntarily at any point with the yield() call. We can change our previous
 example to include a yield() on each iteration
 
 
  You should see “Foo” and “Bar” messages strictly alternating. If you have threads that
 perform very intensive calculations or otherwise eat a lot of CPU time, you might
 want to find an appropriate place for them to yield control occasionally. Alternatively,
 you might want to drop the priority of your compute-intensive thread so that more
 important processing can proceed around it.
 Unfortunately, the Java language specification is very weak with respect to yield(). It
 is another one of those things that you should consider an optimization hint rather
 than a guarantee. In the worst case, the runtime system may simply ignore calls to
 yield().
 */