package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fairyShop.common.ExceptionMessages.*;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        setName(name);
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void work() {
        if (this.energy - 10 < 0) {
            this.energy = 0;
        } else {
            this.energy -= 10;
        }
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s", name)).append(System.lineSeparator())
                .append(String.format("Energy: %d", energy)).append(System.lineSeparator());
//        List<Instrument> goodInstruments = new ArrayList<>();
//        this.instruments.stream().filter(i -> !i.isBroken()).map(goodInstruments::add);
//        int count = (int) instruments.stream().filter(i -> !i.isBroken()).count();
        int count = 0;
        for (Instrument instrument : instruments) {
            if(!instrument.isBroken()) {
                count++;
            }
        }
        sb.append(String.format("Instruments: %d not broken left", count));
        return sb.toString();
    }
}
