package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
            setName(name);
            setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int toppings) {
        if(toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories () {

        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(t -> t.calculateCalories()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %.2f", this.name, getOverallCalories()));
        return sb.toString();
    }

}
