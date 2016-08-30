package jt222ii_assign1.Arrays;

import java.util.Collections;
/**
 * Created by Jonas on 2016-08-29.
 */
public class Arrays {

    public static int sum(int[] arr)//Method return the sum of the array
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public static String toString(int[] arr)//Method returns a nice looking print out of the array content
    {
        String string = "";
        for (int i = 0; i < arr.length; i++)
        {
            string += "\n[" + i + "]" + " = " + arr[i];
        }
        return string;
    }

    public static int[] addN(int[] arr, int n)//Method that returns, an array where we have added the number n to all elements in the array arr. For example, in the case addN({1,2,3,4,5}, 2) the result is an array {3,4,5,6,7}.
    {
        int[] newArray = arr.clone();
        for (int i = 0; i < newArray.length; i++)
        {
            newArray[i] += n;
        }
        return newArray;
    }

    public static int[] reverse(int[] arr) //Method that creates, and returns, a new array with all the elements in array arr but in reverse order. The array arr should be left unchanged.
    {
        int[] newArray = new int[arr.length];
        for (int i = 0; i < newArray.length; i++)
        {
            newArray[i] = arr[arr.length-1-i];
        }
        return newArray;
    }

    public static void replaceAll(int[] arr, int old, int nw)//Method that replaces all occurences of the element old with nw in arr.
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == old)
            {
                arr[i] = nw;
            }
        }
    }

    public static int[] sort(int[] arr)//Method that returns a new sorted array (smallest element first) with the same set of elements as in arr. The array arr should be left unchanged.
    {
        int[] newArray = arr.clone();
        java.util.Arrays.sort(newArray);
        return newArray;
    }

    public static boolean hasSubsequence(int[] arr, int[] sub)//Method that returns true if the subsequence sub is a part of the array arr, otherwise false.
    {
        if(arr.length < sub.length)
        {
            System.out.println("Can't look for a sequence larger than the array you're searching in!");
            return false;
        }
        for (int i = 0; i < arr.length; i++)
        {
            for (int y = 0; y < sub.length; y++)//if a match is found keep looking if it is a sequence
            {
                if(sub[y] != arr[i+y])
                {
                    break;
                }
                else if(y == sub.length-1)//if the loop was not broken the sequence was found.
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] absDif(int[] arr1, int[] arr2)// returns a new array that is the absolute difference between array arr1 and array arr2. That is result array dist(i) = |arr1(i) - arr2(i)|.
    {
        if(arr1.length != arr2.length) // in case they are different the method should throw an exception
        {
            throw new IllegalArgumentException("The arrays must be the same size!");
        }
        int[] newArray = new int[arr1.length];
        for (int i = 0; i < newArray.length; i++)
        {
            newArray[i] = Math.abs(arr1[i]-arr2[i]);//set the value of newArray[i] to the absolute of arr1[i]-arr2[i]
        }
        return newArray;
    }
}
