package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.Serializable;

public class Guess implements Serializable{
    char character;

    public Guess(char character){
        this.character = character;
    }
}
