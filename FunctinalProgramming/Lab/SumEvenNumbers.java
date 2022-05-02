package FunctinalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");

        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr).map(Integer::parseInt);

        Function<Stream<Integer>, Long> count = str -> str.mapToInt(e -> e).count();

        Function<Stream<Integer>, Integer> sum = str -> str.mapToInt(e -> e).sum();

        System.out.println("Count = " + count.apply(map.apply(tokens)));
        System.out.println("Sum = " + sum.apply(map.apply(tokens)));
    }
}
