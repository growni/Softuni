package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.StringJoiner;

import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut{

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if(oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        if(oxygen > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        if(oxygen - 10 > 0) {
            setOxygen(oxygen - 10);
        } else {
            setOxygen(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s", name));
        sb.append("\n");
        sb.append(String.format("Oxygen: %.0f", oxygen));
        sb.append("\n");
        sb.append("Bag items: ");
        if(bag.getItems().size() > 0) {
            sb.append(String.join(", ", bag.getItems()));
        } else {
            sb.append("none");
        }
        return sb.toString();
    }
}
