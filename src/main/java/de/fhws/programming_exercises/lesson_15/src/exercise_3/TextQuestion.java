package de.fhws.programming_exercises.lesson_15.src.exercise_3;

public class TextQuestion extends Question{

    public TextQuestion(String questionText){
        super(questionText);
    }


    /**
     * Creates the input field for text input with 2 lines
     * @return text input field String
     */
    @Override
    protected String inputField(){
        String output = "Answer: \n";

        output += "_".repeat(100) + "\n";
        output += "_".repeat(100);

        return output;
    }

}
