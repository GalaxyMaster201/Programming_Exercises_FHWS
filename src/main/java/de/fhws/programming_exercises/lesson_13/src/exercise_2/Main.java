package de.fhws.programming_exercises.lesson_13.src.exercise_2;

public class Main{
    public static void main(String[] args){
        Checkerboard checkerboard = new Checkerboard();

        System.out.println(checkerboard);

        checkerboard.setRook(3, 5);

        System.out.println(checkerboard);
    }
}
