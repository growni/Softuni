package Vehicles;

public class Truck extends Vehicle{
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.4;


    public Truck(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION, capacity);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() * 0.95);

        if(liters <= 0){
            System.out.println("Fuel must be a positive number");
        } else if(liters + fuelQuantity > this.capacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }
}
