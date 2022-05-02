package SetsAndMaps.Exercise;

import com.sun.jdi.Value;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        TreeMap<Character, Integer> mapSymbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(mapSymbols.containsKey(currentSymbol)) {
                mapSymbols.put(currentSymbol, mapSymbols.get(currentSymbol) + 1);
            } else {
                mapSymbols.put(currentSymbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapSymbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
