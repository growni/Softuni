package MultidimensionalArrays.Exercise;

import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int squareMatrixDimensions = Integer.parseInt(scan.nextLine());
        int[][] squareMatrix = new int[squareMatrixDimensions][squareMatrixDimensions];

        for (int row = 0; row < squareMatrixDimensions; row++) {
            String[] rowItemsInput = scan.nextLine().split("\\s+");
            for (int col = 0; col < rowItemsInput.length; col++) {
                squareMatrix[row][col] = Integer.parseInt(rowItemsInput[col]);
            }
        }
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int row = 0; row < squareMatrixDimensions; row++) {
            //diagonal starting topLeft -> bottomRight sum
            firstDiagonalSum += squareMatrix[row][row];
        }
        int col = 0;
        for (int row = squareMatrixDimensions; row > 0; row--) {
            //diagonal starting from bottomLeft -> topRight sum
            secondDiagonalSum += squareMatrix[row - 1][col];
            col++;

        }
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
