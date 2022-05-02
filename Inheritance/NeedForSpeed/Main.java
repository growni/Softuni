package NeedForSpeed;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Car car = new Car(100, 75);
        car.drive(90);
    }
}
