package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        int fireToss = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queueKids = new ArrayDeque();

        for (String kid : kids) {
            queueKids.offer(kid);
        }

        int tossCounter = 0;
        while (queueKids.size() > 1) {
            for (String queueKid : queueKids) {

                tossCounter++;
              //  String currentKid = queueKid;
                if (tossCounter == fireToss) {
                    if(isPrime(tossCounter)) {
                        System.out.printf("Prime %s%n", queueKid);
                    } else {
                        System.out.printf("Removed %s%n", queueKids.peek());
                        queueKids.poll();

                        break;
                    }
                } else {
                    queueKids.offer(queueKid);
                    queueKids.poll();
                }
            }

        }
        System.out.printf("Last is %s", queueKids.peek());
    }

    public static boolean isPrime (int number) {

        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
            if (counter > 2) {
                return false;
            }
        }

        return true;
    }
}
