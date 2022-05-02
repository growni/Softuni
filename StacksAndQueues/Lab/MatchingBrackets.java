package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();


            int startIndex = 0;
            int endIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if(symbol == '(') {
                 startIndex = i;
                stack.push(symbol);
            } else if(symbol == ')') {

                stack.push(symbol);
                endIndex = i;
                if(stack.peekFirst() != stack.peekLast()) {
                    String substring = input.substring(startIndex, endIndex);
                    System.out.println(substring);
                }
            }
        }
    }
}
