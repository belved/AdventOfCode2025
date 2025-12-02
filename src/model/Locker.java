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

    public void countWhenPassingZero() {
        int rotation;
        for(Combination combination : combinationList) {
            rotation = combination.rotate();
            if(Math.abs(rotation) > maxValue) {
                numberOfZero += Math.abs(rotation)/maxValue;
                rotation = rotation % maxValue;
            }

            if(currentValue > 0 && currentValue+rotation < 0 || currentValue < 0 && currentValue+rotation > 0) {
                numberOfZero++;
            }

            currentValue += rotation;

            if(Math.abs(currentValue) >= maxValue && rotation != 0) {
                numberOfZero += Math.abs(currentValue)/maxValue;
                currentValue = currentValue % maxValue;
            } else if(currentValue == 0 && rotation != 0) {
                numberOfZero++;
            }
        }
    }

    public int unlock() {
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
