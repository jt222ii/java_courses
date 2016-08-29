package jt222ii_assign1;

import java.util.Scanner;
import java.util.Random;

/**
 * Created by Jonas on 2016-08-28.
 */
public class HighLow {
    static Scanner scan = new Scanner(System.in);

    public static void main (String args[])
    {
        boolean gameOver = false;
        boolean gameWon = false;
        int guessesLeft = 10;
        int guessNumber = 0;

        int max = 100, min = 1;

        int secretNumber = generateOddRandomNumber(max, min);
        System.out.println("Guess the odd number between 1-100");
        while(!gameOver && !gameWon)
        {
            guessNumber++;
            int guess = readInt("Guess "+guessNumber+": ");
            if(guess == secretNumber)
            {
                gameWon = true;
            }
            else
            {
                guessesLeft--;
                if(guessesLeft<=0)
                {
                    gameOver = true;
                }
                else if(guess < secretNumber)
                {
                    System.out.println("hint: higher");
                }
                if(guess > secretNumber)
                {
                    System.out.println("hint: lower");
                }
            }
        }
        if(gameOver)
        {
            System.out.println("Failed to guess the secret number " + secretNumber);
        }
        if(gameWon)
        {
            System.out.println("Correct after only " + guessNumber + " guesses!");
        }
    }
    public static int generateOddRandomNumber(int max, int min)
    {
        if (min % 2 == 0) //Minimum value needs to be odd.
        {
            min++;
        }
        //randoms 0 - <1 and multiplies it by the integer ((maximum-minimum)/2+1) also makes the result an integer with (int).
        //then multiplies that with 2 and adds the minimum value to get a value within the given range.
        return (int)(Math.random()*((max-min)/2+1)) * 2 + min;
    }
    public static int readInt(String message)
    {
        while (true)
        {
            try
            {
                System.out.println(message);
                int input = scan.nextInt();
                if (input < 1 || input > 100)
                {
                    System.out.println("Please input a positive integer 1-100!");
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
