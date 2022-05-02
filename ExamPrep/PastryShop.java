package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] liquids = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Map<String, Integer> products = new LinkedHashMap<>();
        products.put("Biscuit", 0);
        products.put("Cake", 0);
        products.put("Pie", 0);
        products.put("Pastry", 0);

        for (int liquid : liquids) {
            queueLiquids.offer(liquid);
        }
        for (Integer ingredient : ingredients) {
            stackIngredients.push(ingredient);
        }

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            if (queueLiquids.peek() + stackIngredients.peek() == 100) {
                products.put("Pie", products.get("Pie") + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 75) {
                products.put("Pastry", products.get("Pastry") + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 50) {
                products.put("Cake", products.get("Cake") + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (queueLiquids.peek() + stackIngredients.peek() == 25) {
                products.put("Biscuit", products.get("Biscuit") + 1);
                queueLiquids.poll();
                stackIngredients.pop();
            } else {
                queueLiquids.poll();
                int currentIngredient = stackIngredients.pop();
                stackIngredients.push(currentIngredient + 3);
            }
        }
        boolean noSuccess = false;
        for (Integer value : products.values()) {
            if(value == 0) {
                noSuccess = true;
                break;
            }
        }
        if (!noSuccess) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");

        } else {
            System.out.print("Liquids left: ");
            for (Integer liquid : queueLiquids) {
                if (queueLiquids.size() == 1) {
                    System.out.print(queueLiquids.pop() + "\n");
                } else {
                    System.out.print(queueLiquids.pop() + ", ");
                }
            }
        }
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            for (Integer ingredient : stackIngredients) {
                if (stackIngredients.size() == 1) {
                    System.out.print(stackIngredients.pop() + "\n");
                } else {
                    System.out.print(stackIngredients.pop() + ", ");
                }
            }
        }

        products.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }
}
