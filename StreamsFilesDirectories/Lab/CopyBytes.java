package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) {


        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        // the sequence of /r/n represents new line

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int nextByte = inputStream.read();
            PrintStream printStream = new PrintStream("E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\copy-bytes.txt");

            while (nextByte != -1) {
                if(nextByte == ' ') {
                    printStream.print((char) nextByte);
                } else if(nextByte == 10) {
                    printStream.println();
                } else{
                    printStream.print(nextByte);
                }
                nextByte = inputStream.read();
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
