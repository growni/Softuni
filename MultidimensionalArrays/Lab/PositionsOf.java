package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = readMatrix(rows, cols, scan);
        int numberToFind = Integer.parseInt(scan.nextLine());

        numberIsFound(matrix, numberToFind);

    }

    private static void numberIsFound(int[][] matrix, int numberToFind) {
        boolean flag = false;
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            int cols = matrix[row].length;
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    flag = true;
                }
            }
        }
        if(!flag) {
            System.out.println("not found");
        }
    }

    public static int[][] readMatrix (int rows, int cols, Scanner scanner) {
        // Method for reading a matrix from the console with given rows and columns.
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
