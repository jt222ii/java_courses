package jt222ii_assign1.LargestK;

import java.util.Scanner;

/**
 * Created by Jonas on 2016-08-28.
 */
public class LargestK {
    static Scanner scan = new Scanner(System.in);

    public static void main (String args[])
    {
        int k = 0;
        int n = readInt();
        int sum = 0;

        while(sum+k+2 <= n)
        {
            k += 2;
            sum += k;
        }

        System.out.println("LargestK: "+k);
    }

    public static int readInt()
    {
        while (true)
        {
            try
            {
                System.out.println("Input positive int: ");
                int input = scan.nextInt();
                if (input < 0)
                {
                    System.err.println("Please input a positive integer!");
                }
                else
                {
                    return input;
                }
            }
            catch(Exception e)
            {
                System.err.println("Invalid input");
                scan.next();
            }
        }
    }
}
