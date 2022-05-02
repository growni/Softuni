package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int offerNumbers = Integer.parseInt(input[0]);
        int pollNumbers = Integer.parseInt(input[1]);
        int checkElement = Integer.parseInt(input[2]);
        String[] elements = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();

        // offering elements in the queue
        for (String element : elements) {
            queueNumbers.offer(Integer.parseInt(element));
        }
        //removing elements from the queue
        for (int i = 0; i < pollNumbers; i++) {
            queueNumbers.poll();
        }
        //checking for queue
        if(queueNumbers.isEmpty()) {
            System.out.println(0);
            return;
        }

        if(queueNumbers.contains(checkElement)) {
            System.out.println(true);
        } else {
            System.out.println(findSmallestElement(queueNumbers));
        }
    }

    public static int findSmallestElement (ArrayDeque<Integer> queue) {
        int smallestElement = Integer.MAX_VALUE;
        for (Integer number : queue) {
            if (number < smallestElement) {
                smallestElement = number;
            }
        }
        return smallestElement;
    }
}
