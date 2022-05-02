package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class AstronautRepository implements Repository<Astronaut>{

    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return astronauts;
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        try {
            astronauts.remove(model);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut astronaut = null;
        for (Astronaut a : astronauts) {
            if(a.getName().equals(name)) {
                astronaut = a;
            }
        }
        return astronaut;
    }
}
