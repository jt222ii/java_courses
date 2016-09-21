package jt222ii_assign2.Exercise5;

import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-21.
 */
public class TreeWordSet implements WordSet {
    Node node;
    int size = 0;

    @Override
    public void add(Word word) {
        Node n = new Node(word);
        if(node == null)
        {
            node = n;
        }
        else if(!contains(word))
        {
            node.add(word);
            size++;
        }
    }

    @Override
    public boolean contains(Word word) {
        return node.contains(word);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new TreeWordIterator();
    }

    private class TreeWordIterator implements Iterator<Word>
    {
        Node next;
        @Override
        public Word next()//start att smallest
        {
            return next.value;
        }

        @Override
        public boolean hasNext()
        {
            return next != null;
        }
    }

    private class Node
    {
        Node left, right;
        Word value;
        public Node(Word w)
        {
            value = w;
        }

        private boolean contains(Word w)
        {
            if(value.compareTo(w) == 0)
            {
                return true;
            }
            else if(value.compareTo(w) < 0 && left != null)
            {
                return left.contains(w);
            }
            else if(value.compareTo(w) > 0 && left != null)
            {
                return right.contains(w);
            }
            return false;
        }

        private void add(Word w)
        {
            if(value.compareTo(w) < 0)
            {
                if(left == null)
                {
                    left = new Node(w);
                }
                else
                {
                    left.add(w);
                }
            }
            else if(value.compareTo(w) > 0)
            {
                if(right == null)
                {
                    right = new Node(w);
                }
                else
                {
                    right.add(w);
                }
            }
        }
    }
}
