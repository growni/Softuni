package StreamsFilesDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scan = new Scanner(reader);

        PrintStream printStream = new PrintStream("every-third-line.txt");
        int count = 1;
        while (scan.hasNext()) {
            if (count % 3 == 0) {
                printStream.println(scan.nextLine());
            } else {
                scan.nextLine();
            }
            count++;
        }
    }
}
