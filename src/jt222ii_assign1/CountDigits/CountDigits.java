package jt222ii_assign1.CountDigits;

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
        String string = String.valueOf(number);//converts the int to string so you can compare each char individually
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

    public static int readInt()//Gets an integer from the user
    {
        while (true)
        {
            try
            {
                System.out.println("Provide a positive integer: ");
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
