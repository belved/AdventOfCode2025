package model.Day5;

import java.util.List;

public record Ingredient(long id) {

    public boolean isFresh(long start, long end) {
        return id >= start && id <= end;
    }

    public boolean isFreshFromListOfRange(List<Range> ranges) {
        for (Range range : ranges) {
            if (isFresh(range.getStart(), range.getEnd())) return true;
        }
        return false;
    }
}
