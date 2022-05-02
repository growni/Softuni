package RandomArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        RandomArrayList rndList = new RandomArrayList();
        for (int i = 0; i < 50; i++) {
            rndList.add(i);
        }
        System.out.println(rndList.getRandomElement());
    }
}
