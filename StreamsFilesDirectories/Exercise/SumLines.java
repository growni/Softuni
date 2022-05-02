package StreamsFilesDirectories.Exercise;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));
            String line = reader.readLine();
            PrintStream printStream = new PrintStream("char-sum-line.txt");
            while (line != null) {
                int sum = 0;
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
                printStream.println(sum);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
