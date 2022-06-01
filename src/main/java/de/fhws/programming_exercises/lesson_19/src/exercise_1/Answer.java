package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.io.Serializable;

public class Answer implements Serializable{

    String guessList;               // list of guessed characters
    boolean guessed;                // correct previous guess
    boolean finished;               // correctly guessed the whole word

    public Answer(String guessList, boolean guessCorrect, boolean finished){
        this.guessList = guessList;
        this.guessed = guessCorrect;
        this.finished = finished;
    }

    @Override
    public String toString(){
        String str = "";

        str += "Current: " + guessList + "\n";
        str += "Last try: " + (guessed ? "guessed" : "not guessed") + "\n";
        str += "Finished: " + (finished ? "yes" : "no") + "\n";

        return str;
    }

}
