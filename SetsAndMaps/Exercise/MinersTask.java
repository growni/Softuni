package SetsAndMaps.Exercise;

import java.util.*;

public class MinersTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        HashMap<String, Integer> resources = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("stop")) {
            queue.offer(input);
            input = scan.nextLine();
        }
        while (!queue.isEmpty()){
            String type = queue.peek();
            if(!resources.containsKey(type)) {
                resources.put(queue.poll(), Integer.parseInt(queue.poll()));
            } else {
                queue.poll();
                resources.put(type, resources.get(type) + Integer.parseInt(queue.poll()));
            }
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
