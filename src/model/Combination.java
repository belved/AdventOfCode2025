package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Combination {

    private boolean isTurnRight = true;
    private int numberOfRotation = 0;

    public Combination(String value) {
        Pattern pattern = Pattern.compile("([RL])(\\d+)");
        Matcher matcher = pattern.matcher(value);
        if(matcher.find()) {
            this.isTurnRight = matcher.group(1).equals("R");
            this.numberOfRotation = Integer.parseInt(matcher.group(2));
        }
    }

    public boolean getIsTurnRight() {
        return isTurnRight;
    }

    public int getNumberOfRotation() {
        return numberOfRotation;
    }

    public int rotate() {
        return isTurnRight? numberOfRotation : -numberOfRotation;
    }
}
