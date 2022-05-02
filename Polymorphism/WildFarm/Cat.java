package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), getAnimalName(), this.breed,
                df.format(getAnimalWeight()), this.getLivingRegion(), getFoodEaten());
    }

}
