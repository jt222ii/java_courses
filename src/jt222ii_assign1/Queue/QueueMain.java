package jt222ii_assign1.Queue;

import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-08.
 */
public class QueueMain {
    public static void main (String args[])
    {
        Queue queue = new Queue();
        queue.enqueue("first");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("last");
        System.out.println("First element is: " + queue.first());
        System.out.println("Last element is: " + queue.last());
        System.out.println("Size of queue is: " + queue.size());
        System.out.println("Dequeueing the head element: "+ queue.dequeue());
        System.out.println("The head element is now: " + queue.first() + " and the size of the queue is now: "+queue.size());
        System.out.println("Checking if queue contains \"3\": " + queue.contains("3"));

        System.out.println("Testing the iterator looping out everything in the queue: ");
        Iterator<Object> iterator = queue.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println("Dequeueing all elements in list:");
        while(!queue.isEmpty())
        {
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Queue size is now: " + queue.size());
        }
        System.out.println("List should now be empty: " + queue.isEmpty());
    }
}
