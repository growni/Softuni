package ExamPrep;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];

        int eatenCheese = 0;
        matrix = fillMatrix(matrix, scan, n);
        int mouseRow = findMouseRow(matrix, n);
        int mouseCol = findMouseCol(matrix, n);
        String commands = scan.nextLine();
        while (!commands.equals("end")) {
            if (!validateMovement(n, n, commands, mouseRow, mouseCol)) {
                matrix[mouseRow][mouseCol] = '-';
                System.out.println("Where is the mouse?");
                break;
            }
            switch (commands) {
                case "up":
                    matrix[mouseRow][mouseCol] = '-';
                    mouseRow--;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                        matrix[mouseRow][mouseCol] = 'M';
                    } while (matrix[mouseRow][mouseCol] == 'B') {
                    matrix[mouseRow][mouseCol] = '-';
                    mouseRow--;
                    if(matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                    }
                }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "down":
                    matrix[mouseRow][mouseCol] = '-';
                    mouseRow++;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                        matrix[mouseRow][mouseCol] = 'M';
                    } while (matrix[mouseRow][mouseCol] == 'B') {
                        matrix[mouseRow][mouseCol] = '-';
                        mouseRow++;
                        if(matrix[mouseRow][mouseCol] == 'c') {
                            eatenCheese++;
                        }
                    }
                        matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "left":
                    matrix[mouseRow][mouseCol] = '-';
                    mouseCol--;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                        matrix[mouseRow][mouseCol] = 'M';
                    } while (matrix[mouseRow][mouseCol] == 'B') {
                    matrix[mouseRow][mouseCol] = '-';
                    mouseCol--;
                    if(matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                    }
                }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "right":
                    matrix[mouseRow][mouseCol] = '-';
                    mouseCol++;
                    if (matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                        matrix[mouseRow][mouseCol] = 'M';
                    } while (matrix[mouseRow][mouseCol] == 'B') {
                    matrix[mouseRow][mouseCol] = '-';
                    mouseCol++;
                    if(matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                    }
                }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
            }


            commands = scan.nextLine();
        }
        if(eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }
        printMatrix(matrix, n);

    }

    public static char[][] fillMatrix(char[][] matrix, Scanner scan, int rows) {
        for (int row = 0; row < rows; row++) {
            char[] line = scan.nextLine().toCharArray();
            matrix[row] = line;
        }
        return matrix;
    }
    public static int findMouseRow (char[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if(currentSymbol == 77) {
                    return row;
                }
            }
        }
        return 0;
    }
    public static int findMouseCol (char[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if(currentSymbol == 77) {
                    return col;
                }
            }
        }
        return 0;
    }

    public static boolean validateMovement(int rows, int cols, String command, int mouseRow, int mouseCol) {
        if (command.equals("up")) {
            return mouseRow - 1 >= 0;
        } else if (command.equals("down")) {
            return mouseRow + 1 < rows;
        } else if (command.equals("left")) {
            return mouseCol - 1 >= 0;
        } else if (command.equals("right")) {
            return mouseCol + 1 < cols;
        }
        return true;
    }

    public static void printMatrix (char[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            System.out.println(matrix[row]);
        }
    }
}
