package jt222ii_assign2.Exercise1;
import jt222ii_assign2.Exercise1.da1031.*;
/**
 * Created by jonastornfors on 2016-09-13.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {
    @Override
    public void add(int n) {
        values[size()] = n;
        size++;
        if(size() == values.length)
        {
            resize();
        }
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        size++;
        if(size() == values.length)
        {
            resize();
        }
        for (int i = size-1; i > index; i--)
        {
            values[i] = values[i-1];
        }
        values[index] = n;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if(index > size-1 || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size-1; i++)
        {
            values[i] = values[i+1];
        }
        size--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if(index > size-1 || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public int indexOf(int n) {
        for (int i = 0; i < size; i++)
        {
            if (values[i] == n)
            {
                return i;
            }
        }
        return -1;
    }
}
