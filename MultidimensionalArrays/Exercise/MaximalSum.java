package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        matrix = fillMatrix(matrix, scan, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if(sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix, startRow, startCol);

    }


    public static void printMatrix (int matrix[][], int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillMatrix(int[][] matrix, Scanner scan, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] inputLine = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                int item = Integer.parseInt(inputLine[col]);
                matrix[row][col] = item;
            }
        }
        return matrix;
    }
}
