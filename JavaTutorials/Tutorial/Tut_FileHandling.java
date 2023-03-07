package Tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tut_FileHandling  {
    private static String projPath = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        File file = new File(projPath + "/src/main/resources/Includes/text");

        //write into a file
        FileWriter writeIntoTheFile = new FileWriter(file);
        writeIntoTheFile.write(" This is a test entry");
        writeIntoTheFile.flush();
        writeIntoTheFile.close();

        //read the file contents
        Scanner fileContents = new Scanner(file);
        while(fileContents.hasNext()){
            System.out.println(fileContents.next());
        }
    }


}
