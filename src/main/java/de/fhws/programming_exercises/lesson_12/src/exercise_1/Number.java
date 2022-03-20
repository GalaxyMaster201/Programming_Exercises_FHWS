package de.fhws.programming_exercises.lesson_12.src.exercise_1;

public class Number{
    private final int value;
    Number next;

    public Number(int value){
        this.value = value;
    }

    public int getVal(){
        return value;
    }

}
