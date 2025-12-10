package model.Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range implements Comparable<Range>{

    private long start;
    private long end;

    public Range(String value) {
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
        Matcher matcher = pattern.matcher(value);
        if(matcher.find()) {
            start = Long.parseLong(matcher.group(1));
            end = Long.parseLong(matcher.group(2));
        }
    }

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public List<Long> getAllId() {
        List<Long> values = new ArrayList<>();
        for(long i = start; i <= end; i++) {
            values.add(i);
        }
        return  values;
    }

    @Override
    public int compareTo(Range o) {
        return Long.compare(this.start, o.start);
    }
}
