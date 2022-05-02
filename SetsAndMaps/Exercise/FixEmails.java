package SetsAndMaps.Exercise;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        LinkedHashMap<String, String> mapEmails = new LinkedHashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        LinkedHashMap<String, String> validMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            queue.offer(input);
            input = scan.nextLine();
        }
       
        while (!queue.isEmpty()) {
            mapEmails.put(queue.poll(), queue.poll());
        }
        for (Map.Entry<String, String> entry : mapEmails.entrySet()) {
            if(validateEmail(entry.getValue())) {
                validMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, String> entry : validMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }

    public static boolean validateEmail (String value) {
        String[] tokens = value.split("\\.");
        String domain = tokens[tokens.length - 1];
        if (domain.equalsIgnoreCase("com") || domain.equalsIgnoreCase("uk") || domain.equalsIgnoreCase("us")) {
            return false;
        }
        return true;
    }
}