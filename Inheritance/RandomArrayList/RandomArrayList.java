package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        Random rnd = new Random();
        return super.get(rnd.nextInt(super.size()));
    }
}
