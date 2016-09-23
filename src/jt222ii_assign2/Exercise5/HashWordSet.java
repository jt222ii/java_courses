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
    public String toString() // Returns the values as a string
    {
        String string = "";
        Iterator iterator = iterator();
        while(iterator.hasNext())
        {
            string += iterator.next().toString() + ", ";
        }
        return string;
    }

    @Override
    public void add(Word word) //adds a word to the hashset
    {
        int pos = getBucketNumber(word);//get the bucket number of the word
        Node node = buckets[pos];
        while(node != null){
            if(node.value.equals(word))//if the word already exists it should not be added
            {
                return;
            }
            node = node.next;//next node in list
        }
        node = new Node(word);// node was not found add new node as first entry
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if(size == buckets.length)
        {
            rehash(); //rehash if the array "buckets" has reached its maximum size
        }

    }

    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);// get the array index of the word
        Node node = buckets[pos];
        while(node != null)//search while the node exists
        {
            if(node.value.equals(word) && node.value.hashCode() == word.hashCode())//if the node-value and word are the same the word was found. Return true
            {
                return true;
            }
            node = node.next; // keep searching in the bucket
        }
        return false; //not found
    }

    @Override
    public int size() {
        return size;
    }//returns the size of the set

    @Override
    public Iterator iterator() {
        return new BucketIterator();
    }

    private class BucketIterator implements Iterator<Word>
    {
        Node next;

        public BucketIterator()
        {
            //when the iterator is created the next value is set
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
            if(next.next == null)//if next.next does not exist find the next bucket with values in it
            {
                Node tmp = null;
                for(int i = getBucketNumber(next.value)+1; i < buckets.length; i++)//start looping from the last searched bucket
                {
                    if(buckets[i] != null)//if value in bucket is not null a bucket with values was found
                    {
                        tmp = buckets[i];
                        break;
                    }
                }
                next = tmp;
            }
            else//if next.next exists keep going through the bucket
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
        //recreates the array with a new twice as long array. From slides
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

    private int getBucketNumber(Word w)//gets the needed index in "buckets" of the word
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
