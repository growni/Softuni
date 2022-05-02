package FunctinalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (int numberInList : list) {
                if(number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int number = 1; number <= n; number++) {
            if(isDivisible.apply(number, numbers)) {
                System.out.println(number);
            }
        }
    }
}
