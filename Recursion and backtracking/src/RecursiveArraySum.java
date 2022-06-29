import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        System.out.println(sum(numbers, index));
    }

    public static int sum(int[] numbers, int index) {
        if(index == numbers.length) {
            return 0;
        }

        return numbers[index] +  sum(numbers, index + 1);
    }
}
