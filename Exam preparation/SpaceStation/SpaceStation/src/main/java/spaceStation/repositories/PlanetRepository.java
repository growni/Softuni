package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class PlanetRepository implements Repository<Planet>{

    private Collection<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return planets;
    }

    @Override
    public void add(Planet model) {
        planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        try {
            planets.remove(model);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public Planet findByName(String name) {
        Planet planet = null;
        for (Planet p : planets) {
            if(p.getName().equals(name)) {
                planet = p;
            }
        }
        return planet;
    }
}
