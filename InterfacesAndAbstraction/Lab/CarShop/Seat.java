package CarShop;

public class Seat extends CarImpl implements Sellable{

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("This is %s produced in %s and have %s horse power\n",
                this.getModel(), this.countryProduced(), this.getHorsePower()));
        sb.append(String.format("%s sells for %f",
                this.getModel(), this.price));
        return sb.toString();
    }

}
