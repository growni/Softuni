package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tulipsInput = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] daffodilsInput = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        for (int tulip : tulipsInput) {
            tulips.push(tulip);
        }
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        for (int daffodil : daffodilsInput) {
            daffodils.offer(daffodil);
        }
        int sum = 0;
        int bouquets = 0;
        int leftovers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            sum = tulips.peek() + daffodils.peek();
            if(sum == 15) {
                bouquets++;
                tulips.pop();
                daffodils.poll();
            } else if(sum < 15) {
                leftovers += sum;
                tulips.pop();
                daffodils.poll();
            } else {
                int currentDaffodil = tulips.peek();
                tulips.pop();
                tulips.push(currentDaffodil - 2);
            }
        }
        leftovers /= 15;
        bouquets += leftovers;
        if(bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
