package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, List<Double>> studentGrades =  new TreeMap<>();

        while (n-- > 0) {
            String name = scan.nextLine();
            String[] inputGrades = scan.nextLine().split("\\s+");
            List<Double> grades = new ArrayList<>();
            for (String grade : inputGrades) {
                grades.add(Double.parseDouble(grade));
            }

            studentGrades.put(name, grades);

        }

        studentGrades.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, getAverage(v)));
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();
    }
}
