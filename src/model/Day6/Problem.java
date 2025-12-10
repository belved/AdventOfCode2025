package model.Day6;

public class Problem {

    private final long[] values = new long[4];
    private final String operator;

    public Problem(String[] values, String operator) {
        this.operator = operator;
        for(int i = 0; i < values.length; i++){
            this.values[i] = Long.parseLong(values[i]);
        }
    }

    public long compute() {
        if(operator.equals("+")){
            return sum();
        } else {
            return multiply();
        }
    }

    private long sum() {
        long sum = 0;
        for (long value : values) {
            sum += value;
        }
        return sum;
    }

    private long multiply() {
        long multiply = 1;
        for (long value : values) {
            multiply *= value;
        }
        return multiply;
    }

    public String getOperator() {
        return operator;
    }

    public long[] getValues() {
        return values;
    }
}
