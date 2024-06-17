package SynchronizingaqueueofURLs;

import java.util.LinkedList;

public class URLQueuem {
    /* Synchronizing a queue of URLs
    Let’s look first at the queue where the URLs will be stored. We’re not trying to be
    fancy with the queue itself; it’s just a list where we can append URLs (as Strings) to
    the end and pull them off from the front. We’ll use a LinkedList similar to the Array
    List we saw in Chapter 7. It is a structure designed for the efficient access and
    manipulation that we want for this queue.
    */

    LinkedList<String> urlQueue = new LinkedList<>();

    public synchronized void addURL(String url)
    {
        urlQueue.add(url);
    }

    public synchronized String getURL()
    {
        if (!urlQueue.isEmpty()) {
            return urlQueue.removeFirst();
        }
        return null;
    }
    
    public boolean isEmpty()
    {
        return urlQueue.isEmpty();
    }


    /* Note that not every method is synchronized! We allow any thread to ask about
    whether the queue is empty or not without holding up other threads that might be
    adding or removing. This does mean that we might report a wrong answer—if the
    timing of different threads is exactly wrong—but our system is somewhat fault toler
    ant, so the efficiency of not locking the queue just to check its size wins out over more
    perfect knowledge
    */
}


