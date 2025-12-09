package model.Day5;

import java.util.List;

public class Ingredient {
    private long id;

    public Ingredient(long id) {
        this.id = id;
    }

    public boolean isFresh(long start, long end) {
        return id >= start && id <= end;
    }

    public boolean isFreshFromListOfRange(List<Range> ranges) {
        for(Range range: ranges) {
            if(isFresh(range.getStart(), range.getEnd())) return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }
}
