package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            stackNumbers.push(number);
        }
        for (Integer stackNumber : stackNumbers) {
            System.out.printf("%d ", stackNumber);
        }
    }
}
