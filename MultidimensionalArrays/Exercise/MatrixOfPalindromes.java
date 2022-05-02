package MultidimensionalArrays.Exercise;

import java.util.*;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] matrix = new String[r][c];

        char colChar = 97;
        char rowChar = 97;
        char prevColChar = 97;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                StringBuilder sb = new StringBuilder().append(rowChar).append(colChar).append(rowChar);
                String fullItem = sb.toString();
                matrix[row][col] = fullItem;
                colChar++;
            }
            prevColChar++;
            colChar = prevColChar;
            rowChar++;
        }
        printMatrix(matrix);
    }

    public static void printMatrix (String[][] matrix) {
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

