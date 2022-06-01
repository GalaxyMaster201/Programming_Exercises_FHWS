package de.fhws.programming_exercises.lesson_19.src.exercise_1;

import java.util.Arrays;

public class ObjectHangman{
    private final char[] wordToGuess;
    private final char[] guessList;
    private final String[] wordList = {"AUDIENCE", "WAY", "RELATION", "ASSISTANT", "RATIO", "VARIETY", "CHEEK", "STUDIO", "PROPOSAL", "MUD"};
    public boolean finished;


    public ObjectHangman(String wordToGuess){
        this.wordToGuess = wordToGuess.toUpperCase().toCharArray();
        this.guessList = new char[wordToGuess.length()];
        this.finished = false;
        Arrays.fill(guessList, '_');
    }

    public ObjectHangman(){
        String wordToGuess = wordList[(int) (Math.random() * 10)];
        this.wordToGuess = wordToGuess.toUpperCase().toCharArray();
        this.guessList = new char[wordToGuess.length()];
        this.finished = false;
        Arrays.fill(guessList, '_');
    }

    public static void main(String[] args){
        ObjectHangman objectHangman = new ObjectHangman("Test");

        System.out.println(objectHangman.guess('t'));
    }

    public Answer guess(char guess){
        guess = Character.toUpperCase(guess);
        boolean guessed = false;
        for (int i = 0; i < wordToGuess.length; i++){
            if (wordToGuess[i] == guess){
                guessList[i] = guess;
                guessed = true;
            }
        }
        finished = (Arrays.equals(wordToGuess, guessList));
        return new Answer(getGuess(), guessed, finished);
    }

    public String getGuess(){
        return String.valueOf(guessList);
    }
}
