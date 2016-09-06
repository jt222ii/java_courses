package jt222ii_assign1.Queue;
import java.util.Iterator;
/**
 * Created by jonastornfors on 2016-09-06.
 */
// A sequential collection with add and remove at different sides  FiFo(First in, First out)
public class Queue implements QueueInterface {

    private int queueSize = 0;
    private Object[] values;

    public Queue() {
        values = new Object[128];
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }

    @Override
    public void enqueue(Object element) {
        values[queueSize] = element;
        queueSize++;
    }

    @Override
    public Object dequeue() throws IndexOutOfBoundsException {
        Object dequeuedElement = values[1];
        queueSize--;
        return dequeuedElement;
    }

    @Override
    public Object first() throws IndexOutOfBoundsException {
        return values[0];
    }

    @Override
    public Object last() throws IndexOutOfBoundsException {
        return values[queueSize-1];
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<Integer>
    {
        @Override
        public Integer next()
        {
            return 0;
        }

        @Override
        public boolean hasNext()
        {
            return false;
        }
    }
}
