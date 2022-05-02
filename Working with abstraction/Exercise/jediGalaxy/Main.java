package abstractions.Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        fillMatrix(row, col, matrix);


        long sum = 0;
        sum = executeBody(scanner, matrix, sum);

        System.out.println(sum);


    }

    private static long executeBody(Scanner scanner, int[][] matrix, long sum) {
            String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] peterPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            movePeter(matrix, evilRow, evilCol);

            int peterRow = peterPosition[0];
            int peterCol = peterPosition[1];

            sum = moveEvil(matrix, sum, peterRow, peterCol);

            command = scanner.nextLine();
        }
        return sum;
    }

    private static void movePeter(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long moveEvil(int[][] matrix, long sum, int peterRow, int peterCol) {
        while (peterRow >= 0 && peterCol < matrix[1].length) {
            if (peterRow < matrix.length && peterCol >= 0 && peterCol < matrix[0].length) {
                sum += matrix[peterRow][peterCol];
            }

            peterCol++;
            peterRow--;
        }
        return sum;
    }

    private static void fillMatrix(int row, int col, int[][] matrix) {
        int matrixFiller = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = matrixFiller++;
            }
        }
    }
}
