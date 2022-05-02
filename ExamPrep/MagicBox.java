package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstBox = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondBox = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueBox =  new ArrayDeque<>();
        for (int box : firstBox) {
            queueBox.offer(box);
        }
        ArrayDeque<Integer> stackBox = new ArrayDeque<>();
        for (int box : secondBox) {
            stackBox.push(box);
        }
        int claimedValue = 0;
        while (!queueBox.isEmpty() && !stackBox.isEmpty()) {
            int sum = queueBox.peek() + stackBox.peek();
            if(sum % 2 == 0) {
                queueBox.poll();
                stackBox.pop();
                claimedValue += sum;
            } else {
                int poppedStack = stackBox.pop();
                queueBox.addLast(poppedStack);
            }
        }
        if(queueBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if(stackBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if(claimedValue >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimedValue);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedValue);
        }
    }
}
