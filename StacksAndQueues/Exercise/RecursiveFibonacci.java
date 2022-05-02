package StacksAndQueues.Exercise;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<BigInteger> queue = new ArrayDeque<>();

        queue.offer(BigInteger.valueOf(1));
        queue.offer(BigInteger.valueOf(1));
        if(n < 2) {
            System.out.println(1);
            return;
        }
        while (n > 0) {

            BigInteger sum = queue.poll().add(queue.peekFirst());
            queue.offer(sum);
            n--;
        }
        System.out.println(queue.poll());

    }
}
