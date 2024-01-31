//Garbage Collection

/*Java uses a technique known as garbage collection to remove objects that are no longer
needed. The garbage collector is Java’s grim reaper. It lingers in the background, stalk‐
ing objects and awaiting their demise. It finds and watches them, periodically count‐
ing references to them to see when their time has come. When all references to an
object are gone and it’s no longer accessible, the garbage-collection mechanism
declares the object unreachable and reclaims its space back to the available pool of
resources. An unreachable object is one that can no longer be found through any
combination of “live” references in the running application. */

/*Garbage collection uses a variety of algorithms; the Java virtual machine architecture
doesn’t require a particular scheme. It’s worth noting, however, how some implemen‐
tations of Java have accomplished this task. In the beginning, Java used a technique
called “mark and sweep.” In this scheme, Java first walks through the tree of all acces‐
sible object references and marks them as alive. Java then scans the heap, looking for
identifiable objects that aren’t marked. In this technique, Java is able to find objects
on the heap because they are stored in a characteristic way and have a particular sig‐
nature of bits in their handles unlikely to be reproduced naturally. This kind of algo‐
rithm doesn’t become confused by the problem of cyclic references, in which objects
can mutually reference each other and appear alive even when they are dead (Java
handles this problem automatically). This scheme wasn’t the fastest method, however,
and caused pauses in the program. Since then, implementations have become much
more sophisticated. */

/*Modern Java garbage collectors effectively run continuously without forcing any
lengthy delay in execution of the Java application. Because they are part of a runtime
system, they can also accomplish some things that could not be done statically. Sun’s
Java implementation divides the memory heap into several areas for objects with dif‐
ferent estimated lifespans. Short-lived objects are placed on a special part of the heap,
which drastically reduces the time to recycle them. Objects that live longer can be
moved to other, less volatile parts of the heap. In recent implementations, the garbage
collector can even “tune” itself by adjusting the size of parts of the heap based on the
actual application performance. The improvement in Java’s garbage collection since
the early releases has been remarkable and is one of the reasons that Java is now
roughly equivalent in speed to many traditional languages that place the burden of
memory management on the shoulders of the programmer */

/*In general, you do not have to concern yourself with the garbage-collection process.
But one garbage-collection method can be useful for debugging. You can prompt the
garbage collector to make a clean sweep explicitly by invoking the System.gc()
method. This method is completely implementation dependent and may do nothing,
but it can be used if you want some guarantee that Java has cleaned up before you do
an activity */