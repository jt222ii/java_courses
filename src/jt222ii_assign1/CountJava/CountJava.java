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
        if(args.length != 0)
        {
            System.out.println(args[0]);//prints out the path
            addFilesToList(args[0]);//gets all the files in the directory and subdirectories and puts them into the list
            printFileInfo();//prints the line counts of all files
        }
        else
            System.err.println("Please set program argument!");

    }

    public static void addFilesToList(String path)//adds all the .java files to the list.
    {
        File directory = new File(path);
        if(!directory.isDirectory())
        {
            System.err.println("not a directory!");
            return;
        }
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

    public static void printFileInfo()//prints out the line count of the files in the list.
    {
        int number = 0;
        for(File file: files)
        {
            number++;
            System.out.println(number+": "+file.getName()+": "+countLinesOfFile(file));
        }
    }

    public static int countLinesOfFile(File file)//Counts the lines of the specified file
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
            System.err.println("Something went wrong while reading the file!");
        }
        return count;
    }
}
