package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    private static Object BufferedReader;

    public static void main(String[] args) throws IOException {

        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        String line = reader.readLine();
        PrintStream printStream = new PrintStream("sum-chars-whole-text.txt");
        int sum = 0;
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = reader.readLine();
        }
        printStream.println(sum);
    }
}
