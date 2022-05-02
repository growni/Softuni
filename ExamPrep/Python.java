package ExamPrep;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",\\s+");
        char[][] matrix = new char[size][size];
        fillMatrix(matrix, size, scan);
        int row = findSnakeRow(matrix, size);
        int col = findSnakeCol(matrix, size);
        boolean isKilled = false;
        int length = 1;
        int foodCount = foodCount(matrix, size);

        for (String command : commands) {
            switch (command) {
                case "up":
                  row--;
                  break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if(row < 0 || row >= size) {
                if(row < 0) {
                    row = size - 1;
                }
                if(row >= size) {
                    row = 0;
                }
            }
            if(col < 0 || col >= size) {
                if(col < 0) {
                    col = size - 1;
                }
                if(col >= size) {
                    col = 0;
                }
            }
            if(matrix[row][col] == 'e') {
                System.out.printf("You lose! Killed by an enemy!");
                return;
            } else if(matrix[row][col] == 'f') {
                matrix[row][col] = 's';
                length++;
                foodCount--;
            }
            if(foodCount == 0) {
                break;
            }
        }
        if(foodCount == 0) {
            System.out.printf("You win! Final python length is %d", length);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        }
    }

    public static int foodCount (char[][] matrix, int size) {
        int foodCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 'f') {
                    foodCount++;
                }
            }
        }
        return foodCount;
    }
    public static int findSnakeCol (char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 's') {
                    return col;
                }
            }
        }
        return 0;
    }
    public static int findSnakeRow (char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 's') {
                    return row;
                }
            }
        }
        return 0;
    }
    public static void fillMatrix(char[][] matrix, int size, Scanner scan) {
        for (int row = 0; row < size; row++) {
            matrix[row] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
    }
}
