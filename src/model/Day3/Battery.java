package model.Day3;

public class Battery {

    private int joltage = -1;
    private boolean isTaken = false;

    public Battery(String value) {
        int temp = Integer.parseInt(value);
        if(temp > 0 && temp < 10) {
            joltage = temp;
        }
    }

    public int getJoltage() {
        return joltage;
    }

    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public boolean isTaken() {
        return isTaken;
    }
}
