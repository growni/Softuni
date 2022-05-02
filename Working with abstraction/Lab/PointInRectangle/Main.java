package abstractions.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        int bottomLeftX = Integer.parseInt(input[0]);
        int bottomLeftY = Integer.parseInt(input[1]);
        int topRightX = Integer.parseInt(input[2]);
        int topRightY = Integer.parseInt(input[3]);
        Point bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        Point topRightPoint = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        for (int i = 0; i < n; i++) {
            int[] pointCoordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x = pointCoordinates[0];
            int y = pointCoordinates[1];
            Point point = new Point(x, y);
            if(point.getX() >= bottomLeftX && point.getX() <= topRightX && point.getY() >= bottomLeftY && point.getY() <= topRightY) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }

        }
    }
}
