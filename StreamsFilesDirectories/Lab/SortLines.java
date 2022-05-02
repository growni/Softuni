package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Path path = Paths.get(fileName);
        
        List<String> lines = Files.readAllLines(path);
        PrintStream printStream = new PrintStream("sorted-text.txt");
        Collections.sort(lines);
        for (String line : lines) {
            printStream.println(line);
        }
    }
}
