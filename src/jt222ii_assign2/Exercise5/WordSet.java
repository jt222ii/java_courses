package jt222ii_assign2.Exercise5;

/**
 * Created by jonastornfors on 2016-09-21.
 */
public interface WordSet extends Iterable {
    public void add(Word word); // Add word if not already added
    public boolean contains(Word word); // Return true if word contained
    public int size(); // Return current set size
    public String toString(); // Print contained words
}

