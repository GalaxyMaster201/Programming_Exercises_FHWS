package de.fhws.programming_exercises.lesson_18.src.exercise_1;

public enum MatrNr{
    INF(50),
    WINF(51),
    EC(61);

    final int prefix;

    MatrNr(int prefix){
        this.prefix = prefix;
    }
}
