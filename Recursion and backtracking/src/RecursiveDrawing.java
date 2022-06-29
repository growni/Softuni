import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        printFigure(input);
    }

    public static void printFigure(int input) {
       if(input == 0) {
           return;
       }

        for (int i = 0; i < input; i++) {
            printLine('*');
        }

        System.out.println();

        printFigure(input - 1);

        for (int i = input; i > 0; i--) {
            printLine('#');
        }
        System.out.println();
    }

    public static void printLine(char symbol) {
        System.out.print(symbol);
    }
}
