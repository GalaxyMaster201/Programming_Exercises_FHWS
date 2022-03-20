package de.fhws.programming_exercises.lesson_13.src.exercise_1;

public class Main{
    public static void main(String[] args){
        Point p1 = new Point(6, 2, 3);
        System.out.println(p1);
        System.out.println(p1.calculateDistance());
        Point p2 = new Point(3, 5, 7);
        System.out.println(p2);
        System.out.println(p2.calculateDistance());
    }
}
