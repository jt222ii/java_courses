package jt222ii_assign2.Exercise5;

/**
 * Created by jonastornfors on 2016-09-20.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) { word = str; }
    public String toString()
    {
        return word;
    }
    /* Override Object methods */
    public int hashCode()//returns the hash value of the word
    {
        String lowerCaseWord = word.toLowerCase();
        //"compute a hash value for word"
        int hc = 0;
        for (int i=0; i<lowerCaseWord.length(); i++)
        {
            char c = lowerCaseWord.charAt(i);
            hc += Character.getNumericValue(c);
        }
        return hc;
    }
    public boolean equals(Object other)//Checks if the words are equal.
    {
        if(other instanceof Word)
        {
            Word otherWord = (Word)other;
            return word.toLowerCase().equals(otherWord.word.toLowerCase()); //compare the two words. Making them both lowercase as it should not be case sensitive
        }
        return false;

    }
    /* Implement Comparable */
    public int compareTo(Word w)//compares the two words
    {
        return word.compareToIgnoreCase(w.word);
    }
}