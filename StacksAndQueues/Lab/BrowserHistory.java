package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("Home")) {

            String currentUrl;
            if (!input.equals("back")) {
                urls.push(input);
                currentUrl = urls.peek();
                System.out.println(currentUrl);
            } else {
                if(urls.isEmpty() || urls.size() == 1) {
                    System.out.println("no previous URLs");

                } else {
                    urls.pop();
                    String previousUrl = urls.peek();
                    System.out.println(previousUrl);

                }
            }
            input = scan.nextLine();
        }
    }
}
