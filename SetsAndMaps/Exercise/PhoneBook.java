package SetsAndMaps.Exercise;

import java.math.BigDecimal;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        HashMap<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {

            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.put(name, number);

            input= scan.nextLine();

        }
            input = scan.nextLine();
        while (!input.equals("stop")) {

            if(phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scan.nextLine();
        }
    }
}
