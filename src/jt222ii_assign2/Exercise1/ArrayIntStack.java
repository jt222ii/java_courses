package jt222ii_assign2.Exercise1;
import jt222ii_assign2.Exercise1.da1031.*;
/**
 * Created by jonastornfors on 2016-09-20.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    /* Add integer at top of stack. */
    @Override
    public void push(int n) {
        values[size++] = n;
        if(size == values.length-1)
        {
            resize();
        }
    }

    /* Returns and removes integer at top of stack  */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Can't pop from an empty stack");
        }
        return values[--size];
    }

    /* Returns without removing integer at top of stack */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Can't peek from an empty stack");
        }
        return values[size-1];
    }
}
