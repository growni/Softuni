package SingleInheritance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Animal animal = new Animal();
        animal.eat();
        Dog dog = new Dog();
        dog.bark();
        dog.eat();
    }
}
