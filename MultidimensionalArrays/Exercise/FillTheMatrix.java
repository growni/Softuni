package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int matrixDimensions = Integer.parseInt(input[0]);
        String fillingPattern = input[1];
        int[][] matrix = new int[matrixDimensions][matrixDimensions];

        if(fillingPattern.equals("A")) {
            fillingPatternA(matrix);
        } else {
            fillingPatternB(matrix);
        }
        printSquareMatrix(matrix);
    }

    public static void fillingPatternA (int[][] matrix) {
        int rows = matrix.length;
        int items = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                matrix[col][row] = items++;
            }
        }
    }

    public static void fillingPatternB (int[][] matrix) {
        int rows = matrix.length;
        int items = 1;
        for (int row = 0; row < rows; row++) {
            if(row % 2 == 0) {
                for (int col = 0; col < rows; col++) {
                    matrix[col][row] = items++;
                }
            } else {
                for (int col = rows; col > 0; col--) {
                    matrix[col - 1][row] = items++;
                }
            }
        }
    }

    public static void printSquareMatrix (int[][] matrix) {
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
