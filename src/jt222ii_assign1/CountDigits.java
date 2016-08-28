package jt222ii_assign1;

import java.util.Scanner;

/**
 * Created by Jonas on 2016-08-28.
 */
public class CountDigits {
    static Scanner scan = new Scanner(System.in);

    public static void main (String args[])
    {
        int number = readInt();
        int zeroes=0, odd=0, even=0, sum=0;
        String string = String.valueOf(number);
        for (char c: string.toCharArray())
        {
            int n = Character.getNumericValue(c);
            if(n == 0)
            {
                zeroes++;
            }
            else if(n % 2 == 0)
            {
                even++;
            }
            else
            {
                odd++;
            }
            sum+=n;
        }
        System.out.println(
            "Zeroes: " + zeroes+"\n"+
            "Odd: " + odd + "\n"+
            "Even: " + even + "\n" +
            "Sum: " + sum
        );
    }

    public static int readInt()
    {
        while (true)
        {
            try
            {
                System.out.println("Provide a positive integer: ");
                int input = scan.nextInt();
                if (input < 0)
                {
                    System.out.println("Please input a positive integer!");
                }
                else
                {
                    return input;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
                scan.next();
            }
        }
    }
}
