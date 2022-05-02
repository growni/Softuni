package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping (String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType (String type) {
        if(!type.equals("Meat") && !type.equals("Veggies") && !type.equals("Cheese") && !type.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.toppingType = type;
    }

    private void setWeight (double weight) {
        if(weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        double calories = 0;
        switch (toppingType) {
            case "Meat":
                calories = 2 * weight * 1.2;
                break;
            case "Veggies":
                calories = 2 * weight * 0.8;
                break;
            case "Cheese":
                calories = 2 * weight * 1.1;
                break;
            case "Sauce":
                calories = 2 * weight * 0.9;
                break;
        }
        return calories;
    }
}
