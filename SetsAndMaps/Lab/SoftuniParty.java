package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();
        TreeSet<String> vipGuests = new TreeSet<>();
        boolean arrived = false;
        String input = scan.nextLine();

       while (!input.equals("PARTY")) {

           if(Character.isDigit(input.charAt(0))) {
               vipGuests.add(input);
           } else {
               guests.add(input);
           }

           input = scan.nextLine();
       }
        input = scan.nextLine();
       while (!input.equals("END")) {

           if(Character.isDigit(input.charAt(0))) {
               vipGuests.remove(input);
           } else {
               guests.remove(input);
           }

           input = scan.nextLine();
       }
        System.out.println(vipGuests.size() + guests.size());
       if(!vipGuests.isEmpty()) {
        System.out.println(String.join(System.lineSeparator(), vipGuests));
       }
       if(!guests.isEmpty()) {
        System.out.println(String.join(System.lineSeparator(), guests));
       }
    }
}
