package de.fhws.programming_exercises.lesson_17.src.exercise_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionThrower{

    /**
     * @throws NumberFormatException tries to parse a decimal number as an Integer
     */
    public void throwNumberFormat() throws NumberFormatException{
        Integer.parseInt("1.2");
    }


    /**
     * @throws ArrayIndexOutOfBoundsException tries to read the 5th byte of a 2 byte Array
     */
    public void throwArrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException{
        byte[] arr = new byte[2];
        byte b = arr[4];
    }

    /**
     * @throws NullPointerException makes a String a null-Object and tries to read its length
     */
    public void throwNullPointer() throws NullPointerException{
        String str = null;
        str.length();
    }

    /**
     * @throws OutOfMemoryError creates a (relatively) massive Double-Array to overfill the JVM memory
     */
    public void throwOutOfMemory() throws OutOfMemoryError{
        double[][][][][] arr = new double[1000][1000][1000][1000][1000];
    }

    /**
     * @throws ArithmeticException tries to divide a number by 0
     */
    public void throwArithmetic() throws ArithmeticException{
        int i = 5 / 0;
    }

    /**
     * @throws FileNotFoundException tries to read a non-existing file
     */
    public void throwFileNotFound() throws FileNotFoundException{
        File file = new File("C://blablabla");
        InputStream inputStream = new FileInputStream(file);
    }

}


