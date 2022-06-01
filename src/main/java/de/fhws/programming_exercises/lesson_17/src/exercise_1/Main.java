package de.fhws.programming_exercises.lesson_17.src.exercise_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        ExceptionThrower eT = new ExceptionThrower();

        System.out.println("Choose the Exception/Error you would like to cause: ");
        System.out.println("""
                1) NumberFormatException\s
                2) ArrayIndexOutOfBoundsException
                3) NullPointerException\s
                4) OutOfMemoryError\s
                5) ArithmeticException\s
                6) FileNotFoundException""");

        switch (scanner.nextInt()){
            case 1 -> eT.throwNumberFormat();
            case 2 -> eT.throwArrayIndexOutOfBounds();
            case 3 -> eT.throwNullPointer();
            case 4 -> eT.throwOutOfMemory();
            case 5 -> eT.throwFileNotFound();
            case 6 -> eT.throwArithmetic();
            default -> System.out.println("You managed to break an Exception Thrower, congratulations!");
        }
        scanner.close();
    }
}
