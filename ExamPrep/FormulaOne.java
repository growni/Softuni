package ExamPrep;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][];
        int countCommands = Integer.parseInt(scan.nextLine());
        matrix = fillMatrix(matrix, scan, n);
        System.out.println();
        int carRow = findCarRow(matrix, n);
        int carCol = findCarCol(matrix, n);
        boolean isFinished = false;
        for (int i = 0; i < countCommands; i++) {
            String command = scan.nextLine();
            if (isFinished) {
                break;
            }
            switch (command) {
                case "down":

                    if (validateMovement(n, n, command, carRow, carCol)) {
                        if (matrix[carRow + 1][carCol] == '.') {
                            matrix[carRow][carCol] = '.';
                            carRow++;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow + 1][carCol] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carRow += 2;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow + 1][carCol] == 'F') {
                            matrix[carRow][carCol] = '.';
                            carRow++;
                            matrix[carRow][carCol] = 'P';
                            isFinished = true;

                        }
                    } else {
                        if (matrix[0][carCol] == '.') {
                            matrix[carRow][carCol] = '.';
                            carRow = 0;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[0][carCol] == 'B') {
                            carRow = 1;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[0][carCol] == 'F') {
                            matrix[carRow][carCol] = '.';
                            carRow = 0;
                            matrix[carRow][carCol] = 'P';
                            isFinished = true;
                        }
                    }
                    break;
                case "up":
                    if (validateMovement(n, n, command, carRow, carCol)) {
                        if (matrix[carRow - 1][carCol] == '.') {
                            matrix[carRow][carCol] = '.';
                            carRow--;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow - 1][carCol] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carRow--;
                            carRow--;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow - 1][carCol] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[carRow - 1][carCol] = 'P';
                            isFinished = true;
                        }
                    } else {
                        if (matrix[n - 1][carCol] == '.') {
                            matrix[carRow][carCol] = '.';
                            carRow = n - 1;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[n - 1][carCol] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carRow = n - 2;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[n - 1][carCol] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[n - 1][carCol] = 'P';
                            isFinished = true;
                        }
                    }
                    break;
                case "left":
                    if (validateMovement(n, n, command, carRow, carCol)) {
                        if (matrix[carRow][carCol - 1] == '.') {
                            matrix[carRow][carCol] = '.';
                            carCol--;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][carCol - 1] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carCol--;
                            carCol--;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][carCol - 1] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[carRow][carCol - 1] = 'P';
                            isFinished = true;
                        }
                    } else {
                        if (matrix[carRow][n - 1] == '.') {
                            matrix[carRow][carCol] = '.';
                            carCol = n - 1;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][carCol - 1] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carCol = n - 2;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][n - 1] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[carRow][n - 1] = 'P';
                            isFinished = true;
                        }
                    }
                    break;
                case "right":
                    if (validateMovement(n, n, command, carRow, carCol)) {
                        if (matrix[carRow][carCol + 1] == '.') {
                            matrix[carRow][carCol] = '.';
                            carCol++;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][carCol + 1] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carCol++;
                            carCol++;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][carCol + 1] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[carRow][carCol + 1] = 'P';
                            isFinished = true;
                        }
                    } else {
                        if (matrix[carRow][0] == '.') {
                            matrix[carRow][carCol] = '.';
                            carCol = 0;
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][0] == 'B') {
                            matrix[carRow][carCol] = '.';
                            carCol = 1;
                            if (matrix[carRow][carCol] == 'F') {
                                isFinished = true;
                            }
                            matrix[carRow][carCol] = 'P';
                        } else if (matrix[carRow][0] == 'F') {
                            matrix[carRow][carCol] = '.';
                            matrix[carRow][0] = 'P';
                            isFinished = true;
                        }
                    }
                    break;
            }
        }
        if(isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }
    public static void printMatrix (char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static int findCarRow(char[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 80) {
                    return row;
                }
            }
        }
        return 0;
    }

    public static int findCarCol(char[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 80) {
                    return row;
                }
            }
        }
        return 0;
    }

    public static char[][] fillMatrix(char[][] matrix, Scanner scan, int rows) {
        for (int row = 0; row < rows; row++) {
            char[] line = scan.nextLine().toCharArray();
            matrix[row] = line;
        }
        return matrix;
    }

    public static boolean validateMovement(int rows, int cols, String command, int carRow, int carCol) {
        if (command.equals("up")) {
            return carRow - 1 >= 0;
        } else if (command.equals("down")) {
            return carRow + 1 < rows;
        } else if (command.equals("left")) {
            return carCol - 1 >= 0;
        } else if (command.equals("right")) {
            return carCol + 1 < cols;
        }
        return true;
    }
}
