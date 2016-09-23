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
    public String toString()//returns a string with all words in alphabetical order
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
    public void add(Word word) //adds a word to the set
    {
        Node n = new Node(word);
        if(headNode == null)//if its the first word (and headnode therefore null) make the new word the root (head)
        {
            headNode = n;
            size++;
        }
        else if(!contains(word))//if the word is not already added add it to the headnode(will be placed at its correct position)
        {
            headNode.add(word);
            size++;
        }
    }

    @Override
    public boolean contains(Word word) //returns true of the word already exists. Searching through the elements starting at the head
    {
        return headNode.contains(word);
    }

    @Override
    public int size() //returns the amount of words added to the set
    {
        return size;
    }

    @Override
    public Iterator iterator()
    {
        return new TreeWordIterator();
    }

    private class TreeWordIterator implements Iterator<Word>
    {
        Node next;
        public TreeWordIterator()//when instantiated next should be the left most node in the tree
        {
            if(next == null && size != 0)
            {
                next = headNode.getLeftMost();//gets the left most node of headnode (and left most of the entire tree)
            }
        }

        @Override
        public Word next()//start at smallest
        {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't get next when next does not exist!");
            }
            Node toReturn = next;//save the next node before changing it so that you can return the correct value.
            if (next.right == null)//if the current-next node does not have a right element go up one step(to the "next"-nodes parent)
            {
                Node currentNode = next;
                //if the parent of the current-next is to the upper left(so that next is its right child) the parent has already been visited.
                //Keep going up until a non-visited parent or the headnode is found.
                while (currentNode.parent != null && currentNode == currentNode.parent.right)
                {
                    currentNode = currentNode.parent;
                }
                next = currentNode.parent;
            }
            else if(next.right != null)//if the current next-node has a right get the lowest value of its subtree
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

        private boolean contains(Word w)//searches through the tree to see if w is already in it. This function will call the same function of other nodes
        {
            if(w.compareTo(value) == 0)//if value and w returns 0 with the compareTo function they are the same
            {
                return true;
            }
            else if(w.compareTo(value) < 0)//if <0 the word might be in the left subtree
            {
                if(left == null)//if left is null the word does not exist in the tree
                {
                    return false;
                }
                else
                {
                    return left.contains(w);//check if left contains the word
                }
            }
            else if(w.compareTo(value) > 0)//if >0 the word might be in the right subtree
            {
                if(right == null)//if right is null the word does not exist in the tree
                {
                    return false;
                }
                else//if right is not null keep looking in the right subtree
                {
                    return right.contains(w); //check if right contains the word
                }
            }
            return false;
        }

        private void add(Word w)//Adds the word to the tree. This function will call the same function of other nodes to find the right spot for the new word to be.
        {
            if(w.compareTo(value) < 0) //if the word is less than value of this node it is smaller and should be to the left
            {
                if(left == null)//if current node has no left that is where the new word should be. Sets left to the new node containing the new word
                {
                    left = new Node(w);
                    left.parent = this;
                }
                else//if the node already has a left. Try adding word to that instead
                {
                    left.add(w);
                }
            }
            else if(w.compareTo(value) > 0)
            {
                if(right == null)//if current node has no right that is where the new word should be. Sets right to the new node containing the new word
                {
                    right = new Node(w);
                    right.parent = this;
                }
                else//if the node already has a right. Try adding the word to that instead
                {
                    right.add(w);
                }
            }
        }

        private Node getLeftMost()//returns the left most element from the node. (if it doesn't have a left the node itself is leftmost)
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
