package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scan.nextLine();

            switch (command) {
                case "2":
                    if(!stackNumbers.isEmpty()) {
                        stackNumbers.pop();
                    }
                    break;
                case "3":
                    System.out.println(findMaxElement(stackNumbers));
                    break;
                default:
                    String[] tokensCommand = command.split("\\s+");
                    int element = Integer.parseInt(tokensCommand[1]);
                    stackNumbers.push(element);
                    break;
            }
        }
    }


    public static int findMaxElement (ArrayDeque<Integer> stack)  {
        int maxElement = Integer.MIN_VALUE;

        for (Integer element : stack) {
            if(element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }
}
