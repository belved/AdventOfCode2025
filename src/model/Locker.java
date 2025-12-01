package model;

import java.util.ArrayList;
import java.util.List;

public class Locker {

    private final List<Combination> combinationList = new ArrayList<>();
    private final int maxValue = 100;

    private int numberOfZero = 0;
    private int currentValue = 50;

    public Locker(List<String> data) {
        for(String s : data) {
            combinationList.add(new Combination(s));
        }
    }

    public int unlock(boolean shouldCountWhenPassing) {
        for(Combination c : combinationList) {
            currentValue += c.rotate();
            if((maxValue + currentValue)%100 == 0) numberOfZero++;
        }

        return (maxValue + currentValue)%100;
    }

    public List<Combination> getCombinationList() {
        return combinationList;
    }

    public int getNumberOfZero() {
        return numberOfZero;
    }
}
