package jt222ii_assign2.Exercise5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jonastornfors on 2016-09-21.
 */
public class TreeWordSet implements WordSet {
    Node headNode;
    static int size = 0;

    @Override
    public String toString()
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
    public void add(Word word) {
        Node n = new Node(word);
        if(headNode == null)
        {
            headNode = n;
            size++;
        }
        else if(!contains(word))
        {
            headNode.add(word);
            size++;
        }
    }

    @Override
    public boolean contains(Word word) {
        return headNode.contains(word);
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

        public TreeWordIterator()
        {
            if(next == null && size != 0)
            {
                next = headNode.getLeftMost();
            }
        }

        @Override
        public Word next()//start att smallest
        {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't get next when next does not exist!");
            }
            Node toReturn = next;
            if (next.right == null)
            {
                Node currentNode = next;
                while (currentNode.parent != null && currentNode == currentNode.parent.right) {
                    currentNode = currentNode.parent;
                }
                next = currentNode.parent;
            }
            else if(next.right != null)
            {
                next = next.right.getLeftMost();
            }
            return toReturn.value;
        }

        @Override
        public boolean hasNext()
        {
            return next != null;
        }
    }

    private class Node
    {
        private Node left = null, right = null, parent = null;
        private Word value;
        public Node(Word w)
        {
            value = w;
        }

        private Word Value()
        {
            return value;
        }

        private boolean contains(Word w)
        {
            if(w.compareTo(value) == 0)
            {
                return true;
            }
            else if(w.compareTo(value) < 0)
            {
                if(left == null)
                {
                    return false;
                }
                else
                {
                    return left.contains(w);
                }
            }
            else if(w.compareTo(value) > 0)
            {
                if(right == null)
                {
                    return false;
                }
                else
                {
                    return right.contains(w);
                }
            }
            return false;
        }

        private void add(Word w)
        {
            if(w.compareTo(value) < 0)
            {
                if(left == null)
                {
                    left = new Node(w);
                    left.parent = this;
                }
                else
                {
                    left.add(w);
                }
            }
            else if(w.compareTo(value) > 0)
            {
                if(right == null)
                {
                    right = new Node(w);
                    right.parent = this;
                }
                else
                {
                    right.add(w);
                }
            }
        }

        private Node getLeftMost()
        {
            Node n = this;
            while(n.left != null)
            {
                n = n.left;
            }
            return n;
        }
    }
}
