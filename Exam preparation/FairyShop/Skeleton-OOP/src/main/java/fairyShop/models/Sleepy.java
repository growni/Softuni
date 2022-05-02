package fairyShop.models;

public class Sleepy extends BaseHelper{
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        if(getEnergy() - 15 < 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 15);
        }
    }
}
