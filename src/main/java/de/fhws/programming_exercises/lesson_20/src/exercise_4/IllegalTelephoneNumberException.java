package de.fhws.programming_exercises.lesson_20.src.exercise_4;

public class IllegalTelephoneNumberException extends RuntimeException{
    public IllegalTelephoneNumberException(){
        super();
    }

    public IllegalTelephoneNumberException(String message){
        super(message);
    }
}
