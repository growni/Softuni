package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList {
    private ArrayList<String> data;

    public void push(String item) {
        data.add(0, item);
    }

    public String pop() {
        return data.remove(0);
    }

    public String peek() {
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
