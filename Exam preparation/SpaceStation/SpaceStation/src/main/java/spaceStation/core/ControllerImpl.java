package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private PlanetRepository planets;
    private AstronautRepository astronauts;
    private int exploredPlanets;

    public ControllerImpl() {
        planets = new PlanetRepository();
        astronauts = new AstronautRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        if(type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
            astronauts.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else if(type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
            astronauts.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else if(type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
            astronauts.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = null;
        for (Astronaut a : astronauts.getModels()) {
            if(a.getName().equals(astronautName)) {
                astronaut = a;
                astronauts.remove(astronaut);
                return String.format(ASTRONAUT_RETIRED, astronautName);
            }
        }
        if(astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        return String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = null;
        for (Planet p : planets.getModels()) {
            if(p.getName().equals(planetName)) {
                planet = p;
            }
        }
        List<Astronaut> astronauts = this.astronauts.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if(astronauts.size() == 0) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(planet, astronauts);
        List<Astronaut> deadAstronauts = new ArrayList<>();
        for (Astronaut astronaut : astronauts) {
            if(astronaut.getOxygen() == 0) {
                deadAstronauts.add(astronaut);
            }
        }
        exploredPlanets++;
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();
        sb.append(String.format("%d planets were explored!", exploredPlanets));
        sb.append("\n");
        sb.append("Astronauts info:");
        sb.append("\n");
//        for (Astronaut model : astronauts.getModels()) {
//            sb.append(model);
//        }
        sb.append(astronauts.getModels().stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
