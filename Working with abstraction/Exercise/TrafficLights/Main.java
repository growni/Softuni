package abstractions.Exercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // light change as:
        // red -> green -> yellow -> red
        Scanner scan = new Scanner(System.in);

        String[] colors = scan.nextLine().split("\\s+");    //цветове на крушките
        int n = Integer.parseInt(scan.nextLine());  //брой на смените
        List<Light> trafficLight = new ArrayList<>();   //списък с всички крушки
        for (String color: colors) {
            Light light = new Light(Colors.valueOf(color));
            trafficLight.add(light);
        }
        for (int changes = 0; changes < n; changes++) {
            trafficLight.forEach(light -> {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }
    }
}
