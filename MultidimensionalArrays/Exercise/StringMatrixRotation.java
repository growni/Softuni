package MultidimensionalArrays.Exercise;

import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String degree = input.replaceAll("\\D+", "");
        Map<Integer, List<String>> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        int count = 1;
        while (!input.equals("END")) {
            input = scan.nextLine();
            String[] letters = input.split("");
            for (int i = 0; i < letters.length; i++) {
                list.add(letters[i]);
            }
            map.put(count, list);
            list.clear();

            count++;
        }
        System.out.println();
    }
}
