package FoodStorage;

public class Rebel implements Person, Buyer{

    private String name;
    private int age;
    private String  group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return group;
    }

    public int getFood() {
        return food;
    }

    public void buyFood() {
        this.food += 5;
    }
}
