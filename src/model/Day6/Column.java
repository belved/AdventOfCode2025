package model.Day6;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private final List<String> values;
    private final String operator;

    private List<String> line;

    public Column(List<String> values, String operator) {
        this.values = values;
        this.operator = operator;
    }

    public Problem convertToProblem() {
        String[] values = new String[this.values.size()];

        columnToList();

        for(int i = 0; i < line.size(); i++){
            values[i] = this.line.get(i).trim();
        }

        return new Problem(values, operator);
    }

    public List<String> columnToList() {
        line = new ArrayList<>();
        for(int i = 0; i < values.getFirst().length(); i++) {
            StringBuilder temp = new StringBuilder();
            for(String v : values) {
                temp.append(v.charAt(i));
            }
            line.add(temp.toString());
        }

        return line;
    }
}
