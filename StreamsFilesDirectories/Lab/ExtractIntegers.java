package StreamsFilesDirectories.Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileReader reader = new FileReader(path);

        Scanner scan = new Scanner(reader);

        while (scan.hasNext()) {
            if(scan.hasNextInt()) {
                System.out.println(scan.nextInt());
            }
            scan.next();
        }
    }
}
