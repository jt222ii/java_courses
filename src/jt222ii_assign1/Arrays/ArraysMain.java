package jt222ii_assign1.Arrays;

/**
 * Created by Jonas on 2016-08-30.
 */
public class ArraysMain {
    public static void main (String args[])
    {
        int[] intArray = {1,2,3,4,5};
        System.out.println("sum:");
        System.out.println("sum of {1,2,3,4,5} = " + Arrays.sum(intArray));

        System.out.println("toString:");
        System.out.println("Array as string ="+Arrays.toString(intArray));

        System.out.println("addN:");
        System.out.println("{1,2,3,4,5} with 2 added to each element = "+Arrays.toString(Arrays.addN(intArray, 2)));


        System.out.println("reverse:");
        System.out.println("{1,2,3,4,5} reversed = "+Arrays.toString(Arrays.reverse(intArray)));

        System.out.println("replaceAll:");
        Arrays.replaceAll(intArray, 5, 40);
        System.out.println("{1,2,3,4,5} with 40 replacing 5 = "+Arrays.toString(intArray));

        int[] unsortedArray = {5,2,1,19};
        System.out.println("sort:");
        System.out.println("{5,2,1,19} sorted = "+Arrays.toString(Arrays.sort(unsortedArray)));

        System.out.println("hasSubsequence(looking for {1,2,3,4} in {13,3,4,1,2,3,4}):");
        int[] mainArray = {13,3,4,1,2,3,4};
        int[] subArray = {1,2,3,4};
        System.out.println(Arrays.hasSubsequence(mainArray, subArray));

        System.out.println("absDif:");
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,1,1,1,1};
        try {
            System.out.println("using ({1,2,3,4,5}, {1,1,1,1,1}). Result should be {0,1,2,3,4}" + Arrays.toString(Arrays.absDif(arr1, arr2)));
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
