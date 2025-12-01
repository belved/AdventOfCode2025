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
        boolean isPositive = true;
        boolean wasZero = false;
        boolean temp;
        for(Combination c : combinationList) {
            currentValue += c.rotate();

            temp = currentValue > 0;
            if(shouldCountWhenPassing) {
                if(isPositive != temp && currentValue != 0 && !wasZero) numberOfZero++;
                if(Math.abs(currentValue) > maxValue) numberOfZero += Math.abs(currentValue)/100;
            }
            if((maxValue + currentValue)%100 == 0) numberOfZero++;

            wasZero = currentValue == 0;
            isPositive = temp;
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
