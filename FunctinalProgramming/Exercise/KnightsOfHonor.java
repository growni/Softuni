package FunctinalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] names = scan.nextLine().split("\\s+");
        Consumer<String> printNames = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printNames);
    }
}
