package jt222ii_assign1;

import java.util.Scanner; //http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Scanner.html
/**
 * Created by Jonas on 2016-08-28.
 */
public class Backwards {
    static Scanner scan = new Scanner(System.in);

    public static void main (String args[])
    {
        System.out.println("Type a line of text: ");
        String input = scan.nextLine();
        System.out.println("Backwards:" + new StringBuilder(input).reverse().toString()); //can also use stringbuffer instead of stringbuilder but its slower because it is synchronized.
    }
}
