package model.Day2;

public record Id(String value) {

    public boolean isValidFromHalf() {
        return !value.substring(0, value.length() / 2).equals(value.substring(value.length() / 2));
    }

    public boolean isValidFromEverywhere() {
        StringBuilder valueToCheck = new StringBuilder();
        for (int i = 0; i < (value.length() / 2); i++) {
            valueToCheck.append(value.charAt(i));
            if (value.substring(i + 1, (i + 1) * 2).contains(valueToCheck.toString())) {
                if (verifyItNotContainsOtherNumbers(value, valueToCheck.toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verifyItNotContainsOtherNumbers(String value, String valueToCheck) {
        for (int i = 0; i + valueToCheck.length() <= value.length(); i += valueToCheck.length()) {
            if (value.length() % valueToCheck.length() != 0) return false;
            String temp = value.substring(i, i + valueToCheck.length());
            if (!temp.equals(valueToCheck)) {
                return false;
            }
        }
        return true;
    }
}
