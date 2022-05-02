package fairyShop.models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) { //TODO: fix method if needed
        ArrayList<Instrument> instrumentsList = new ArrayList<>(helper.getInstruments());
        instrumentsList.removeIf(Instrument::isBroken);

        for (Instrument instrument : instrumentsList) {
            while (!instrument.isBroken() && !present.isDone() && helper.canWork()) {
                instrument.use();
                helper.work();
                present.getCrafted();
            }
        }
    }
}
