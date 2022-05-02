package ExamPrep;

import java.util.Scanner;

public class PawnStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = new String[8][];
        fillmatrix(matrix, scan);
        int whiteCol = findWhiteCol(matrix);
        int whiteRow = findWhiteRow(matrix);
        int blackCol = findBlackCol(matrix);
        int blackRow = findBlackRow(matrix);
        boolean whiteWins = false;
        boolean blackWins = false;

        while (whiteRow > 0 && blackRow < 7) {
            if(whiteRow == blackRow + 1) {
                if(whiteCol == blackCol - 1 || whiteCol == blackCol + 1) {
                    matrix[blackRow][blackCol] = "w";
                    matrix[whiteRow][whiteCol] = "-";
                    whiteCol = findWhiteCol(matrix);
                    whiteRow = findWhiteRow(matrix);
                    whiteWins = true;
                    break;
                } else {
                    matrix[whiteRow][whiteCol] = "-";
                    whiteRow--;
                    matrix[whiteRow][whiteCol] = "w";
                }
            } else {
                matrix[whiteRow][whiteCol] = "-";
                whiteRow--;
                matrix[whiteRow][whiteCol] = "w";
            }
            if(blackRow == whiteRow - 1) {
                if(blackCol == whiteCol - 1 || blackCol == whiteCol + 1) {
                    matrix[whiteRow][whiteCol] = "b";
                    matrix[blackRow][blackCol] = "-";
                    blackRow = findBlackRow(matrix);
                    blackCol = findBlackCol(matrix);
                    blackWins = true;
                    break;
                } else {
                    matrix[blackRow][blackCol] = "-";
                    blackRow++;
                    matrix[blackRow][blackCol] = "b";
                }
            } else {
                matrix[blackRow][blackCol] = "-";
                blackRow++;
                matrix[blackRow][blackCol] = "b";
            }
        }

        StringBuilder positionWhite = new StringBuilder();
        if(whiteCol == 0) {
            positionWhite.append("a");
        } else if(whiteCol == 1) {
            positionWhite.append("b");
        } else if(whiteCol == 2) {
            positionWhite.append("c");
        } else if(whiteCol == 3) {
            positionWhite.append("d");
        } else if(whiteCol == 4) {
            positionWhite.append("e");
        } else if(whiteCol == 5) {
            positionWhite.append("f");
        } else if(whiteCol == 6) {
            positionWhite.append("g");
        } else if(whiteCol == 7) {
            positionWhite.append("h");
        }
        if(whiteRow == 0) {
            positionWhite.append("8");
        } else if(whiteRow == 1) {
            positionWhite.append("7");
        } else if(whiteRow == 2) {
            positionWhite.append("6");
        } else if(whiteRow == 3) {
            positionWhite.append("5");
        } else if(whiteRow == 4) {
            positionWhite.append("4");
        } else if(whiteRow == 5) {
            positionWhite.append("3");
        } else if(whiteRow == 6) {
            positionWhite.append("2");
        } else if(whiteRow == 7) {
            positionWhite.append("1");
        }
        StringBuilder positionBlack = new StringBuilder();
        if(blackCol == 0) {
            positionBlack.append("a");
        } else if(blackCol == 1) {
            positionBlack.append("b");
        } else if(blackCol == 2) {
            positionBlack.append("c");
        } else if(blackCol == 3) {
            positionBlack.append("d");
        } else if(blackCol == 4) {
            positionBlack.append("e");
        } else if(blackCol == 5) {
            positionBlack.append("f");
        } else if(blackCol == 6) {
            positionBlack.append("g");
        } else if(blackCol == 7) {
            positionBlack.append("h");
        }
        if(blackRow == 0) {
            positionBlack.append("8");
        } else if(blackRow == 1) {
            positionBlack.append("7");
        } else if(blackRow == 2) {
            positionBlack.append("6");
        } else if(blackRow == 3) {
            positionBlack.append("5");
        } else if(blackRow == 4) {
            positionBlack.append("4");
        } else if(blackRow == 5) {
            positionBlack.append("3");
        } else if(blackRow == 6) {
            positionBlack.append("2");
        } else if(blackRow == 7) {
            positionBlack.append("1");
        }
        String output = "";
        if(blackWins) {
            output = "Game over! Black capture on " + positionBlack + ".";
            System.out.println(output);
        } else if(whiteWins) {
            output = "Game over! White capture on " + positionWhite + ".";
            System.out.println(output);
        }
        if(whiteRow == 0) {
            output = "Game over! White pawn is promoted to a queen at " + positionWhite + ".";
            System.out.println(output);
        } else if(blackRow == 7) {
            output = "Game over! Black pawn is promoted to a queen at " + positionBlack + ".";
            System.out.println(output);
        }
    }
    public static int findBlackRow (String[][] matrix) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(matrix[row][col].equals("b")) {
                    return row;
                }
            }
        }
        return 0;
    }
    public static int findBlackCol (String[][] matrix) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(matrix[row][col].equals("b")) {
                    return col;
                }
            }
        }
        return 0;
    }
    public static int findWhiteRow (String[][] matrix) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(matrix[row][col].equals("w")) {
                    return row;
                }
            }
        }
        return 0;
    }
    public static int findWhiteCol (String[][] matrix) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(matrix[row][col].equals("w")) {
                    return col;
                }
            }
        }
        return 0;
    }
    public static void fillmatrix (String[][] matrix, Scanner scan) {
        for (int row = 0; row < 8; row++) {
            matrix[row] = scan.nextLine().split("");
        }
    }
}
