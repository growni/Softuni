package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static int initialKilograms = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(initialKilograms);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 3);
    }
}
