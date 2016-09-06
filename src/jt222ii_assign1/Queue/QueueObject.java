package jt222ii_assign1.Queue;

/**
 * Created by Jonas on 2016-09-06.
 */
public class QueueObject {

    QueueObject nextObject;
    Object object;

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
