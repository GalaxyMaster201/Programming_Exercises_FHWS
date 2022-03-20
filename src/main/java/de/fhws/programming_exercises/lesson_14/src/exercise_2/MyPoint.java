package de.fhws.programming_exercises.lesson_14.src.exercise_2;

public class MyPoint{
    int x;
    int y;

    public void movePoint(int zielX, int zielY){

        boolean tooSmall = zielX < 0 || zielY < 0;
        boolean tooLarge = zielX > 1920 || zielY > 1080;

        if (tooSmall || tooLarge){
            throw new RuntimeException("Invalid coordinates");
        }

        x = zielX;
        y = zielY;
    }
}
