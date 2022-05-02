package FunctinalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scan.nextLine();

        int start = numbers[0];
        int end = numbers[1];

        for (int i = start; i < end; i++) {

        }


    }
}
