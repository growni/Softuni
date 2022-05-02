package WildFarm;

public class Tiger extends Feline{

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {

        if(food instanceof Vegetable) {
            System.out.println("Tigers are not eating that type of food!");
        } else {
            super.eatFood(food);
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
