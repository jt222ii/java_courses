package jt222ii_assign1;


import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by jonastornfors on 2016-08-29.
 */
public class CountChars {

    public static BufferedReader bReader;
    public static Scanner scan = new Scanner(System.in);
    public static void main (String args[])
    {

        String path = getPathFromUser("Enter the path to your txt file: ");
        readFileAndCount(path);

    }

    public static String getPathFromUser(String message)
    {
        while (true)
        {
            try
            {
                System.out.println(message);
                String input = scan.nextLine();
                return input;
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
                scan.next();
            }
        }
    }

    public static void readFileAndCount(String path)
    {
        int whitespaces = 0, upperCaseLetters = 0, lowerCaseLetters = 0, numbers = 0, other = 0;
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            try{
                for (String line : Files.readAllLines(Paths.get(path))) {
                    for(char c : line.toCharArray()){
                        if(Character.isDigit(c))
                        {
                            numbers++;
                        }
                        else if(Character.isWhitespace(c))
                        {
                            whitespaces++;
                        }
                        else if(Character.isLowerCase(c))
                        {
                            lowerCaseLetters++;
                        }
                        else if(Character.isUpperCase(c))
                        {
                            upperCaseLetters++;
                        }
                        else
                        {
                            other++;
                        }
                    }

                }
                System.out.println(
                        "Numbers: " + numbers + "\n"+
                                "Upper case letters: " + upperCaseLetters + "\n"+
                                "Lower case letters: " + lowerCaseLetters + "\n"+
                                "Whitespaces: " + whitespaces + "\n"+
                                "Other: " + other
                );
            }
            catch(Exception e)
            {
                System.out.println("Something went wrong while reading the file!");
                return;
            }
        }
        else
        {
            System.out.println("File not found!");
        }


    }
}
