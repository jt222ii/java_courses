package jt222ii_assign1.Queue;
import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-06.
 */
// A sequential collection with add and remove at different sides  FiFo(First in, First out)
public class Queue implements QueueInterface {

    private int queueSize = 0;
    private QueueObject head, tail;

    public Queue()
    {
       enqueue(new QueueObject(new Object()));
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
    public void enqueue(Object element)
    {
        QueueObject newObject = new QueueObject(element);
        if(queueSize == 0)
        {
            head = newObject;
        }
        else
        {
            tail.setNext(newObject);
        }
        tail = newObject;
        queueSize++;
    }

    @Override
    public Object dequeue() throws IndexOutOfBoundsException {
        Object dequeuedElement = head;
        head = head.getNext();
        queueSize--;
        return dequeuedElement;
    }

    @Override
    public Object first() throws IndexOutOfBoundsException {
        return head;
    }

    @Override
    public Object last() throws IndexOutOfBoundsException {
        return tail;
    }

    @Override
    public boolean contains(Object o) {
        QueueObject object = head;
        for (int i = 0; i < queueSize; i++)
        {
            if(object.getObject() == object)
            {
                return true;
            }
            object = object.getNext();
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<Integer>
    {
        @Override
        public Integer next()
        {
            return null;
        }

        @Override
        public boolean hasNext()
        {
            return false;
        }
    }
}
