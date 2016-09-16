package jt222ii_assign2.Exercise4;

import java.lang.annotation.ElementType;
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
            tail.setNext(newObject);
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
        E dequeuedElement = head.getElement();
        head = head.getNext();
        queueSize--;
        return dequeuedElement;
    }

    @Override
    public E first() {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get first element of the queue when the queue is empty!");
        }
        return head.getElement();
    }

    @Override
    public E last() {
        if(size() == 0)
        {
            throw new IndexOutOfBoundsException("Can't get last element of the queue when the queue is empty!");
        }
        return tail.getElement();
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
            qO = qO.getNext();//sets qO to the next queueobject
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
        private QueueObject next;
        private E element;

        public QueueObject(E e)
        {
            element = e;
        }

        public E getElement()//returns the object
        {
            return element;
        }

        public QueueObject getNext()//returns the next QueueObject
        {
            return next;
        }

        public void setNext(QueueObject qO)//sets the next QueueObject
        {
            next = qO;
        }
    }
}
