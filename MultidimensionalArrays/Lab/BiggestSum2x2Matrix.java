package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestSum2x2Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = readMatrix(rows, scan);
        System.out.println(findBiggestSumIn2x2(matrix));

    }

    public static int findBiggestSumIn2x2 (int[][] matrix) {
        int sum = 0;
        int biggestSum = 0;
        String biggestRow = "";
        String biggestCol = "";
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(sum > biggestSum) {
                    biggestRow = matrix[row][col] + " " + matrix[row][col + 1];
                    biggestCol = matrix[row + 1][col] + " " + matrix[row + 1][col + 1];
                    biggestSum = sum;
                }
            }
        }
        System.out.println(biggestRow);
        System.out.println(biggestCol);
        return biggestSum;
    }

    public static int[][] readMatrix (int rows, Scanner scan) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
        return matrix;
    }
}
