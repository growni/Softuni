package ExamPrep;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] ingredients = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freshness = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        for (int ingredient : ingredients) {
            queueIngredients.offer(ingredient);
        }
        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();
        for (int f : freshness) {
            stackFreshness.push(f);
        }
        Map<String, Integer> readyCocktails = new TreeMap<>();
        while (queueIngredients.size() > 0 && stackFreshness.size() > 0) {
            int currentFreshness = queueIngredients.peek() * stackFreshness.peek();

            if(queueIngredients.peek() == 0) {
                queueIngredients.poll();
                continue;
            }
            boolean canMakeIt = false;
            if(currentFreshness == 400) {
                canMakeIt = true;
                if(readyCocktails.containsKey("High Fashion")) {
                    readyCocktails.put("High Fashion", readyCocktails.get("High Fashion") + 1);
                } else {
                readyCocktails.put("High Fashion", 1);
                }
            } else if(currentFreshness == 300) {
                canMakeIt = true;
                if(readyCocktails.containsKey("Apple Hinny")) {
                    readyCocktails.put("Apple Hinny", readyCocktails.get("Apple Hinny") + 1);
                } else {
                readyCocktails.put("Apple Hinny", 1);
                }
            } else if(currentFreshness == 250) {
                canMakeIt = true;
                if(readyCocktails.containsKey("The Harvest")) {
                    readyCocktails.put("The Harvest", readyCocktails.get("The Harvest") + 1);
                } else {
                readyCocktails.put("The Harvest", 1);
                }
            } else if(currentFreshness == 150) {
                canMakeIt = true;
                if(readyCocktails.containsKey("Pear Sour")) {
                    readyCocktails.put("Pear Sour", readyCocktails.get("Pear Sour") + 1);
                } else {
                readyCocktails.put("Pear Sour", 1);
                }
            } else {
                int topElement = queueIngredients.peek();
                queueIngredients.offerLast(topElement + 5);
                queueIngredients.poll();
                stackFreshness.pop();
            }
            if(canMakeIt) {
                stackFreshness.pop();
                queueIngredients.poll();
            }
        }
        if(readyCocktails.size() >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if(!queueIngredients.isEmpty()) {
            int sum = 0;
            while (!queueIngredients.isEmpty()) {
                sum += queueIngredients.peek();
                queueIngredients.poll();
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        readyCocktails.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }
}
