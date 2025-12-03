package model.Day3;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Battery> batteryList = new ArrayList<>();

    public Bank(String data){
        for(int i = 0; i < data.length(); i++) {
            String temp = data.substring(i, i+1);
            batteryList.add(new Battery(temp));
        }
    }

    public int getMaxJoltageValue() {
        int idOfFirstBiggestValue = 0;

        //Checking first value
        for(int i = 0; i < batteryList.size()-1; i++) {
            if(batteryList.get(i).getJoltage() > batteryList.get(idOfFirstBiggestValue).getJoltage()) {
                idOfFirstBiggestValue = i;
            }
        }

        int idOfSecondBiggestValue = idOfFirstBiggestValue+1;
        //Checking secondValue
        for(int i = idOfSecondBiggestValue; i < batteryList.size(); i++) {
            if(batteryList.get(i).getJoltage() > batteryList.get(idOfSecondBiggestValue).getJoltage()) {
                idOfSecondBiggestValue = i;
            }
        }

        String value = batteryList.get(idOfFirstBiggestValue).getJoltage()+""+batteryList.get(idOfSecondBiggestValue).getJoltage();
        return Integer.parseInt(value);
    }

    public List<Battery> getBatteryList() {
        return batteryList;
    }
}
