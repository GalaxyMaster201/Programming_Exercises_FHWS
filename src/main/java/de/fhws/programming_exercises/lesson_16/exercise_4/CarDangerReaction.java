package de.fhws.programming_exercises.lesson_16.exercise_4;

public enum CarDangerReaction{
    GO_LEFT("Going left!"),
    GO_RIGHT("Going right!"),
    BRAKE("Braking!"),
    UNDECIDED("AAAAAAAAAAAA!");

    final String reaction;

    CarDangerReaction(String reaction){
        this.reaction = reaction;
    }
}
