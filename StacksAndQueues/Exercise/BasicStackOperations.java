package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int numbersToPush = Integer.parseInt(input[0]);
        int popNumbers = Integer.parseInt(input[1]);
        int checkElement = Integer.parseInt(input[2]);
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        String[] numbers = scan.nextLine().split("\\s+");
        // numbers to push in the stack
        for (int i = 0; i < numbersToPush; i++) {
            stackNumbers.push(Integer.parseInt(numbers[i]));
        }
        // numbers to pop in the stack
        for (int i = 0; i < popNumbers; i++) {
            stackNumbers.pop();
        }
        // check if the element is in the stack
        if (stackNumbers.isEmpty()) {
            System.out.println(0);
            return;
        }
        if(stackNumbers.contains(checkElement)) {
            System.out.println(true);
        } else {
            System.out.println(findSmallestElement(stackNumbers));
        }
    }


    public static int findSmallestElement (ArrayDeque<Integer> stack) {
        int smallestElement = Integer.MAX_VALUE;
        for (Integer number : stack) {
            if (number < smallestElement) {
                smallestElement = number;
            }
        }
        return smallestElement;
    }
}
