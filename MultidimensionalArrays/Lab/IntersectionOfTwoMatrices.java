package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        firstMatrix = readMatrix(rows, cols, scan);
        secondMatrix = readMatrix(rows, cols, scan);

        char[][] intersectedMatrix = new char[rows][cols];
        intersectedMatrix = comparingMatrices(firstMatrix, secondMatrix, intersectedMatrix);

        printMatrix(intersectedMatrix);

    }


    public static void printMatrix(char[][] intersectedMatrix) {
        int rows = intersectedMatrix.length;
        for (int row = 0; row < rows; row++) {
            int cols = intersectedMatrix[row].length;
            for (int col = 0; col < cols; col++) {
                System.out.print(intersectedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] comparingMatrices (char[][] firstMatrix, char[][] secondMatrix, char[][] finalMatrix) {
        // Method for comparing the elements in 2 matrices
        int rows = firstMatrix.length;

        for (int row = 0; row < rows; row++) {
            int cols = firstMatrix[row].length;
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col] == secondMatrix[row][col]) {
                    finalMatrix[row][col] = firstMatrix[row][col];
                } else {
                    finalMatrix[row][col] = '*';
                }
            }
        }
        return finalMatrix;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        //Method for reading matrix from the console with given rows and columns
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                char currentSymbol = arr[col].charAt(0);
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }
}
