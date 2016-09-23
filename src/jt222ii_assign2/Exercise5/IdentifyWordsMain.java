package jt222ii_assign2.Exercise5;

import java.io.FileWriter;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
/**
 * Created by jonastornfors on 2016-09-19.
 */
public class IdentifyWordsMain {

    public static void main(String args[])
    {
        if(args.length < 1)
        {
            throw new IllegalArgumentException("Please set arguments for the method.");
        }
        readFile(args[0]);
    }

    public static void readFile(String path)
    {
        String contentWithoutNumbers = "";
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) //if file exists and is not a directory
        {
            try {
                String text = new String(Files.readAllBytes(Paths.get(path)));//read all bytes and add them to a string
                for (char c : text.toCharArray()) //for each char in the text
                {
                    if(Character.isLetter(c) || Character.isWhitespace(c))
                    {
                        contentWithoutNumbers += c; //add all letters and whitespaces
                    }
                }
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        String newPath = f.getParentFile().getPath()+"/words.txt";//get the parent of the read file and put the new file in the same path
        try
        {
            FileWriter writer = new FileWriter(newPath);
            writer.write(contentWithoutNumbers);//write the new content to the file
            writer.flush();
            writer.close();
            System.out.println("File words.txt created!");
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
