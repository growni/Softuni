package StreamsFilesDirectories.Lab;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Set<Character> separators = Set.of(',', '.', '!', '?');
            int nextByte = inputStream.read();
            PrintStream printStream = new PrintStream("E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

            while (nextByte != -1) {
                char symbol = (char)nextByte;
                if(!separators.contains(symbol)) {
                    printStream.print(symbol);
                }
                nextByte = inputStream.read();
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
