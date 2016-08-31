package jt222ii_assign1.CountJava;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jonastornfors on 2016-08-31.
 */
public class CountJava {

    static List<File> files = new ArrayList<>();
    public static void main (String args[])
    {
        System.out.println(args[0]);
        addFilesToList(args[0]);
        printFileInfo();
    }

    public static void addFilesToList(String path)
    {
        File directory = new File(path);
        File[] fileList = directory.listFiles();
        for (File file : fileList) {
            if (file.isFile() && file.getName().endsWith(".java"))
            {
                files.add(file);
            }
            else if (file.isDirectory())
            {
                addFilesToList(file.getAbsolutePath());
            }
        }
    }

    public static void printFileInfo()
    {
        int number = 0;
        for(File file: files)
        {
            number++;
            System.out.println(number+": "+file.getName()+": "+countLinesOfFile(file));
        }
    }

    public static int countLinesOfFile(File file)
    {
        int count = 0;
        try
        {
            Scanner scanner = new Scanner(file);
            while(true)
            {
                if(scanner.hasNextLine())
                {
                    count++;
                    scanner.nextLine();
                }
                else
                    break;
            }

        }
        catch(Exception e)
        {
            System.out.println("Something went wrong while reading the file!");
        }
        return count;
    }
}
