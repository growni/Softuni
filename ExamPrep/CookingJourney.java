package ExamPrep;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, size, scan);
        int row = findPlayerRow(matrix, size);
        int col = findPlayerCol(matrix, size);
        int rent = 0;
        boolean isOut = false;
        while (rent < 50) {
            String command = scan.nextLine();
            int previousRow = row;
            int previousCol = col;
            if(command.equals("up")) {
                row--;
            } else if(command.equals("down")) {
                row++;
            } else if(command.equals("left")) {
                col--;
            } else if(command.equals("right")) {
                col++;
            }
            if(col < 0 || col >= size || row < 0 || row >= size) {
                matrix[previousRow][previousCol] = "-";
                isOut = true;
                break;
            } else if(matrix[row][col].equals("P")) {
                matrix[row][col] = "-";
                matrix[previousRow][previousCol] = "-";
                findPillar(matrix, size);
                row = findPlayerRow(matrix, size);
                col = findPlayerCol(matrix, size);
            } else if(matrix[row][col].equals("-")) {
                matrix[row][col] = "S";
                matrix[previousRow][previousCol] = "-";
            } else {
                rent += Integer.parseInt(matrix[row][col]);
                matrix[row][col] = "S";
                matrix[previousRow][previousCol] = "-";
            }
        }
        if(isOut) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        if(rent >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", rent);
        printMatrix(matrix, size);
    }
    private static void printMatrix (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void findPillar(String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("P")) {
                    matrix[row][col] = "S";
                }
            }
        }
    }
    public static void fillMatrix (String[][] matrix, int size, Scanner scan) {
        for (int row = 0; row < size; row++) {
            String[] input = scan.nextLine().split("");
            matrix[row] = input;
        }
    }
    public static int findPlayerRow (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("S")) {
                    return row;
                }
            }
        }
        return 0;
    }
    public static int findPlayerCol (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("S")) {
                    return col;
                }
            }
        }
        return 0;
    }
}
