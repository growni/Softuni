package SetsAndMaps.Lab;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readDeck(scan.nextLine());
        LinkedHashSet<Integer> secondDeck = readDeck(scan.nextLine());

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if(firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            } else {
                firstDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if(firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }

        }
        if(secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else if(firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }



    private static int getFirst (LinkedHashSet<Integer> set) {

        return set.stream().findFirst().orElse(0);
    }

    private static LinkedHashSet<Integer> readDeck(String scan) {
        return Arrays.stream(scan.split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
