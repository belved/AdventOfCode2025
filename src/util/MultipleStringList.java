package util;

import java.util.List;

public record MultipleStringList(List<String> string1, List<String> string2) {

    public List<String> getFirstList() {
        return string1;
    }

    public List<String> getSecondList() {
        return string2;
    }
}
