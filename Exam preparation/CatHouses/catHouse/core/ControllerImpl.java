package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
        }
        if (house == null) {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, house.getClass().getSimpleName());
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
        }
        if (toy == null) {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, toy.getClass().getSimpleName());
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
        }
        if (cat == null) {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        String houseType = house.getClass().getSimpleName().substring(0, 2);
        String catTypeCheck = cat.getClass().getSimpleName().substring(0, 2);
        if (houseType.equals(catTypeCheck)) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }
        return UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        house.getCats().forEach(Cat::eating);
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        double catsValue = house.getCats().stream().map(Cat::getPrice).mapToDouble(Double::doubleValue).sum();
        double toysValue = house.getToys().stream().map(Toy::getPrice).mapToDouble(Double::doubleValue).sum();
        double houseValue = toysValue + catsValue;
        return String.format(VALUE_HOUSE, houseName, houseValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses) {
            sb.append(house.getName()).append(" ").append(house.getClass().getSimpleName()).append(":").append(System.lineSeparator());
            sb.append(house.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
