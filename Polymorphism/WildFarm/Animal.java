package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

 public Animal(String animalName, String animalType, Double animalWeight) {
  this.animalName = animalName;
  this.animalType = animalType;
  this.animalWeight = animalWeight;
  this.foodEaten = foodEaten = 0;
 }

 public abstract void makeSound();


 public void eatFood(Food food) {
  this.foodEaten += food.getQuantity();
 }


 public String getAnimalName() {
  return this.animalName;
 }


 public void setAnimalName(String animalName) {
  this.animalName = animalName;
 }

 public String getAnimalType() {
  return this.animalType;
 }


 public void setAnimalType(String animalType) {
  this.animalType = animalType;
 }


 public Double getAnimalWeight() {
  return this.animalWeight;
 }


 public void setAnimalWeight(Double animalWeight) {
  this.animalWeight = animalWeight;
 }


 public Integer getFoodEaten() {
  return foodEaten;
 }


 public void setFoodEaten(Integer foodEaten) {
  this.foodEaten = foodEaten;
 }


}
