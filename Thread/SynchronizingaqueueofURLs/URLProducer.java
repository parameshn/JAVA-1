package SynchronizingaqueueofURLs;


import java.util.Random;




public class URLProducer extends Thread {
    String producerID;
    int urlCount;
    Random delay = new Random();
    //LinkedList queue;
    URLQueuem urlQueue;
    URLProducer(String producerID ,int urlCount, URLQueuem urlQueue)
    {
        this.producerID = producerID;
        this.urlCount = urlCount;
        this.urlQueue = urlQueue;

    }
    /* Now that we know how we’ll be storing and retrieving our URLs, we can create the
    producer and consumer classes. The producer will run a simple loop to make up fake
    URLs, prefix them with a producer ID, and store them in our queue. Here’s the run()
    method for URLProducer:
    */
    public void run()
    {
        
        for ( int i = 1; i <= urlCount; i++)
        {
            String url = "https://some.url/at/path" + i;
            urlQueue.addURL(producerID + " " + url);
            System.out.println(producerID + "produced" + url);
           
            try {
                Thread.sleep(delay.nextInt(500));
            }catch (InterruptedException is)
            {
                System.err.println("Producer" + producerID + "interrupted. Quitting.");
                break;
            }
        }

    }
}
