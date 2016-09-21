package jt222ii_assign2.Exercise5;
import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-21.
 */
public class HashWordSet implements WordSet {
    private int size;
    private Node[] buckets = new Node[8];

    public HashWordSet() {}
    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null){
            if(node.value.equals(word))
            {
                return;
            }
            node = node.next;
        }
        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if(size == buckets.length)
        {
            rehash();
        }

    }

    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null)
        {
            if(node.value.equals(word) && node.value.hashCode() == word.hashCode())
            {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new BucketIterator();
    }

    private class BucketIterator implements Iterator<Word>
    {
        Node next;

        public BucketIterator()
        {
            for(Node node : buckets)
            {
                if(node != null)
                {
                    next = node;
                    break;
                }
            }
        }

        @Override
        public Word next()
        {
            Node e = next;
            if(next.next == null)
            {
                Node tmp = null;
                for(int i = getBucketNumber(next.value)+1; i < buckets.length; i++)
                {
                    if(buckets[i] != null)
                    {
                        tmp = buckets[i];
                        break;
                    }
                }
                next = tmp;
            }
            else
            {
                next = next.next;
            }
            return e.value;
        }

        @Override
        public boolean hasNext()
        {
            return next != null;
        }
    }

    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        size = 0;
        for(Node n : temp)
        {
            if(n == null) continue;
            while (n != null)
            {
                add(n.value);
                n = n.next;
            }
        }
    }

    private int getBucketNumber(Word w)
    {
        int hc = w.hashCode();
        if(hc < 0) hc = -hc;
        return hc % buckets.length;
    }

    private class Node
    {
        Node next;
        Word value;
        public Node(Word w)
        {
            value = w;
        }
    }
}
