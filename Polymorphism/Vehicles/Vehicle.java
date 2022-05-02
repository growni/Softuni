package Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double capacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double capacity) {
        setCapacity(capacity);
        setFuelConsumption(fuelConsumption);
        setFuelQuantity(fuelQuantity);
    }

    String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if(fuelNeeded > fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuelQuantity -= fuelNeeded;
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    void refuel(double liters) {

        if(liters <= 0){
            System.out.println("Fuel must be a positive number");
        } else if(liters + fuelQuantity > this.capacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
