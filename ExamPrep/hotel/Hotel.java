package ExamPrep.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private int capacity;
    private List<Person> roster;
    private int guestsCount;

    public Hotel(String name, int capacity) {
        this.hotelName = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.capacity >= guestsCount) {
            this.roster.add(person);
            guestsCount++;
        }
    }
    public boolean remove(String name) {
        for (Person person : roster) {
            if(person.getName().equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
    }
    public Person getPerson (String name, String hometown) {
        Person person = null;
        for (Person p : roster) {
            if(p.getName().equals(name) && p.getHometown().equals(hometown)) {
                person = p;
            }
        }
        return person;
    }
    public int getCount () {
        return this.guestsCount;
    }

    public StringBuilder getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The people in this hotel %s are:%n", hotelName));
        for (Person person : roster) {
            sb.append(String.format(person + "\n"));
        }
        return sb;
    }
}
