/* Scheduling and Priority
 Java makes few guarantees about how it schedules threads. Almost all of Java’s thread
 scheduling is left up to the Java implementation and, to some degree, the application.
 Although it might have made sense (and would certainly have made many developers
 happier) if Java’s developers had specified a scheduling algorithm, a single algorithm
 isn’t necessarily suitable for all the roles that Java can play. Instead, Java’s designers put 
 the burden on you to write robust code that works no matter the scheduling algo
rithm, and let the implementation tune the algorithm for the best fit.4
 The priority rules that we describe next are carefully worded in the Java language
 specification to be a general guideline for thread scheduling. You should be able to
 rely on this behavior overall (statistically), but it is not a good idea to write code that
 relies on very specific features of the scheduler to work properly. You should instead
 use the control and synchronization tools that we have described in this chapter to
 coordinate your threads.5
 Every thread has a priority value. In general, any time a thread of a higher priority
 than the current thread becomes runnable (is started, stops sleeping, or is notified), it
 preempts the lower-priority thread and begins executing. By default, threads with the
 same priority are scheduled round-robin, which means once a thread starts to run, it
 continues until it does one of the following:
 • Sleeps, by calling Thread.sleep() or wait()
 • Waits for a lock, in order to run a synchronized method
 • Blocks on I/O, for example, in a read() or accept() call
 • Explicitly yields control, by calling yield()
 • Terminates by completing its target method*/