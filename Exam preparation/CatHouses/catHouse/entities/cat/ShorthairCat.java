package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static int initialKilograms = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(initialKilograms);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
