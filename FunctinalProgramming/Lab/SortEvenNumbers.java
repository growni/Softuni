package FunctinalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).filter(number -> number % 2 == 0).toArray();

        Function<IntStream, String> formattedNumbers = str -> str.mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String functionalPrinting = formattedNumbers.apply(Arrays.stream(numbers));
        System.out.println(functionalPrinting);

        String sortedNumbers = formattedNumbers.apply(Arrays.stream(numbers).sorted());
        System.out.println(sortedNumbers);
    }
}
