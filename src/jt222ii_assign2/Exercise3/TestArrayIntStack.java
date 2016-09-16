package jt222ii_assign2.Exercise3;

import jt222ii_assign2.Exercise1.ArrayIntStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonastornfors on 2016-09-15.
 */
public class TestArrayIntStack {
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
    public void push() throws Exception {
        ArrayIntStack stack = new ArrayIntStack();
        int expectedValue = 10;
        int expectedSize = 100000;
        //Pushing a value. And makes sure the value is added
        stack.push(expectedValue);
        assertEquals(expectedValue, stack.peek());

        //pushes 999999 values. stack should now be 100000 values
        for (int i = 0; i < expectedSize-1; i++)
        {
            stack.push(i);
        }
        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void pop() throws Exception {
        ArrayIntStack stack = new ArrayIntStack();
        //Adding a value then popping it. Checks if the added value is what is popped
        int expectedValue = 34;
        stack.push(expectedValue);
        int value = stack.pop();
        assertEquals(expectedValue, value);

        //pushes 10000 values then pops 10000. stack size should now be 0
        for (int i = 0; i < 10000; i++)
        {
            stack.push(i);
        }
        for (int i = 0; i < 10000; i++)
        {
            stack.pop();
        }
        assertEquals(0, stack.size());

        //Tries to pop from the empty stack
        try
        {
            stack.pop();
            fail("pop() - Expected an IndexOutOfBoundsException when trying to pop from an empty stack. No such exception was detected");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void peek() throws Exception {
        ArrayIntStack stack = new ArrayIntStack();
        //try to peek on empty stack. expecting exception
        try
        {
            stack.peek();
            fail("peek() - Expected an IndexOutOfBoundsException when peeking on an empty stack. No such error was thrown");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }

        //Peek twice. Value should be same as peek does not remove an object
        stack.push(1);
        stack.push(2);
        assertEquals(stack.peek(), stack.peek());

        //Check so that its 2 in the top of the stack
        assertEquals(2, stack.peek());
    }

}