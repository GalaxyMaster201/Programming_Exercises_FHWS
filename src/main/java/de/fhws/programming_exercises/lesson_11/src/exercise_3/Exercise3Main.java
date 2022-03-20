package de.fhws.programming_exercises.lesson_11.src.exercise_3;

public class Exercise3Main{
    public static void main(String[] args){
        short s = -20;
        int i = -5687;
        long l = -70984048;
        float f = -547.9989f;
        double d = -6.897985956498779898756465e-15;

        System.out.println("Short:   "+s+" -> "+calcAbs(s));
        System.out.println("Integer: "+i+" -> "+calcAbs(i));
        System.out.println("Long:    "+l+" -> "+calcAbs(l));
        System.out.println("Float:   "+f+" -> "+calcAbs(f));
        System.out.println("Double:  "+d+" -> "+calcAbs(d));
    }

    /**
     * Calculates the absolute value of different data types
     * @param input short, integer, long, float or double number input
     * @return the absolute value of the input
     */

    private static short calcAbs(short input){
        if (input < 0){
            return  (short) (input * (-1));
        }else {
            return input;
        }

    }

    private static int calcAbs(int input){
        if (input < 0){
            return input * (-1);
        }else {
            return input;
        }

    }

    private static long calcAbs(long input){
        if (input < 0){
            return input * (-1);
        }else {
            return input;
        }

    }

    private static float calcAbs(float input){
        if (input < 0){
            return input * (-1);
        }else {
            return input;
        }
    }

    private static double calcAbs(double input){
        if (input < 0){
            return input * (-1);
        }else {
            return input;
        }
    }
}
