package FunctinalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }
        String criteria = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Map.Entry<String, Integer>> agePredicate = e -> {
            if(criteria.equals("older")) {
                return e.getValue() >= age;
            } else {
                return e.getValue() <= age;
            }
        };
        Consumer<Map.Entry<String, Integer>> formatter = e -> {
            if(format.equals("name")) {
                System.out.println(e.getKey());
            } else if(format.equals("age")) {
                System.out.println(e.getValue());
            } else {
                System.out.println(e.getKey() + " - " + e.getValue());
            }
        };

        people.entrySet().stream().filter(agePredicate).forEach(formatter);
    }
}
