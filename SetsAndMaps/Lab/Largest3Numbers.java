package SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (sorted.size() > 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(sorted.get(i) + " ");
            }
        } else {
            System.out.print(sorted.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
