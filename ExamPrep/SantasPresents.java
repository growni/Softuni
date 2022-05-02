package ExamPrep;

import java.util.*;

public class SantasPresents {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] materialsInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] magicInput = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stackMaterials = new ArrayDeque<>();
        for (int material : materialsInput) {
            stackMaterials.push(material);
        }
        ArrayDeque<Integer> queueMagic = new ArrayDeque<>();
        for (int value : magicInput) {
            queueMagic.offer(value);
        }

        Map<String, Integer> presentsMap = new TreeMap<>();
        int dollCount = 0;
        int trainCount = 0;
        int teddyCount = 0;
        int bicycleCount = 0;
        while (!stackMaterials.isEmpty() && !queueMagic.isEmpty()) {
            int resultValue = 0;
            resultValue = stackMaterials.peek() * queueMagic.peek();
            if (stackMaterials.peek() == 0 || queueMagic.peek() == 0) {
                if (stackMaterials.peek() == 0) {
                    stackMaterials.pop();
                }
                if (queueMagic.peek() == 0) {
                    queueMagic.poll();
                }
                continue;
            }
            if (resultValue == 150) {
                dollCount++;
                presentsMap.put("Doll", dollCount);
                queueMagic.poll();
                stackMaterials.pop();
            } else if (resultValue == 250) {
                trainCount++;
                queueMagic.poll();
                stackMaterials.pop();
                presentsMap.put("Wooden train", trainCount);
            } else if (resultValue == 300) {
                teddyCount++;
                presentsMap.put("Teddy bear", teddyCount);
                queueMagic.poll();
                stackMaterials.pop();
            } else if (resultValue == 400) {
                bicycleCount++;
                presentsMap.put("Bicycle", bicycleCount);
                queueMagic.poll();
                stackMaterials.pop();
            } else if (resultValue < 0) {
                resultValue = queueMagic.poll() + stackMaterials.pop();
                stackMaterials.push(resultValue);
            } else {
                queueMagic.poll();
                int stackValue = stackMaterials.pop();
                stackMaterials.push(stackValue + 15);
            }
        }
        printCases(presentsMap);
        if (!stackMaterials.isEmpty()) {
            String output = String.join(", ", stackMaterials.toString().replaceAll("[\\[\\]]", ""));
            System.out.println("Materials left: " + output);
        }
        if (!queueMagic.isEmpty()) {
            String output = String.join(", ", queueMagic.toString().replaceAll("[\\[\\]]", ""));
            System.out.println("Magic left: " + output);
        }
        printPresents(presentsMap);
    }

    public static void printPresents(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
            }
        }
    }

    public static void printCases(Map<String, Integer> map) {
        boolean isChristmas = false;
        if(map.containsKey("Doll") && map.containsKey("Wooden train")) {
            isChristmas = true;
        } else if(map.containsKey("Teddy bear") && map.containsKey("Bicycle")) {
            isChristmas = true;
        }
        if (isChristmas) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
    }
}
