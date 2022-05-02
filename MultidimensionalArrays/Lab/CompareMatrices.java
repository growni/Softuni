package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int rowsFirst = Integer.parseInt(input[0]);
        int colsFirst = Integer.parseInt(input[1]);

        int[][] firstMatrix = new int[rowsFirst][colsFirst];
// reading first matrix
        for (int row = 0; row < rowsFirst; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            firstMatrix[row] = arr;
        }
// reading second matrix
        String[] inputSecond = scan.nextLine().split("\\s+");
        int rowsSecond = Integer.parseInt(inputSecond[0]);
        int colsSecond = Integer.parseInt(inputSecond[1]);

        int[][] secondMatrix = readMatrix(rowsSecond, colsSecond, scan);

// comparing both matrices
        if(!areEqual(firstMatrix, secondMatrix)) {
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }
    }


    public static boolean areEqual (int[][] firstMatrix, int[][] secondMatrix) {
        //Comparing both matrices
        if(firstMatrix.length != secondMatrix.length) {
            return false;
        }
        int rows = firstMatrix.length;

        for (int row = 0; row < rows; row++) {
            if(firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            } else {
                int cols = firstMatrix[row].length;
                for (int col = 0; col < cols; col++) {
                    if(firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(int rowsSecond, int colsSecond, Scanner scan) {
        //Reading matrix
        int[][] matrix = new int[rowsSecond][colsSecond];
        for (int row = 0; row < rowsSecond; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            matrix[row] = arr;
        }
        return matrix;
    }

}
