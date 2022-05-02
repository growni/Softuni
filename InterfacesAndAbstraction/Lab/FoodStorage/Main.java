package FoodStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scan.nextLine());
        int food = 0;
        List<Object> buyers = new ArrayList<>();

        for (int person = 0; person < peopleCount; person++) {

            String[] input = scan.nextLine().split("\\s+");
            if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                buyers.add(citizen);
            } else if (input.length == 3) {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                buyers.add(rebel);
            }
        }
            String input = scan.nextLine();
        while (!input.equals("End")) {


            input = scan.nextLine();
        }
    }
}
