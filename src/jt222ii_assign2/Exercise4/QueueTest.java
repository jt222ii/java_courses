package jt222ii_assign2.Exercise4;

import jt222ii_assign2.Exercise1.ArrayIntList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonastornfors on 2016-09-16.
 */
public class QueueTest {
    private static int testNr;
    @Before
    public void setUp() throws Exception {
        System.out.println("-Running test nr. " + ++testNr);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Finished test nr. "+testNr);
    }

    @Test
    public void size() throws Exception {
        Queue queue = new Queue();
        int value = 10000000;
        for (int i = 0; i < value; i++)
        {
            queue.enqueue(i);
        }
        assertEquals(value, queue.size());
    }

    @Test
    public void isEmpty() throws Exception {
        Queue queue = new Queue();
        //queue should be empty
        assertTrue(queue.isEmpty());
        queue.enqueue("lul");
        //queue should not be empty
        assertFalse(queue.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        Queue queue = new Queue();
        int value = 100000;
        for (int i = 0; i < value; i++)
        {
            queue.enqueue(i);
            assertEquals(i+1, queue.size()); //size of queue should be same as i+1
        }
        for (int i = 0; i < value; i++)
        {
            queue.enqueue(i);
        }
        assertEquals(value*2, queue.size()); //size of array should now be 200000
    }

    @Test
    public void dequeue() throws Exception {
        Queue queue = new Queue();
        //adding and dequeueing an int value
        queue.enqueue(123);
        assertEquals(123, queue.dequeue());
        //adding and dequeueing a string value
        queue.enqueue("Sträng");
        assertEquals("Sträng", queue.dequeue());
        //adding and dequeueing an object
        Object object = new Object();
        queue.enqueue(object);
        assertEquals(object, queue.dequeue());
        //adding and dequeueing an array
        int[] array = {1,2,3,4};
        queue.enqueue(array);
        assertEquals(array, queue.dequeue());

        //size should be 0.
        assertEquals(0, queue.size());
    }

    @Test
    public void first() throws Exception {

    }

    @Test
    public void last() throws Exception {

    }
}