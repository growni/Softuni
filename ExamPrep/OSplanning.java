package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSplanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tasksInput = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        for (int task : tasksInput) {
            stackTasks.push(task);
        }
        int[] threadsInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queueThreads = new ArrayDeque<>();
        for (int thread : threadsInput) {
            queueThreads.offer(thread);
        }
        int taskValue = Integer.parseInt(scan.nextLine());

        while (!queueThreads.isEmpty()) {
            if(stackTasks.peek() == taskValue) {
                System.out.printf("Thread with value %d killed task %d%n", queueThreads.peek(), taskValue);
                break;
            }
            if(queueThreads.peek() >= stackTasks.peek()) {
                queueThreads.poll();
                stackTasks.pop();
            } else {
                queueThreads.poll();
            }
        }
        for (Integer queueThread : queueThreads) {
            System.out.print(queueThread + " ");
        }
    }
}
