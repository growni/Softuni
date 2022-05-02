import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        printTopHalf(size);
        printBottomHalf(size);
    }

    private static void printBottomHalf(int size) {
        for (int stars = size - 1; stars > 0; stars--) {
            printTriangleOfStars(size, stars);
        }
    }

    private static void printTopHalf(int size) {
        for (int stars = 1; stars <= size; stars++) {
            printTriangleOfStars(size, stars);
        }
    }

    private static void printTriangleOfStars(int size, int stars) {
        for (int i = 0; i < size - stars; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars - 1; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }

}