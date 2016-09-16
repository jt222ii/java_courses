package jt222ii_assign2.Exercise4;

import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-15.
 */
public class Queue<E> implements IQueue<E> {
    private int queueSize = 0;
    QueueObject head;
    QueueObject tail;
    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }

    @Override
    public void enqueue(E element) {
        QueueObject newObject = new QueueObject(element);
        if(queueSize == 0)
        {
            head = newObject;
        }
        else
        {
            tail.next = newObject;
        }
        tail = newObject;
        queueSize++;
    }

    @Override
    public E dequeue() {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't dequeue from the queue when the queue is empty!");
        }
        E dequeuedElement = head.element;
        head = head.next;
        queueSize--;
        return dequeuedElement;
    }

    @Override
    public E first() {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get first element of the queue when the queue is empty!");
        }
        return head.element;
    }

    @Override
    public E last() {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get last element of the queue when the queue is empty!");
        }
        return tail.element;
    }

    @Override
    public Iterator<E> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<E> {
        private QueueObject qO = head;
        @Override
        public E next()
        {
            if(!hasNext())//If you try to get next of a queueobject that has no next throw an error
            {
                throw new IndexOutOfBoundsException("Can't get next value when there is no next value!");
            }
            E element = qO.element;//element to return
            qO = qO.next;//sets qO to the next queueobject
            return element;
        }

        @Override
        public boolean hasNext()
        {
            return qO != null;
        }
    }

    private class QueueObject //the QueueObject class is used to create QueueObjects containing the object and the next QueueObject
    {
        QueueObject next;
        E element;

        public QueueObject(E e)
        {
            element = e;
        }
    }
}
