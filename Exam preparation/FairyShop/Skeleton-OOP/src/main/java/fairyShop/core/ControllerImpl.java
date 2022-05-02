package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.List;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private int presentsDone;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper = null;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
        }
        if(helper == null) {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER, helper.getClass().getSimpleName(), helper.getName());
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if(helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        helper.addInstrument(new InstrumentImpl(power));
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        presentRepository.add(new PresentImpl(presentName, energyRequired));
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> availableHelpers = new ArrayList<>();
//        helperRepository.getModels().stream().filter(h -> h.getEnergy() > 50).map(availableHelpers::add);
        for (Helper model : helperRepository.getModels()) {
            if(model.getEnergy() > 50) {
                availableHelpers.add(model);
            }
        }
        if(availableHelpers.size() == 0) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        Shop shop = new ShopImpl();
        Present present = presentRepository.findByName(presentName);
        int brokenInstruments = 0;
        for (Helper helper : availableHelpers) {
            shop.craft(present, helper);
//            brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
            for (Instrument instrument : helper.getInstruments()) {
                if(instrument.isBroken()) {
                    brokenInstruments++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(present.isDone()) {
            this.presentsDone++;
            sb.append(String.format(PRESENT_DONE, presentName, "done."));
        } else {
            sb.append(String.format(PRESENT_DONE, presentName, "not done."));
        }
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
        return sb.toString();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", presentsDone)).append(System.lineSeparator())
                .append("Helpers info:").append(System.lineSeparator());

            for (Helper model : helperRepository.getModels()) {
                sb.append(model);
                sb.append(System.lineSeparator());
            }

        return sb.toString().trim();
    }
}
