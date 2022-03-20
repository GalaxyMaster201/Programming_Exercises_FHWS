package de.fhws.programming_exercises.extra;

public class CheckInput {

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLengthInRange(String s, int min, boolean inclusiveMin, int max, boolean inclusiveMax){
        boolean flagMax;
        boolean flagMin;

        if (inclusiveMin) {
            flagMin = s.length() >= min;
        }else {
            flagMin = s.length() > min;
        }
        if (inclusiveMax) {
            flagMax = s.length() <= max;
        }else {
            flagMax = s.length() < max;
        }
        return (flagMin && flagMax);
    }

    public boolean isIntegerInRange(int input, int min, boolean inclusiveMin, int max, boolean inclusiveMax){
        boolean flagMax;
        boolean flagMin;

        if (inclusiveMin) {
            flagMin = input >= min;
        }else {
            flagMin = input > min;
        }

        if (inclusiveMax) {
            flagMax = input <= max;
        }else {
            flagMax = input < max;
        }
        return (flagMin && flagMax);
    }

    public boolean isDoubleInRange(double input, double min, boolean inclusiveMin, double max, boolean inclusiveMax, int precisionLevel){
        boolean flagMin;
        boolean flagMax;

        boolean equalsMin = Math.abs(input - min) < Math.pow(10d, -1 * precisionLevel);
        boolean equalsMax = Math.abs(max - input) < Math.pow(10d, -1 * precisionLevel);

        if (inclusiveMin) {
            flagMin = input > min || equalsMin;
        }else {
            flagMin = input > min && !equalsMin;
        }

        if (inclusiveMax) {
            flagMax = input < max || equalsMax;
        }else {
            flagMax = input < max && !equalsMax;
        }
        return (flagMin && flagMax);
    }
}
