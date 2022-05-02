package FunctinalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> capitalWord = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(capitalWord).toArray(String[]::new);

        System.out.println(words.length);
        Arrays.stream(words).forEach(System.out::println);

    }
}
