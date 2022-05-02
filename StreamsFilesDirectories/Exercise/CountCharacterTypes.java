package StreamsFilesDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "E:\\SoftuniResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int vowels = 0;
        int punctuation = 0;
        int consonants = 0;

        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {

            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }

                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                    vowels++;
                } else if (currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?') {
                    punctuation++;
                } else {
                    consonants++;
                }
            }
        }
        PrintStream printStream = new PrintStream("char-types.txt");
        printStream.println("Vowels: " + vowels);
        printStream.println("Consonants: " + consonants);
        printStream.println("Punctuation: " + punctuation);

        printStream.close();

    }
}
