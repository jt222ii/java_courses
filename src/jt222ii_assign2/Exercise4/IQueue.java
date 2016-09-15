package jt222ii_assign2.Exercise4;

/**
 * Created by jonastornfors on 2016-09-15.
 */
public interface IQueue<E> extends Iterable<E> {
    int size();                          // current queue size
    boolean isEmpty();                   // true if queue is empty
    void enqueue(E element);             // add element at end of queue
    E dequeue();                         // return and remove first element.
    E first();                           // return (without removing) first element
    E last();                            // return (without removing) last element
}

