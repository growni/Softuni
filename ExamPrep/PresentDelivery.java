package ExamPrep;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][];
        fillMatrix(matrix, size, scan);
        int row = findPlayerRow(matrix, size);
        int col = findPlayerCol(matrix, size);
        int niceKids = findNiceKids(matrix, size);
        int initialNiceKids = niceKids;
        String commands = scan.nextLine();

        while (!commands.equals("Christmas morning") && presentsCount > 0) {
            int previousRow = row;
            int previousCol = col;

            switch (commands) {
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
            if(row < 0 || row >= size || col < 0 || col >= size) {
                System.out.println("Santa ran out of presents.");
                break;
            } else {
                if(matrix[row][col].equals("V")) {
                    matrix[previousRow][previousCol] = "-";
                    matrix[row][col] = "S";
                    niceKids--;
                    presentsCount--;
                } else if(matrix[row][col].equals("X")) {
                    matrix[previousRow][previousCol] = "-";
                    matrix[row][col] = "S";
                    presentsCount--;
                } else if(matrix[row][col].equals("C")) {
                    checkVicinity(matrix, size, row, col, niceKids, presentsCount);
                } else {
                    matrix[previousRow][previousCol] = "-";
                    matrix[row][col] = "S";
                }
            }
            if(presentsCount == 0) {
                break;
            }

            commands = scan.nextLine();
        }
        printMatrix(matrix, size);
        if(niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", initialNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKids);
        }
    }
    private static void printMatrix (String[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static void checkVicinity (String[][] matrix, int size, int row, int col, int niceKids, int presents) {
        if (matrix[row - 1][col].equals("V")) {
            niceKids--;
            presents--;
        } else if(matrix[row - 1][col].equals("X")) {
            presents--;
        } else if(matrix[row + 1][col].equals("V")) {
            presents--;
            niceKids--;
        } else if(matrix[row + 1][col].equals("X")) {
            presents--;
        } else if(matrix[row][col - 1].equals("X")) {
            presents--;
        } else if(matrix[row][col - 1].equals("V")) {
            presents--;
            niceKids--;
        } else if(matrix[row][col + 1].equals("X")) {
            presents--;
        } else if(matrix[row][col + 1].equals("V")) {
            presents--;
            niceKids--;
        }
    }
    private static int findNiceKids(String[][] matrix, int size) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col].equals("V")) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void fillMatrix (String[][] matrix, int size, Scanner scan) {
        for (int row = 0; row < size; row++) {
            String[] input = scan.nextLine().replaceAll(" ", "").split("");
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
