package de.fhws.programming_exercises.lesson_18.src.exercise_2;

public enum TCPComm{
    STOP("--stop"),
    READY("--ready");

    final String value;

    TCPComm(String value){
        this.value = value;
    }
}
