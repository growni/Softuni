package Animals;

public class Cat extends Animal{

    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s\nMEEOW", this.getName(), this.getFavouriteFood());
    }
}
