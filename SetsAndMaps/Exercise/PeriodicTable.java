package SetsAndMaps.Exercise;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        TreeSet<String> chemicalsSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scan.nextLine().split("\\s+");
            for (String element : elements) {
                chemicalsSet.add(element);
            }
        }
        for (String chemical : chemicalsSet) {
            System.out.print(chemical + " ");
        }
    }
}
