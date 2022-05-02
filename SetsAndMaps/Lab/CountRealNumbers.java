package SetsAndMaps.Lab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> grades = new LinkedHashMap<>();

        for (double grade : values) {
            if(grades.containsKey(grade)) {
                grades.put(grade, grades.get(grade) + 1);
            } else {
                grades.put(grade, 1);
            }
        }
        grades.forEach((grade, count) -> {
            System.out.printf("%.1f -> %d%n", grade, count);
        });
    }
}
