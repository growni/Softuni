package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = fillMatrix(rows, cols, scan);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumElementsInMatrix(matrix));
    }

    public static int sumElementsInMatrix (int[][] matrix) {
        //Method for sum the elements in matrix
        int sum = 0;
        for (int[] ints : matrix) {
            for (int element : ints) {
                sum += element;
            }
        }
        return sum;
    }

    public static int[][] fillMatrix (int rows, int cols, Scanner scan) {
        //Method for filling the matrix
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col];
            }
        }
        return matrix;
    }
}
