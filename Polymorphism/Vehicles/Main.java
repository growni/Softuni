package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carTokens = scan.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));

        String[] truckTokens = scan.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));

        String[] busTokens = scan.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        int n = Integer.parseInt(scan.nextLine());

        for (int numberCommands = 0; numberCommands < n; numberCommands++) {
            String[] commandTokens = scan.nextLine().split("\\s+");

            switch (commandTokens[1]) {
                case "Car":
                    if(commandTokens[0].equals("Drive")) {
                        System.out.println(car.drive(Double.parseDouble(commandTokens[2])));
                    } else if(commandTokens[0].equals("Refuel")) {
                        car.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "Truck":
                    if(commandTokens[0].equals("Drive")) {
                        System.out.println(truck.drive(Double.parseDouble(commandTokens[2])));
                    } else if(commandTokens[0].equals("Refuel")) {
                        truck.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "Bus":
                    if(commandTokens[0].equals("Drive")) {
                        System.out.println(bus.drive(Double.parseDouble(commandTokens[2])));
                    } else if(commandTokens[0].equals("Refuel")) {
                        bus.refuel(Double.parseDouble(commandTokens[2]));
                    } else if(commandTokens[0].equals("DriveEmpty")) {
                        System.out.println(bus.driveEmpty(Double.parseDouble(commandTokens[2])));
                    }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
