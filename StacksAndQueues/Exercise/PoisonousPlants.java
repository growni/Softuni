package StacksAndQueues.Exercise;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int plantsNum = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> queuePlants = new ArrayDeque<>();
        ArrayList<Integer> listPlants = new ArrayList<>();
        ArrayDeque<Integer> shiftedQueue = new ArrayDeque<>();
        ArrayDeque<Integer> leftovers = new ArrayDeque<>();

        for (int i = 0; i < plantsNum; i++) {
            listPlants.add(scan.nextInt());
        }
        leftovers.offer(listPlants.get(0));
        for (int i = 0; i < listPlants.size(); i++) {
            queuePlants.offer(listPlants.get(i));
            shiftedQueue.offer(listPlants.get(i));
        }
        for (int i = 0; i < shiftedQueue.size() + 1; i++) {
            shiftedQueue.offer(shiftedQueue.pop());
        }
        for (int i = 0; i < queuePlants.size(); i++) {
            int shiftedPlant = shiftedQueue.peek();
            int leftPlant = queuePlants.peek();
            if(shiftedPlant > leftPlant) {
                shiftedQueue.pop();
            }
            leftovers.offer(shiftedQueue.pop());
            shiftedQueue.pop();

        }

        System.out.println();

    }
}
