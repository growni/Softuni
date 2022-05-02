package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> backUrls = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("Home")) {

            switch(input) {
                case "back":
                    if(urls.isEmpty()) {
                        System.out.println("no previous URLs");
                    } else {
                        backUrls.push(urls.pop());
                        System.out.println(urls.peek());
                    }
                    break;
                case "forward":
                    if(backUrls.isEmpty()) {
                        System.out.println("No next URLs");
                    } else {
                        System.out.println(backUrls.pop());
                    }
                    break;
                default:
                    urls.push(input);
                    break;
            }
            input= scan.nextLine();
        }
    }
}
