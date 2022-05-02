package ExamPrep;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().replaceAll(" ", "").split(",");
        String[][] matrix = new String[size][];
        fillMatrix(matrix, size, scan);
        int playerRow = findPlayerRow(matrix, size);
        int playerCol = findPlayerCol(matrix, size);
        int bombsCount = bombsCount(matrix);
        boolean reachedEndRoute = false;
        boolean allBombsFound = false;
        for (String command : commands) {
            int previousRow = playerRow;
            int previousCol = playerCol;
            switch (command) {
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "up":
                    playerRow--;
                    break;
            }
            if(playerCol >= 0 && playerCol < size && playerRow >= 0 && playerRow < size) {

                if(matrix[playerRow][playerCol].equals("B")) {
                    System.out.println("You found a bomb!");
                    matrix[playerRow][playerCol] = "+";
                    bombsCount--;
                    if(bombsCount == 0) {
                        allBombsFound = true;
                        break;
                    }

                } else if(matrix[playerRow][playerCol].equals("e")) {
                    reachedEndRoute = true;
                    break;
                }
                matrix[playerRow][playerCol] = "s";
                matrix[previousRow][previousCol] = "+";
            } else {
                playerRow = findPlayerRow(matrix, size);
                playerCol = findPlayerCol(matrix, size);
            }
        }
        if(allBombsFound) {
            System.out.println("Congratulations! You found all bombs!");
        } else if(reachedEndRoute) {
            System.out.printf("END! %d bombs left on the field", bombsCount);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, playerRow, playerCol);
        }
    }

    public static int bombsCount (String[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col].equals("B")) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int findPlayerRow (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("s")) {
                    return row;
                }
            }
        }
        return 0;
    }
    public static int findPlayerCol (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("s")) {
                    return col;
                }
            }
        }
        return 0;
    }
    public static void fillMatrix (String[][] matrix, int size, Scanner scan) {
        for (int row = 0; row < size; row++) {
            String[] input = scan.nextLine().replaceAll(" ", "").split("");
            matrix[row] = input;
        }
    }
}
