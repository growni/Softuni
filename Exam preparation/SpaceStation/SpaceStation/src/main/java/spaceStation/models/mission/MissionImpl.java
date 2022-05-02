package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.*;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{


    public MissionImpl() {

    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        ArrayDeque<String> planetItems = new ArrayDeque<>();
        for (String item : planet.getItems()) {
            planetItems.push(item);
        }

        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath()) {
                astronaut.getBag().getItems().add(planetItems.pop());
                astronaut.breath();
                if(planetItems.size() == 0) {
                    return;
                }
            }
        }
    }
}
