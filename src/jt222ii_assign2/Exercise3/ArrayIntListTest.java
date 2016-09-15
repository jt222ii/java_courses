package jt222ii_assign2.Exercise3;

import jt222ii_assign2.Exercise1.ArrayIntList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonastornfors on 2016-09-15.
 */
public class ArrayIntListTest {
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
    public void add() throws Exception {
        int expectedSize = 100000;
        //creates a list that is 100000 in size. Then adds another value and checks so that the new size is as expected
        ArrayIntList intList = getList(expectedSize);
        intList.add(10);
        expectedSize++;
        assertEquals(expectedSize, intList.size());
    }

    @Test
    public void addAt() throws Exception {
        //create a list that is 10 in size
        ArrayIntList intList = getList(10);
        int expectedValue = 5, index = 5;
        //add a value at index. make sure that value is at the index
        intList.addAt(expectedValue, index);
        assertEquals(expectedValue, intList.get(index));

        //Try to add a value out of bounds. Success if IndexOutOfBoundsException is thrown
        try
        {
            intList.addAt(5, intList.size()+100);
            fail("addAt() - Error was not thrown when adding an int out of bounds!");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void remove() throws Exception {
        int listSize = 100000;
        ArrayIntList intList = getList(listSize);
        //Remove value at index. Make sure that it is removed and that the list size is now smaller
        int index = 5;
        int intRemoved = intList.get(index);
        intList.remove(index);
        assertEquals(listSize-1, intList.size());
        assertTrue(intList.get(index) != intRemoved);

        //Try to remove a value out of bounds. Success if IndexOutOfBoundsException is thrown
        try
        {
            intList.remove(intList.size()+100);
            fail("remove() - Error was not thrown when trying to remove an int out of bounds!");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void get() throws Exception {
        int listSize = 100000;
        ArrayIntList intList = getList(listSize);
        //make sure that each value in the list is correct
        for (int i = 0; i<listSize; i++)
        {
            assertEquals(i, intList.get(i));
        }

        //Try to get a value out of bounds. Success if IndexOutOfBoundsException is thrown
        try
        {
            intList.get(listSize+100);
            intList.get(-100);
            fail("get() - Expected an IndexOutOfBoundsException but no such exception was thrown.");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void indexOf() throws Exception {
        int listSize = 100000;
        ArrayIntList intList = getList(listSize);
        //Index of 5000 should be 5000
        assertEquals(5000, intList.indexOf(5000));
        //add another value and make sure index of finds it at the correct index
        intList.add(100001);
        assertEquals(intList.size()-1, intList.indexOf(100001));

        //If the value does not exist. -1 should be returned
        assertEquals(-1, intList.indexOf(1000000000));
    }

    //creates an arrayintlist. Values will be the same as its index so 0=0, 1=1, 2=2 etc.
    public ArrayIntList getList(int size)
    {
        ArrayIntList intList = new ArrayIntList();
        for(int i = 0; i < size; i++)
        {
            intList.add(i);
        }
        return intList;
    }
}