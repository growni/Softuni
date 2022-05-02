package ExamPrep;

import java.util.Scanner;



public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int numberCommands = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][];
        fillMatrix(matrix, size, scan);
        int playerRow = findPlayerRow(matrix, size);
        int playerCol = findPlayerCol(matrix, size);
        boolean isFinished = false;
        for (int i = 0; i < numberCommands; i++) {
            String command = scan.nextLine();
            int previousRow = playerRow;
            int previousCol = playerCol;
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            matrix[previousRow][previousCol] = "-";
            playerRow = coverMovementRow(playerRow, playerCol, size);
            playerCol = coverMovementCol(playerRow, playerCol, size);
            if(matrix[playerRow][playerCol].equals("B")) {
                if(command.equals("left")) {
                    playerCol--;
                } else if(command.equals("right")) {
                    playerCol++;
                } else if(command.equals("down")) {
                    playerRow++;
                } else if(command.equals("up")) {
                    playerRow--;
                }
                matrix[playerRow][playerCol] = "f";
            } else if(matrix[playerRow][playerCol].equals("T")) {
                playerRow = previousRow;
                playerCol = previousCol;
            } else if (matrix[playerRow][playerCol].equals("F")) {
                matrix[playerRow][playerCol] = "f";
                matrix[previousRow][previousCol] = "-";
                isFinished = true;
                break;
            } else if(matrix[playerRow][playerCol].equals("-")) {
                matrix[playerRow][playerCol] = "f";
                matrix[previousRow][previousCol] = "-";
            }

        }
        if(isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix, size);
    }
    public static void printMatrix (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static int coverMovementRow (int playerRow, int playerCol, int size) {
        if(playerRow < 0 || playerRow >= size) {
            if(playerRow < 0) {
                playerRow = size - 1;
            }
            if(playerRow >= size) {
                playerRow = 0;
            }
        }
        if(playerCol < 0 || playerCol >= size) {
            if(playerCol < 0) {
                playerCol = size - 1;
            }
            if(playerCol >= size) {
                playerCol = 0;
            }
        }
        return playerRow;
    }
    public static int coverMovementCol (int playerRow, int playerCol, int size) {
        if(playerRow < 0 || playerRow >= size) {
            if(playerRow < 0) {
                playerRow = size - 1;
            }
            if(playerRow >= size) {
                playerRow = 0;
            }
        }
        if(playerCol < 0 || playerCol >= size) {
            if(playerCol < 0) {
                playerCol = size - 1;
            }
            if(playerCol >= size) {
                playerCol = 0;
            }
        }
        return playerCol;
    }
    public static int findPlayerCol (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("f")) {
                    return col;
                }
            }
        }
        return 0;
    }
    public static int findPlayerRow (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("f")) {
                    return row;
                }
            }
        }
        return 0;
    }
    private static void fillMatrix(String[][] matrix, int size, Scanner scan) {
        for (int row = 0; row < size; row++) {
            matrix[row] = scan.nextLine().split("");
        }
    }
}
