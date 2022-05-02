package SetsAndMaps.Exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            usernames.add(scan.nextLine());
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
