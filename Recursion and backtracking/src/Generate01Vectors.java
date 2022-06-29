import java.util.Scanner;

public class Generate01Vectors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Integer[] memory = new Integer[n];
        int index = 0;

        fillVector(memory, index);
    }

    private static void fillVector(Integer[] memory, int index) {
        if(index >= memory.length) {
            print(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }

    }

    private static void print(Integer[] memory) {
        for (Integer position : memory) {
            System.out.print(position);
        }
        System.out.println();
    }
}
