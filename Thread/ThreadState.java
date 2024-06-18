
public class ThreadState {
    /*  Thread State
    At any given time, a thread is in one of five general states that encompass its life cycle
    and activities. These states are defined in the Thread.State enumeration and queried
    via the getState() method of the Thread class:
    NEW
    The thread has been created but not yet started.
    RUNNABLE
    The normal active state of a running thread, including the time when a thread is
    blocked in an I/O operation, like a read or write or network connection.
    BLOCKED
    The thread is blocked, waiting to enter a synchronized method or code block.
    This includes the time when a thread has been awakened by a notify() and is
    attempting to reacquire its lock after a wait().
    WAITING, TIMED_WAITING
    The thread is waiting for another thread via a call to wait() or join(). In the
    case of TIMED_WAITING, the call has a timeout.
    TERMINATED
    The thread has completed due to a return, an exception, or being stopped.
    We can show the state of all threads in Java (in the current thread group) with the
    following snippet of code:
    */


    public static void main(String [] arg)
    {
        Thread[] threads = new Thread[64]; // max threads to show
        int num = Thread.enumerate(threads);
        for (int i = 0; i < num; i++)
            System.out.println(threads[i] + ":" + threads[i].getState());
    }
}

