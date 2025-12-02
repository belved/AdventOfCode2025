package model.Day2;

public class Id {

    private final String value;

    public Id(String value) {
        this.value = value;
    }

    public boolean isValidFromHalf() {
        return !value.substring(0, value.length()/2).equals(value.substring(value.length()/2));
    }

    public String getValue() {
        return value;
    }
}
