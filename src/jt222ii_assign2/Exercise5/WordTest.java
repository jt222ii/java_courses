package jt222ii_assign2.Exercise5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 2016-09-24.
 */
public class WordTest {
    @Test
    public void testToString() throws Exception {
        Word word = new Word("Test");
        assertEquals("Test", word.toString());
    }

    @Test
    public void testHashCode() throws Exception {
        //hashcodes should be same
        Word word1 = new Word("Test");
        Word word2 = new Word("tsET");
        assertEquals(word1.hashCode(), word2.hashCode());

        //hashcodes should not be same
        Word word3 = new Word("Test");
        Word word4 = new Word("toot");
        assertNotEquals(word3.hashCode(), word4.hashCode());
    }

    @Test
    public void equals() throws Exception {
        //Should not be case sensitive
        Word word1 = new Word("TeSt");
        Word word2 = new Word("tEsT");
        assertTrue(word1.equals(word2));
    }

    @Test
    public void compareTo() throws Exception {

        //b should be larger than a(positive)
        Word word1 = new Word("a");
        Word word2 = new Word("b");
        assertTrue(word2.compareTo(word1) > 0);

        //ABCD should be smaller than DFEG(negative)
        Word word3 = new Word("ABCD");
        Word word4 = new Word("DFEG");
        assertTrue(word3.compareTo(word4) < 0);

        //ABc should be same as ABC(0)
        Word word5 = new Word("ABc");
        Word word6 = new Word("ABC");
        assertTrue(word5.compareTo(word6) == 0);
    }

}