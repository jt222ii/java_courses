package jt222ii_assign1.Histogram;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Jonas on 2016-08-30.
 */
public class Histogram {

    public static void main (String args[]) throws Exception
    {
        try
        {
            if (args[0] != null) {
                List<Integer> integersFromDat = getIntegersFromDat(args[0]);
                createHistogram(integersFromDat);
            } else
                throw new Exception("Please set a directory!");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void createHistogram(List<Integer> integers)
    {
        String[] histogramRows = {"1-10   : ","11-20  : ","21-30  : ","31-40  : ","41-50  : ","51-60  : ","61-70  : ","71-80  : ","81-90  : ","91-100 : ","101-200: "};
        int intervalCount = 11;
        for (int i: integers)
        {
            for(int x = 0; x < intervalCount; x++)
            {
                if(x == intervalCount-1)
                {
                    if(i >= 101 && i <= 200)
                    {
                        histogramRows[x] += "*";
                    }
                }
                else if(i >= 1 + 10 * x && i <= 10 + 10 * x)
                {
                    histogramRows[x] += "*";
                }
            }
        }
        for (int i = 0; i < histogramRows.length; i++)
        {
            System.out.println(histogramRows[i]);
        }
    }

    public static List<Integer> getIntegersFromDat(String path)
    {
        List<Integer> integerList = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(new File(path));
            while (true)
            {
                if(scanner.hasNext())
                {
                    if (scanner.hasNextInt())//if next token is an int add it to the list
                    {
                        integerList.add(scanner.nextInt());
                    }
                    else//if its not an int continue scanning the file
                    {
                        scanner.next();
                    }
                }
                else//if scanner does not have another token. Stop the scanning
                    break;
            }
            scanner.close();
        }
        catch(Exception e)
        {
            System.err.println("Failed to open file!");
        }
        return integerList;
    }
}
