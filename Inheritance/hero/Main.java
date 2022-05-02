package hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Elf elf = new Elf("Growni", 60);
        System.out.println(elf);
        Hero hero = new Hero("Adam", 40);
        System.out.println(hero);


    }
}
