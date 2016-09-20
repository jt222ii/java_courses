package jt222ii_assign2.Exercise5;

import java.io.File;
import java.util.*;

/**
 * Created by jonastornfors on 2016-09-20.
 */
public class WordCount1Main {

    private static Set<Word> wordHashSet = new HashSet();
    private static Set<Word> wordTreeSet = new TreeSet();

    /*For each word in word.txt: 1) Create a Word object, and add it to 2) a HashSet
    and 3) a TreeSet. The size of the two sets should be the number of different words in
    word.txt. Iteration over TreeSet should give words in alphabetical order.*/
    public static void main(String args[])
    {
        if(args.length < 1)
        {
            throw new IllegalArgumentException("Please set arguments for the method.");
        }

        try
        {
            Scanner scanner = new Scanner(new File(args[0]));
            while(scanner.hasNext())
            {
                Word word = new Word(scanner.next());
                wordHashSet.add(word);
                wordTreeSet.add(word);
            }
            scanner.close();
            System.out.println("HashSet size: "+wordHashSet.size());
            System.out.println("TreeSet size: "+wordTreeSet.size());

            //Treeset should be ordered
            Iterator iterator = wordTreeSet.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        }
        catch(Exception e)
        {
            System.err.println("Error while reading the file: "+e.getMessage());
        }
    }
}
