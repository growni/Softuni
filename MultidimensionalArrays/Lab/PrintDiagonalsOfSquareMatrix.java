package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dimensions][dimensions];
        readMatrix(matrix, scan);
        printMatrixDiagonals(matrix);

    }

    public static void printMatrixDiagonals (int[][] matrix) {
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            System.out.print(matrix[row][row] + " ");

        }
        System.out.println();
        int cols = 0;
        for (int row = rows - 1; row >= 0; row--) {
            System.out.print(matrix[row][cols] + " ");
            cols++;
        }
    }

    public static void readMatrix (int[][] matrix, Scanner scan) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        }
    }
}
