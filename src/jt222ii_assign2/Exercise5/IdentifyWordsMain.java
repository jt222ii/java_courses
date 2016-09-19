package jt222ii_assign2.Exercise5;

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
        IdentifyWordsMain idWMain = new IdentifyWordsMain();
        idWMain.readFile("/Users/jonastornfors/Documents/Github/java_courses/src/jt222ii_assign2/Exercise5/HistoryOfProgramming.txt");
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

            }
        }
        File file = new File(IdentifyWordsMain.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "words.txt");
        file.mkdir();
        System.out.println(contentWithoutNumbers);
    }
}
