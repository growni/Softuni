package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String filename = scan.nextLine();
        ArrayDeque<String> filesQueue = new ArrayDeque<>();

        while (!filename.equals("print")) {

            if(!filename.equals("cancel")) {
                filesQueue.offer(filename);
            } else {
                if(filesQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledFile = filesQueue.poll();
                    System.out.printf("Canceled %s%n", canceledFile);
                }
            }

            filename = scan.nextLine();
        }
        for (String file : filesQueue) {
            System.out.println(file);
        }
    }
}
