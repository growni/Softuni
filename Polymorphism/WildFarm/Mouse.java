package WildFarm;

public class Mouse extends Mammal{

    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if(food instanceof Meat) {
            System.out.println("Mice are not eating that type of food!");
        } else {
            super.eatFood(food);
        }
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
