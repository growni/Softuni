package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] size = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, rows, cols);

        String[] commands = scan.nextLine().split("\\s+");
        while (!commands[0].equals("Nuke")) {
            int row = Integer.parseInt(commands[0]);
            int col = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);
            boolean centerIsOut = false;
            int countEmpty = 0;
            int emptyRows = 0;
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                centerIsOut = true;
            }
            if (centerIsOut) {
                int threshold = row + radius;
                if (row < 0 && row + radius >= 0) { // when the center is outside Above
                    while (threshold > 0 && col >= 0 && col < cols) {
                        matrix[threshold][col] = 0;
                        threshold--;
                    }
                } else if (row >= rows && row - radius < rows) { // when the center is outside Under
                    threshold = row - radius;
                    while (threshold < rows && col >= 0 && col < cols) {
                        matrix[threshold][col] = 0;
                        threshold++;
                    }
                } else if (col < 0 && col + radius >= 0 && row >= 0 && row < rows) { // when the center is outside Left
                    threshold = col + radius;
                    while (threshold >= 0) {
                        matrix[row][threshold] = 0;
                        threshold--;
                    }
                } else if (col >= cols && col - radius < cols  && row >= 0 && row < rows) { // when the center is outside Right
                    threshold = col - radius;
                    while (threshold < cols) {
                        matrix[row][threshold] = 0;
                        threshold++;
                    }
                }
                pushZeros(matrix); //push zeros to the left
                countEmpty = 0;
                emptyRows = 0;
                validateEmptyRow(matrix, countEmpty, emptyRows); // push empty rows to the bottom
            } else {
                matrix[row][col] = 0;
                int rad = 1;
                //blow above center
                while (row + rad < rows && rad <= radius) {
                    matrix[row + rad][col] = 0;
                    rad++;
                }
                rad = 1;
                //blow below center
                while (row - rad >= 0 && rad <= radius) {
                    matrix[row - rad][col] = 0;
                    rad++;
                }
                rad = 1;
                //blow right
                while (col + rad < cols && rad <= radius) {
                    matrix[row][col + rad] = 0;
                    rad++;
                }
                rad = 1;
                //blow left
                while (col - rad >= 0 && rad <= radius) {
                    matrix[row][col - rad] = 0;
                    rad++;
                }
                pushZeros(matrix); //push zeros to the left
                countEmpty = 0;
                emptyRows = 0;
                validateEmptyRow(matrix, countEmpty, emptyRows); // push empty rows to the bottom

            }
            commands = scan.nextLine().split("\\s+");
        }
        printMatrix(matrix, rows, cols);

    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != 0) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void validateEmptyRow(int[][] matrix, int count, int emptyRows) {
        for (int j = 0; j < matrix.length; j++) {


            for (int row = 0; row < matrix.length; row++) {
                emptyRows = 0;
                count = 0;
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 0) {
                        count++;
                        if (count == matrix[row].length) {
                            emptyRows++;
                            count = 0;
                        }
                        if (emptyRows == 1) {
                            int[] emptyRow = matrix[row];
                            for (int i = row; i < matrix.length; i++) {
                                if (i == matrix.length - 1) {
                                    matrix[matrix.length - 1] = emptyRow;
                                    break;
                                }
                                matrix[row] = matrix[i + 1];
                                row++;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void pushZeros(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] matrixRow = matrix[row];
            List<Integer> aboveZeroNums = new ArrayList<>();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrixRow[col] != 0) {
                    aboveZeroNums.add(matrixRow[col]);
                }
                matrix[row][col] = 0;
            }
            for (int col = 0; col < aboveZeroNums.size(); col++) {
                matrix[row][col] = aboveZeroNums.get(col);
            }
            aboveZeroNums.clear();
        }
    }

    public static void fillMatrix(int[][] matrix, int rows, int cols) {
        int filler = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ++filler;
            }
        }
    }
}