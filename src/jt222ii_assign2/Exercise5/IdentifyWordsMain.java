package jt222ii_assign2.Exercise5;

import java.io.FileWriter;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
/**
 * Created by jonastornfors on 2016-09-19.
 */
public class IdentifyWordsMain {

    public IdentifyWordsMain()
    {

    }

    public static void main(String args[])
    {
        if(args.length < 1)
        {
            throw new IllegalArgumentException("Please set arguments for the method.");
        }
        IdentifyWordsMain idWMain = new IdentifyWordsMain();
        idWMain.readFile(args[0]);
    }

    public void readFile(String path)
    {
        String contentWithoutNumbers = "";
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            try {
                String text = new String(Files.readAllBytes(Paths.get(path)));
                for (char c : text.toCharArray()) {
                    if(Character.isLetter(c) || Character.isWhitespace(c))
                    {
                        contentWithoutNumbers += c;
                    }
                }
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        String newPath = f.getParentFile().getPath()+"/words.txt";
        try
        {
            FileWriter writer = new FileWriter(newPath);
            writer.write(contentWithoutNumbers);
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
