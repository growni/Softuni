package StreamsFilesDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("numered-lines.txt");
        int number = 1;
        for (String line : lines) {
            writer.println(number + ". " + line);
            number++;
        }
        writer.close();
    }
}
