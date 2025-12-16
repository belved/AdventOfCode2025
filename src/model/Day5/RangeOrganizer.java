package model.Day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record RangeOrganizer(List<Range> ranges) {

    public void sortRanges() {
        Collections.sort(ranges);
    }

    public void mergeRange() {
        List<Range> newRanges = new ArrayList<>();
        boolean hasChanged;
        do {
            hasChanged = false;
            newRanges.clear();
            sortRanges();
            for (int i = 0; i < ranges.size() - 1; i++) {
                if (ranges.get(i).getEnd() >= ranges.get(i + 1).getStart()) {
                    Range r1 = ranges.get(i);
                    Range r2 = ranges.get(i + 1);
                    newRanges.add(new Range(Math.min(r1.getStart(), r2.getStart()), Math.max(r1.getEnd(), r2.getEnd())));
                    ranges.remove(i);
                    ranges.remove(i);
                    hasChanged = true;
                }
            }
            if (hasChanged) {
                ranges.addAll(newRanges);
            }
        } while (hasChanged);
    }

    public long getFreshIdCount() {
        long count = 0;
        for (Range range : ranges) {
            count += range.getEnd() - range.getStart() + 1;
        }
        return count;
    }
}
