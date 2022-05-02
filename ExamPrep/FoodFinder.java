package ExamPrep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] inputVowels = scan.nextLine().replaceAll(" ", "").toCharArray();
        char[] inputConsonants = scan.nextLine().replaceAll(" ", "").toCharArray();
        ArrayDeque<Character> queueVowels = new ArrayDeque<>();
        for (char vowel : inputVowels) {
            queueVowels.offer(vowel);
        }
        ArrayDeque<Character> stackConsonants = new ArrayDeque<>();
        for (char consonant: inputConsonants) {
            stackConsonants.push(consonant);
        }
        List<String> words = new ArrayList<>();
        words.add("pear flour pork olive");
        List<String> savedLetters = new ArrayList<>();
        while (!stackConsonants.isEmpty()) {
            String vowel = queueVowels.peek().toString();
            String consonant = stackConsonants.peek().toString();

                if(words.get(0).contains(vowel) || words.get(0).contains(consonant)) {
                    savedLetters.add(vowel);
                    savedLetters.add(consonant);
                    queueVowels.addLast(queueVowels.poll());
                    stackConsonants.pop();
                } else {
                    stackConsonants.pop();
                    queueVowels.addLast(queueVowels.poll());
                }

        }
        List<String> finishedList = new ArrayList<>();
        if(savedLetters.contains("p") && savedLetters.contains("e") && savedLetters.contains("a") && savedLetters.contains("r")) {
            finishedList.add("pear");
        }
        if(savedLetters.contains("f") && savedLetters.contains("l") && savedLetters.contains("o") && savedLetters.contains("u") && savedLetters.contains("r")) {
            finishedList.add("flour");
        }
        if(savedLetters.contains("p") && savedLetters.contains("o") && savedLetters.contains("r") && savedLetters.contains("k")) {
            finishedList.add("pork");
        }
        if(savedLetters.contains("o") && savedLetters.contains("l") && savedLetters.contains("i") && savedLetters.contains("v") && savedLetters.contains("e")) {
            finishedList.add("olive");
        }
        System.out.printf("Words found: %d%n", finishedList.size());
        if(finishedList.size() > 0) {
            for (String word : finishedList) {
                System.out.println(word);
            }
        }
    }
}
