package de.fhws.programming_exercises.lesson_15.src.exercise_3;

public class MultipleChoiceQuestion extends Question{

    String[] answers;

    public MultipleChoiceQuestion(String questionText, String[] answers){
        super(questionText);
        this.answers = answers;
    }


    /**
     * Creates a list of all possible answers for the given question.
     *
     * @return answer String block
     */
    @Override
    protected String inputField(){
        StringBuilder output = new StringBuilder();

        for (int i = 0, c = 'A'; i < answers.length; i++, c++){
            output.append((char)c).append(": ");      // add letters to different answers
            output.append(answers[i]).append("\n");
        }

        return output.toString();
    }
}
