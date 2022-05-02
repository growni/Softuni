package ExamPrep.hotel;

public class Person {
    public String getName() {
        return name;
    }

    private String name;
    private int id;
    private int age;

    public String getHometown() {
        return hometown;
    }

    private String hometown;

    public Person (String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }
}
