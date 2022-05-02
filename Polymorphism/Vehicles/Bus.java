package Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    public static final double FULL_BUS_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption + FULL_BUS_ADDITIONAL_CONSUMPTION, capacity);
    }

    String driveEmpty(double distance) {
        double fuelNeeded = distance * fuelConsumption - FULL_BUS_ADDITIONAL_CONSUMPTION;
        if(fuelNeeded > fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuelQuantity -= fuelNeeded;
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }
}
