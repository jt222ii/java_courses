package jt222ii_assign1.Queue;
import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-06.
 */
public class Queue implements QueueInterface {

    private int queueSize = 0;
    private QueueObject head, tail;

    public Queue() {}

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
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't dequeue from the queue when the queue is empty!");
        }
        Object dequeuedElement = head.getObject();
        head = head.getNext();
        queueSize--;
        return dequeuedElement;
    }

    @Override
    public Object first() throws IndexOutOfBoundsException {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get first element of the queue when the queue is empty!");
        }
        return head.getObject();
    }

    @Override
    public Object last() throws IndexOutOfBoundsException {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't last element of the queue when the queue is empty!");
        }
        return tail.getObject();
    }

    @Override
    public boolean contains(Object o) {
        QueueObject object = head;
        for (int i = 0; i < queueSize; i++)
        {
            if(object.getObject() == o)
            {
                return true;
            }
            object = object.getNext();

        }
        return false;
    }

    @Override
    public Iterator<Object> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<Object>
    {
        private QueueObject qO = head;
        @Override
        public Object next()
        {
            if(!hasNext())
            {
                throw new IndexOutOfBoundsException("Can't get next value when there is no next value!");
            }
            Object obj = qO.object;
            qO = qO.getNext();
            return obj;
        }

        @Override
        public boolean hasNext()
        {
            return qO != null;
        }
    }

    private class QueueObject {
        private QueueObject nextObject;
        private Object object;

        public QueueObject(Object o){
            object = o;
        }

        public Object getObject()
        {
            return object;
        }

        public QueueObject getNext()
        {
            return nextObject;
        }

        public void setNext(QueueObject qO)
        {
            nextObject = qO;
        }
    }
}
