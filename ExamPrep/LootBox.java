package ExamPrep;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputFirst = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputSecond = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queueFirst = new ArrayDeque<>();
        for (int i : inputFirst) {
            queueFirst.offer(i);
        }
        ArrayDeque<Integer> stackSecond = new ArrayDeque<>();
        for (int i : inputSecond) {
            stackSecond.push(i);
        }
        int sum = 0;
        List<Integer> claimedItems = new ArrayList<>();

        while (!queueFirst.isEmpty() && !stackSecond.isEmpty()) {
            sum = queueFirst.peek() + stackSecond.peek();
            if(sum % 2 == 0) {
                sum = queueFirst.poll() + stackSecond.pop();
                claimedItems.add(sum);
            } else {
                queueFirst.offerLast(stackSecond.pop());
            }
        }
        if(queueFirst.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if(stackSecond.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        int value = 0;
        for (Integer item : claimedItems) {
            value += item;
        }
        if(value >= 100) {
            System.out.printf("Your loot was epic! Value: %d", value);
        } else {
            System.out.printf("Your loot was poor... Value: %d", value);
        }
    }
}
