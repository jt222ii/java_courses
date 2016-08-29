package jt222ii_assign1;

import java.util.Scanner;

/**
 * Created by jonastornfors on 2016-08-29.
 */
public class Diamond {
    static Scanner scan = new Scanner(System.in);
    public static void main (String args[])
    {
        int n = readInt();
        createDiamond(n);
    }
    public static void createDiamond(int thickness)
    {
        int asteriskPerRow = 1;
        int thicknessIncrease = 2;
        for (int i = 0; i < thickness; i++)
        {
            for(int x = 0; x < (thickness-asteriskPerRow)/2; x++)//add the needed whitespaces
            {
                System.out.print(" ");
            }
            for (int y = 0; y < asteriskPerRow; y++)//add the needed asterisks
            {
                System.out.print("*");
            }
            asteriskPerRow += thicknessIncrease;//increase/decrease the amount of asterisks for the next row
            if(asteriskPerRow == thickness)//when the diamond has reached its maximum thickness it should taper instead
            {
                thicknessIncrease = -thicknessIncrease;
            }

            System.out.println();//new line
        }
    }
    public static int readInt()
    {
        while (true)
        {
            try
            {
                System.out.println("Provide a positive odd integer: ");
                int input = scan.nextInt();
                if (input < 0 || input % 2 == 0)
                {
                    throw new Exception("Did not enter a valid number!");
                }
                else
                {
                    return input;
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}
