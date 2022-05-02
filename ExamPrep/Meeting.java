package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] maleInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] femaleInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> males = new ArrayDeque<>();
        for (Integer male : maleInput) {
            males.push(male);
        }
        ArrayDeque<Integer> females = new ArrayDeque<>();
        for (Integer female : femaleInput) {
            females.offer(female);
        }
        int matches = 0;
        while (!females.isEmpty() && !males.isEmpty()) {
            if(males.peek() <= 0) {
                males.pop();
                continue;
            } else if(females.peek() <= 0) {
                females.poll();
                continue;
            }
            if(males.peek() % 25 == 0 || females.peek() % 25 == 0) {
                if (males.peek() % 25 == 0) {
                    males.pop();
                    if (!males.isEmpty()) {
                        males.pop();
                    }

                }
                if (females.peek() % 25 == 0) {
                    females.poll();
                    if (!females.isEmpty()) {
                        females.poll();
                    }

                }
                continue;
            }
            if(males.peek() <= 0) {
                males.pop();
            } else if(females.peek() <= 0) {
                females.poll();
            }

            if(females.isEmpty() || males.isEmpty()) {
                break;
            }

            if (males.peek().equals(females.peek())) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                int male = males.peek();
                males.pop();
                males.push(male - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if(!males.isEmpty()) {
            System.out.print("Males left: ");
            int count = males.size();
            for (Integer male : males) {
                if(count > 1) {
                    System.out.printf("%d, ", male);
                } else {
                    System.out.printf("%d%n", male);
                }
                count--;
            }
        } else {
            System.out.println("Males left: none");
        }
        if(!females.isEmpty()) {
            System.out.print("Females left: ");
            int count = females.size();
            for (Integer female : females) {
                if(count > 1) {
                System.out.printf("%d, ", female);
                } else {
                    System.out.printf("%d", female);
                }
                count--;
            }
        } else {
            System.out.println("Females left: none");
        }
    }
}
