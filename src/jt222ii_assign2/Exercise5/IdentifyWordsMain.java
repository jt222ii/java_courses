package jt222ii_assign2.Exercise5;

import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
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
        File dir = f.getParentFile();
        Path newFilePath = Paths.get(dir.getPath()+"/words.txt");
        try
        {
            if(!new File(newFilePath.toString()).isFile()) {
                Files.createFile(newFilePath);
            }
            Files.write(newFilePath, contentWithoutNumbers.getBytes());
            System.out.println("File words.txt created!");
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
