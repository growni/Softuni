package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] setsLength = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int firstSetL = setsLength[0];
        int secondSetL = setsLength[1];
        LinkedHashSet<Integer> setFirst = new LinkedHashSet<>();
        LinkedHashSet<Integer> setSecond = new LinkedHashSet<>();

        for (int i = 0; i < firstSetL; i++) {
            setFirst.add(Integer.parseInt(scan.nextLine()));
        }
        for (int i = 0; i < secondSetL; i++) {
            setSecond.add(Integer.parseInt(scan.nextLine()));
        }

        printSets(setFirst, setSecond, firstSetL, secondSetL);
    }

    public static void printSets (LinkedHashSet<Integer> first, LinkedHashSet<Integer> second, int fLength, int sLength) {
        if(fLength < sLength) {
            for (Integer integer : second) {
                if(first.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        } else {
            for (Integer integer : first) {
                if(second.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        }
    }
}
