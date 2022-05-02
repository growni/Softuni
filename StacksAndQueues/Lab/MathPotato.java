package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        int fireToss = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queueKids = new ArrayDeque();

        for (String queueKid : kids) {
            queueKids.offer(queueKid);
        }

            int tossCounter = 1;
        while (queueKids.size() > 1) {

            for (int i = 1; i < fireToss; i++) {
                queueKids.offer(queueKids.poll());
            }

            if (isPrime(tossCounter)) {
                System.out.printf("Prime %s%n", queueKids.peek());
            } else {
                System.out.printf("Removed %s%n", queueKids.poll());
            }
            tossCounter++;
        }
        System.out.println("Last is " + queueKids.poll());
    }

    public static boolean isPrime (int num) {

        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
