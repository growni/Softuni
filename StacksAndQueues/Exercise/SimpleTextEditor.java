package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();
        StringBuilder dummy = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(dummy.toString());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scan.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    //append text
                    String appendText = command[1];
                    text.append(appendText);
                    stack.push(text.toString());
                    break;
                case "2":
                    //erase N elements
                    int elementsToRemove = Integer.parseInt(command[1]);
                    int startIndex = text.length() - elementsToRemove;
                    int endIndex = text.length();
                    text.replace(startIndex, endIndex, "");
                    stack.push(text.toString());
                    break;
                case "3":
                    // return element at given position
                    int indexPointer = Integer.parseInt(command[1]);
                    char symbol = text.charAt(indexPointer - 1);
                    System.out.println(symbol);

                    break;
                case "4":
                    //undo last command
                    String lastElement = stack.peek();
                    stack.pop();
                    text.replace(0, text.length(), stack.peek());
                    break;
            }
        }
    }
}
