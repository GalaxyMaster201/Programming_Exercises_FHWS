package de.fhws.programming_exercises.lesson_16.src.exercise_4;

public enum CarDangerReaction{
    /**
     * Contains all the possible reactions to a danger while driving and the sound one would make.
     */
    GO_LEFT("Going left!"),
    GO_RIGHT("Going right!"),
    BRAKE("Braking!"),
    UNDECIDED("AAAAAAAAAAAA!");

    final String reaction;

    CarDangerReaction(String reaction){
        this.reaction = reaction;
    }
}
