package ExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int energy = Integer.parseInt(scan.nextLine());
        int rows = Integer.parseInt(scan.nextLine());
        char[][] field = new char[rows][rows];
        int parisRow = 0;
        int parisCol = 0;
        for (int row = 0; row < rows; row++) {
            char[] line = scan.nextLine().toCharArray();
            for (int col = 0; col < line.length; col++) {
                field[row][col] = line[col];
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        boolean isFound = false;
        boolean isDead = false;
        while (energy > 0) {
            if(isDead || isFound) {
                break;
            }
            String[] tokens = scan.nextLine().split("\\s+");
            String movement = tokens[0];
            int enemyRow = Integer.parseInt(tokens[1]);
            int enemyCol = Integer.parseInt(tokens[2]);

            field[enemyRow][enemyCol] = 'S';
            switch (movement) {
                case "up":
                    energy--;
                    if (validateUp(parisRow)) {
                        field[parisRow][parisCol] = '-';
                        parisRow--;
                        if (field[parisRow][parisCol] == 'S') {
                            // if paris encounters enemy
                            energy -= 2;
                            if (energy <= 0) {
                                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                                field[parisRow][parisCol] = 'X';
                                isDead = true;
                                break;
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') {
                            //if paris reaches Helen
                            field[parisRow][parisCol] = '-';
                            System.out.print("Paris has successfully abducted Helen! ");
                            System.out.printf("Energy left: %d%n", energy);
                            isFound = true;
                            break;
                        } else {
                            //if paris moves to an empty index
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "down":
                    energy--;
                    if (validateDown(parisRow, rows)) {
                        field[parisRow][parisCol] = '-';
                        parisRow++;
                        if (field[parisRow][parisCol] == 'S') {
                            // if paris encounters enemy
                            energy -= 2;
                            if (energy <= 0) {
                                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                                field[parisRow][parisCol] = 'X';
                                isDead = true;
                                break;
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') {
                            //if paris reaches Helen
                            field[parisRow][parisCol] = '-';
                            System.out.print("Paris has successfully abducted Helen! ");
                            System.out.printf("Energy left: %d%n", energy);
                            isFound = true;
                            break;
                        } else {
                            //if paris moves to an empty index
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "left":
                    energy--;
                    if (validateLeft(parisCol)) {
                        field[parisRow][parisCol] = '-';
                        parisCol--;
                        if (field[parisRow][parisCol] == 'S') {
                            // if paris encounters enemy
                            energy -= 2;
                            if (energy <= 0) {
                                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                                field[parisRow][parisCol] = 'X';
                                isDead = true;
                                break;
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') {
                            //if paris reaches Helen
                            field[parisRow][parisCol] = '-';
                            System.out.print("Paris has successfully abducted Helen! ");
                            System.out.printf("Energy left: %d%n", energy);
                            isFound = true;
                            break;
                        } else {
                            //if paris moves to an empty index
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;
                case "right":
                    energy--;
                    if (validateRight(parisCol, rows)) {
                        field[parisRow][parisCol] = '-';
                        parisCol++;
                        if (field[parisRow][parisCol] == 'S') {
                            // if paris encounters enemy
                            energy -= 2;
                            if (energy <= 0) {
                                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                                field[parisRow][parisCol] = 'X';
                                isDead = true;
                                break;
                            } else {
                                field[parisRow][parisCol] = 'P';
                            }
                        } else if (field[parisRow][parisCol] == 'H') {
                            //if paris reaches Helen
                            field[parisRow][parisCol] = '-';
                            System.out.print("Paris has successfully abducted Helen! ");
                            System.out.printf("Energy left: %d%n", energy);
                            isFound = true;
                            break;
                        } else {
                            //if paris moves to an empty index
                            field[parisRow][parisCol] = 'P';
                        }
                    }
                    break;

            }
            if (energy <= 0 && !isDead) {
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                field[parisRow][parisCol] = 'X';
                break;
            }

        }
       printMatrix(field, rows);
    }

    private static void printMatrix(char[][] field, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean validateUp(int parisRow) {
        return parisRow - 1 >= 0;
    }

    private static boolean validateDown(int parisRow, int rows) {
        return parisRow + 1 < rows;
    }

    private static boolean validateLeft(int parisCol) {
        return parisCol - 1 >= 0;
    }

    private static boolean validateRight(int parisCol, int cols) {
        return parisCol + 1 < cols;
    }
}
