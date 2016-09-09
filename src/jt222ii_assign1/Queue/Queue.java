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
    public int size() //returns the size of the queue
    {
        return queueSize;
    }

    @Override
    public boolean isEmpty() //returns true of the queue is empty
    {
        return queueSize == 0;
    }

    @Override
    public void enqueue(Object element)//adds element to queue
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
    public Object dequeue() throws IndexOutOfBoundsException //removes dequeues the first element in the queue
    {
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
    public Object first() throws IndexOutOfBoundsException  //returns the first object in the queue
    {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get first element of the queue when the queue is empty!");
        }
        return head.getObject();
    }

    @Override
    public Object last() throws IndexOutOfBoundsException //returns the last object in the queue
    {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't last element of the queue when the queue is empty!");
        }
        return tail.getObject();
    }

    @Override
    public boolean contains(Object o) //returns true if the queue contains the specified object
    {
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
            if(!hasNext())//If you try to get next of a queueobject that has no next throw an error
            {
                throw new IndexOutOfBoundsException("Can't get next value when there is no next value!");
            }
            Object obj = qO.object;//object to return
            qO = qO.getNext();//sets qO to the next queueobject
            return obj;
        }

        @Override
        public boolean hasNext()
        {
            return qO != null;
        }//returns true as long as the next queueObject(qO) is specified
    }

    private class QueueObject //the QueueObject class is used to create QueueObjects containing the object and the next QueueObject
    {
        private QueueObject nextObject;
        private Object object;

        public QueueObject(Object o)
        {
            object = o;
        }

        public Object getObject()//returns the object
        {
            return object;
        }

        public QueueObject getNext()//returns the next QueueObject
        {
            return nextObject;
        }

        public void setNext(QueueObject qO)//sets the next QueueObject
        {
            nextObject = qO;
        }
    }
}
