package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of(path)));

        String line = reader.readLine();
        PrintStream printStream = new PrintStream("all-capitals.txt");

        while (line != null) {
            printStream.println(line.toUpperCase(Locale.ROOT));
            line = reader.readLine();
        }
    }
}
