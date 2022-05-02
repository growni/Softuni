package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];
        fillingMatrix(matrix, rows, cols, scan);
        String[] inputCommands = scan.nextLine().split("\\s+");

        while (!inputCommands[0].equals("END")) {

            if(!inputCommands[0].equals("swap") || inputCommands.length != 5) {
                System.out.println("Invalid input!");
            } else {

                int fromRow = Integer.parseInt(inputCommands[1]);
                int fromCol = Integer.parseInt(inputCommands[2]);
                int toRow = Integer.parseInt(inputCommands[3]);
                int toCol = Integer.parseInt(inputCommands[4]);


                if (isInvalid(rows, cols, fromRow, fromCol, toRow, toCol, inputCommands[0])) {
                    System.out.println("Invalid input!");
                } else {
                    String from = matrix[fromRow][fromCol];
                    String to = matrix[toRow][toCol];
                    matrix[fromRow][fromCol] = to;
                    matrix[toRow][toCol] = from;
                    printMatrix(matrix, rows, cols);
                }
            }
            inputCommands = scan.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInvalid(int rows, int cols, int fromRow, int fromCol, int toRow, int toCol, String command) {
        if (!command.equals("swap")) {
            return true;
        }
        if (fromRow > rows || toRow > rows) {
            return true;
        } else return fromCol > cols || toCol > cols;
    }

    public static void fillingMatrix(String[][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            if (cols >= 0) System.arraycopy(inputLine, 0, matrix[row], 0, cols);
        }
    }
}
