package SynchronizingaqueueofURLs;

import java.util.Random;

public class URLConsumer extends Thread {
    String consumerID;
    URLQueuem queue;
    public volatile boolean keepWorking = true;
    Random delay = new Random();


    URLConsumer(String consumerID , URLQueuem queue)
    {
        this.consumerID = consumerID;
        this.queue = queue;
    }

    public void setKeepWorking(boolean keepWorking)
    {
        this.keepWorking = keepWorking; 
    }

    public void run()
    {
        while (keepWorking || !queue.isEmpty())
        {
            String url = queue.getURL();
            if(url != null)
            {
                System.out.println(consumerID + "consumed" + url);
            } else {
                System.out.println(consumerID + "skipped empty queue");
            }
            try {
                Thread.sleep(delay.nextInt(1000));
            }catch (InterruptedException ie)
            {
                System.err.println("consumer" + consumerID + "interrupted.Quitting");
                break;
            }

        }
    }


}
