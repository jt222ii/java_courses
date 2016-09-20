package jt222ii_assign2.Exercise1;
import jt222ii_assign2.Exercise1.da1031.*;
/**
 * Created by jonastornfors on 2016-09-13.
 */
public class ArrayIntStack3 extends AbstractIntCollection implements IntStack {

    /* Add integer at top of stack. */
    @Override
    public void push(int n) {
        size++;
        if(size() == values.length)
        {
            resize();
        }
        for (int i = size-1; i > 0; i--)
        {
            values[i] = values[i-1];
        }
        values[0] = n;
    }

    /* Returns and removes integer at top of stack  */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Can't pop from an empty stack");
        }
        int value = values[0];
        for (int i = 0; i < size-1; i++)
        {
            values[i] = values[i+1];
        }
        size--;
        return value;
    }

    /* Returns without removing integer at top of stack */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Can't peek from an empty stack");
        }
        return values[0];
    }
}
