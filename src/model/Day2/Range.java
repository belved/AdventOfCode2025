package model.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range {
    private final List<Id> idRange = new ArrayList<>();
    private final List<Id> invalidId = new ArrayList<>();

    private final Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");

    public Range(String value) {
        String[] values = value.split(",");

        setIdRange(values);
    }

    private void setIdRange(String[] value) {
        for(String s : value) {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                addRange(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)));
            }
        }
    }

    private void addRange(long start, long end) {
        for(long i = start; i <= end; i++) {
            idRange.add(new Id(""+i));
        }
    }

    public long getSumOfInvalidIdFromHalf() {
        long sum = 0;
        for(Id id : idRange) {
            if(!id.isValidFromHalf()) {
                invalidId.add(id);
                sum += Long.parseLong(id.getValue());
            }
        }
        return sum;
    }

    public List<Id> getIdRange() {
        return idRange;
    }
}
