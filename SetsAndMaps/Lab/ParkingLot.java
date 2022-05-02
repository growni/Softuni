package SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")) {

            String action = input.split(", ")[0];
            String plate = input.split(", ")[1];

            if(action.equals("IN")) {
                parking.add(plate);
            } else {
                parking.remove(plate);
            }

            input = scan.nextLine();
        }
        if(parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parking));
        }
    }
}
