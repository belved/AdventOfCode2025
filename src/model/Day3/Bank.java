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

    public Long getMaxJoltageValue(int numberOfBattery) {
        int numberOfBatteryLeft = numberOfBattery;
        int idOfFirstBiggestValue = 0;
        StringBuilder value = new StringBuilder();

        //Checking first value
        for(int i = 0; i < batteryList.size()-(numberOfBatteryLeft-1); i++) {
            if(batteryList.get(i).getJoltage() > batteryList.get(idOfFirstBiggestValue).getJoltage()) {
                idOfFirstBiggestValue = i;
            }
        }

        batteryList.get(idOfFirstBiggestValue).setTaken(true);

        numberOfBatteryLeft--;
        int idBiggestValue = idOfFirstBiggestValue + 1;

        while (numberOfBatteryLeft > 0) {
            idBiggestValue = findBiggestValueIdLeft(idBiggestValue, batteryList.size()-(numberOfBatteryLeft-1));
            batteryList.get(idBiggestValue).setTaken(true);
            numberOfBatteryLeft--;
            idBiggestValue++;
        }

        for(Battery b : batteryList) {
            if(b.isTaken()) {
                value.append(b.getJoltage());
            }
        }

        return Long.parseLong(value.toString());
    }

    private int findBiggestValueIdLeft(int start, int end) {
        int temp = 0;
        int id = start;
        for(int i = start; i <= end-1; i++) {
            if(batteryList.get(i).getJoltage() > temp && !batteryList.get(i).isTaken()) {
                id = i;
                temp = batteryList.get(i).getJoltage();
            }
        }
        return id;
    }

    public List<Battery> getBatteryList() {
        return batteryList;
    }
}
