package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double INITIAL_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        if(getOxygen() - 5 > 0) {
            setOxygen(getOxygen() - 5);
        } else {
            setOxygen(0);
        }
    }
}
