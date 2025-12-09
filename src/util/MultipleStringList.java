package util;

import java.util.List;

public class MultipleStringList {

    private final List<String> string1;

    private final List<String> string2;

    public MultipleStringList(List<String> s1, List<String> s2) {
        this.string1 = s1;
        this.string2 = s2;
    }

    public List<String> getFirstList() {
        return string1;
    }

    public List<String> getSecondList() {
        return string2;
    }
}
