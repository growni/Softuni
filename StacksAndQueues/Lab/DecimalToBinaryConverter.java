package StacksAndQueues.Lab;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimal = Integer.parseInt(scan.nextLine());
        Stack<Integer> binaryStack = new Stack<>();
        if(decimal == 0) {
            System.out.println(0);
            return;
        }
        while (decimal != 0) {
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }
        while (!binaryStack.isEmpty()) {
            System.out.print(binaryStack.peek());
            binaryStack.pop();
        }
    }
}
