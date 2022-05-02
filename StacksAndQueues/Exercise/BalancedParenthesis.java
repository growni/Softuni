package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean areEqual = false;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openingBrackets.push(currentSymbol);
            }
            else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {

                if(openingBrackets.isEmpty()) {
                    areEqual = false;
                    break;
                }
                char lastOpened = openingBrackets.pop();

                if(lastOpened == '(' && currentSymbol == ')') {
                    areEqual = true;
                }
                else if(lastOpened == '{' && currentSymbol  == '}') {
                    areEqual = true;
                }
                else if(lastOpened == '[' && currentSymbol == ']') {
                    areEqual = true;
                } else {
                    areEqual = false;
                    break;
                }
            }
        }

        if(areEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
