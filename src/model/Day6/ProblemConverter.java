package model.Day6;

import java.util.ArrayList;
import java.util.List;

public class ProblemConverter {

    private final String line1;
    private final String line2;
    private final String line3;
    private final String line4;
    private final String operator;

    private int columnIndex = 0;
    private final int maxLength;

    private final List<Column> columns = new ArrayList<>();

    public ProblemConverter(String s1, String s2, String s3, String s4, String o) {
        line1 = s1;
        line2 = s2;
        line3 = s3;
        line4 = s4;
        operator = o;

        maxLength = o.length();
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<String> readNextColumn() {
        List<String> column = new ArrayList<>();

        int start = columnIndex;
        findNextOperator(operator);
        int end = columnIndex;

        column.add(line1.substring(start, end-1));
        column.add(line2.substring(start, end-1));
        column.add(line3.substring(start, end-1));
        column.add(line4.substring(start, end-1));

        columns.add(new Column(column, operator.substring(start, start+1)));

        return column;
    }

    public boolean hasNextColumn() {
        return columnIndex < maxLength;
    }

    private void findNextOperator(String operator) {
        for(int i = columnIndex+1; i < operator.length(); i++) {
            if(operator.charAt(i) == '+' || operator.charAt(i) == '*') {
                columnIndex = i;
                break;
            } else {
                columnIndex = operator.length()+1;
            }
        }
    }
}
