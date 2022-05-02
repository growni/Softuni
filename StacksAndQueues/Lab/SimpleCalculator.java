package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Pattern patternNumber = Pattern.compile("(?<number>[0-9]+)");
        Matcher matcherNumber = patternNumber.matcher(input);
        Pattern patternOperator = Pattern.compile("(?<operator>\\+|\\-)");
        Matcher matcherOperator = patternOperator.matcher(input);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        while (matcherNumber.find()) {
            String numberFound = (matcherNumber.group("number"));
            numbers.add(Integer.parseInt(numberFound));
        }
        int sum = numbers.peek();
        while (matcherOperator.find()) {
            numbers.pop();
            int currentNum = numbers.peek();
            String operation = matcherOperator.group("operator");
            if (operation.equals("+")) {
                sum += currentNum;

            } else {
                sum -= currentNum;

            }
        }

        System.out.println(sum);
    }
}
