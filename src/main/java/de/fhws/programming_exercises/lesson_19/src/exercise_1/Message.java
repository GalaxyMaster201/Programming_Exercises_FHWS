package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.Serializable;

public class Message implements Serializable{
    String msgText;

    public Message(String text){
        this.msgText = text;
    }
}
