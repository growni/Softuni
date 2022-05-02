package WildFarm;

import java.text.DecimalFormat;

public  abstract class Mammal extends Animal{
   private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), getAnimalName(),
                df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
