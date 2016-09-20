package jt222ii_assign2.Exercise5;

/**
 * Created by jonastornfors on 2016-09-20.
 */
public class WordCount1Main {

    public static void main(String args[])
    {
        Word w1 = new Word("VafaaN");
        Word w2 = new Word("Vafaan");
        Word w3 = new Word("Vafalls");

        //should be true
        System.out.println(w1.equals(w2));
        System.out.println(w1.equals(w3));

        System.out.println(w1.compareTo(w2));
        System.out.println(w2.compareTo(w3));

    }
}
