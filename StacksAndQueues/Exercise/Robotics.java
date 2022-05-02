package StacksAndQueues.Exercise;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String robotsInput[] = scan.nextLine().split(";");
        Map<String, Integer> mapRobots = new HashMap<>();
        ArrayDeque<String> robotsQueue = new ArrayDeque<>();

        for (int i = 0; i < robotsInput.length; i++) {
            //split the robots info and store robots name and process time in a MAP
            String[] infoRobots = robotsInput[i].split("-");
            String robotName = infoRobots[0];
            int processTime = Integer.parseInt(infoRobots[1]);
            mapRobots.put(robotName, processTime);
            robotsQueue.offer(robotName);
        }
        //assemble the clock
        String[] clockInput = scan.nextLine().split(":");
        int hours = Integer.parseInt(clockInput[0]);
        int minutes = Integer.parseInt(clockInput[1]);
        int seconds = Integer.parseInt(clockInput[2]);

        clock(hours, minutes, seconds);

        String product = scan.nextLine();
        ArrayDeque<String> queueProducts = new ArrayDeque<>();

        while (!product.equals("End")) {

            queueProducts.offer(product);

            product = scan.nextLine();
        }
        List<String> busyRobots = new ArrayList<>();
        while (!queueProducts.isEmpty()) {

            String currentRobot = robotsQueue.poll();
            busyRobots.add(currentRobot);
            System.out.printf("%s - %s [%d:%d:%d]%n", currentRobot, product, hours, minutes, seconds);
        }

    }

    public static void clock (int hours, int minutes, int seconds) {
        seconds++;
        if(seconds == 60) {
            minutes++;
            seconds = 0;
            if(minutes == 60) {
                hours++;
                minutes = 0;
            }
        }
    }
}
