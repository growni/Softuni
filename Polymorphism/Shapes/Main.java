package Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Rectangle rectangle = new Rectangle(2D, 3D);
        System.out.println(rectangle.getArea());

    }
}
