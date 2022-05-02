package ExamPrep.hotel;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alex", 33130, 25, "Montana");
        Person person1 = new Person("Mike", 12451, 14, "Sofia");
        Person person2 = new Person("Nicole", 99243, 27, "Sofia");
        Hotel hotel = new Hotel("Hilton", 15);

        hotel.add(person);
        hotel.add(person1);
        hotel.add(person2);
        System.out.println(hotel.getPerson("anna", "Montana"));
        System.out.println(hotel.getCount());
        System.out.println(hotel.getStatistics());
        System.out.println(hotel.remove("Alex"));
    }
}
