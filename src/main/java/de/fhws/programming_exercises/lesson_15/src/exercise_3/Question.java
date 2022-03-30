package de.fhws.programming_exercises.lesson_15.src.exercise_3;


public abstract class Question{
    protected String questionText;

    public Question(String questionText){
        this.questionText = questionText;
    }

    @Override
    public String toString(){
        String output = "";
        output += questionField();
        output += inputField();
        output += "\n\n";
        return output;
    }

    /**
     *
     * @return the question
     */
    protected String questionField(){

        if(!checkLastCharacter()){
            questionText = reformatQuestion();
        }
        return questionText + "\n";
    }

    /**
     * Checks if the last character is a '?' or a '.'
     * @return TRUE if last char '?' or '.'; FALSE otherwise
     */
    private boolean checkLastCharacter(){
        char lastElement;

        {   // Search for the last non-space character in the question text
            int index = questionText.length();
            do{
                index--;
                lastElement = questionText.charAt(index);
            } while (lastElement == ' ');
        }

        // Check if the last character is a '?' or a '.'
        return (lastElement == '?' || lastElement == '.' || lastElement == ':');
    }

    /**
     * Reformats the text to automatically add a '?' or a '.' . Absolutely overkill, but I had some extra time
     *
     * @return Reformatted text
     */
    protected String reformatQuestion(){

        String[] sentences = questionText.split("\\. ");          // could have written it as one expression,
        String lastSentence = sentences[sentences.length-1];            // decided against it due to readability
        String start = lastSentence.split(" ", 2)[0];

        // Check if the sentence starts with one of the question "markers"
        String[] sixWs = {"Who", "What", "Where", "When", "Why", "How", "Which"};
        for (String w : sixWs){
            if (w.equals(start)){
                return questionText + "?";
            }
        }
        return questionText + ":";
    }


    protected abstract String inputField();

}
