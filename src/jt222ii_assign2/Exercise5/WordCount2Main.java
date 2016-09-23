package jt222ii_assign2.Exercise5;

import java.io.File;
import java.util.*;

/**
 * Created by jonastornfors on 2016-09-22.
 */
public class WordCount2Main {

    private static TreeWordSet treeSet = new TreeWordSet();
    private static HashWordSet hashSet = new HashWordSet();
    public static void main(String args[])
    {
        if(args.length < 1)
        {
            throw new IllegalArgumentException("Please set arguments for the method.");
        }

        try
        {
            System.out.println(args[0]);
            Scanner scanner = new Scanner(new File(args[0]));

            while(scanner.hasNext())//add all the words to the sets
            {
                Word word = new Word(scanner.next());
                treeSet.add(word);
                hashSet.add(word);
            }
            scanner.close();
            Iterator iterator = treeSet.iterator();
            while(iterator.hasNext())//printing out all the words in treeset. Should be printed in alphabetical order
            {
                System.out.println(iterator.next());
            }
            System.out.println("TreeSet size: "+treeSet.size()+" HashSet size: "+hashSet.size());
        }
        catch(Exception e)
        {
            System.err.println("Error while reading the file: "+e.getStackTrace());
        }
    }
}
