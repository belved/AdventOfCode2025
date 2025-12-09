package model.Day5;

import model.Day2.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range {

    private final Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");

    private long start;
    private long end;

    public Range(String value) {
        Matcher matcher = pattern.matcher(value);
        if(matcher.find()) {
            start = Long.parseLong(matcher.group(1));
            end = Long.parseLong(matcher.group(2));
        }
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}
