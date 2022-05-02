package SetsAndMaps.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentsInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentsInfo.containsKey(student)) {
                studentsInfo.put(student, new ArrayList<>());
            }
            studentsInfo.get(student).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentsInfo.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)", getAvg(entry.getValue()));
            System.out.println();
        }
    }

    private static double getAvg (List<Double> grades) {
        double avg = 0;
        for (Double grade : grades) {
            avg += grade;
        }
        avg /= grades.size();
        return avg;
    }
}
