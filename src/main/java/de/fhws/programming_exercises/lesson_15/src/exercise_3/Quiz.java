package de.fhws.programming_exercises.lesson_15.src.exercise_3;

public class Quiz{

    private static final Question[] questions = {
            new TextQuestion("Why are plants green?"),
            new MultipleChoiceQuestion("How many hours are there in a day?         ",
                    new String[] {"6","12","24"}),
            new TextQuestion("Why do things fall down and not up"),
            new TextQuestion("The light bulb is a genius invention. How would you go about changing one"),
            new MultipleChoiceQuestion("Which city is the capital of Australia",
                    new String[] {"Canberra","Melbourne","Sydney","London","Vienna","Queensland"}),
            new MultipleChoiceQuestion("Choose the grammatically correct statement",
                    new String[] {"We go sleep", "We is going to sleep", "We are going to sleep"}),
            new MultipleChoiceQuestion("What is the meaning of life, the universe and everything?",
                    new String[] {"42","How many roads must a man travel?","Why?"}),
            new TextQuestion("When will we stop testing?")
    };

    public static void main(String[] args){

        // print all the questions
        for (int i = 0; i < questions.length; i++){
            System.out.println((i+1+") ")+ questions[i]);
        }
    }
}
