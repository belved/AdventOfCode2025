package model.Day4;

public class Location {

    private final boolean isPaperRoll;
    private boolean isAccessible = false;

    public Location(String value) {
        this.isPaperRoll = value.equals("@");
    }

    public boolean isPaperRoll() {
        return isPaperRoll;
    }

    public void setAccessible(boolean accessible) {
        this.isAccessible = accessible;
    }

    public boolean isAccessible() {
        return isPaperRoll && isAccessible;
    }
}
