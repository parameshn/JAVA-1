package SynchronizingaqueueofURLs;

public class URLDemo {
    public static void main(String args[])
    {
        URLQueuem queue = new URLQueuem();
        URLProducer p1 = new URLProducer("p1", 100, queue);
        URLProducer p2 = new URLProducer("P2", 100, queue);
        URLConsumer c1 = new URLConsumer("C1", queue);
        URLConsumer c2 = new URLConsumer("C2", queue);
        System.out.println("Starting...");
        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try{
            //wait for the producers to finish creating urls
            p1.join();
            p2.join();
        } catch (InterruptedException ie)
        {
            System.err.println("Interrupted waiting for producers to finish");
        }
         c1.setKeepWorking(false);
         c2.setKeepWorking(false);
         try {
            //Now wait for the workers to clean out the queue
            c1.join();
            c2.join();
         }catch(InterruptedException ie){
             System.err.println("Interrupted waiting for consumers to finish");
             System.out.println("Done");

         }
        
    }
    
}
/*Starting...
C1skipped empty queue
C2skipped empty queue
p1producedhttps://some.url/at/path1
P2producedhttps://some.url/at/path1
C2consumedP2 https://some.url/at/path1
C1consumedp1 https://some.url/at/path1
p1producedhttps://some.url/at/path2
C1consumedp1 https://some.url/at/path2
C2skipped empty queue
P2producedhttps://some.url/at/path2
p1producedhttps://some.url/at/path3
P2producedhttps://some.url/at/path3
C1consumedP2 https://some.url/at/path2
C2consumedp1 https://some.url/at/path3
C1consumedP2 https://some.url/at/path3 */


/* Notice that the threads don’t take perfect, round-robin turns, but that every thread
 does get at least some work time. And you can see that the consumers are not locked
 to specific producers. Again the idea is to make efficient use of limited resources. Pro
ducers can keep adding tasks without worrying about how long each task will take or
 who to assign it to. Consumers, in turn, can grab a task without worry about other
 consumers. If one consumer gets handed a simple task and finishes before other con
sumers, it can go back and get a new task right away.
 Try running this example yourself and bump up some of those numbers. What hap
pens with hundreds of URLs? What happens with hundreds of producers or consum
ers? At scale, this type of multitasking is almost required. You won’t find large
 programs out there that don’t use threads to manage at least some of their back
ground work. Indeed, we saw above that Java’s own graphical package, Swing, needs a
 separate thread to keep the UI responsive and correct no matter how small your
 application might be. */