package de.fhws.programming_exercises.lesson_18.src.exercise_2;

import java.util.Arrays;

public class Hangman{
    private final char[] wordToGuess;
    private final char[] guessList;
    private final String[] wordList = {"audience", "way", "relation", "assistant", "ratio", "variety", "cheek", "studio", "proposal", "mud"};
    public boolean finished;


    public Hangman(String wordToGuess){
        this.wordToGuess = wordToGuess.toUpperCase().toCharArray();
        this.guessList = new char[wordToGuess.length()];
        this.finished = false;
        Arrays.fill(guessList, '_');
    }

    public Hangman(){
        String wordToGuess = wordList[(int) (Math.random() * 10)];
        this.wordToGuess = wordToGuess.toUpperCase().toCharArray();
        this.guessList = new char[wordToGuess.length()];
        this.finished = false;
        Arrays.fill(guessList, '_');
    }

    public static void main(String[] args){
        Hangman hangman = new Hangman("Test");

        System.out.println(hangman.guess('t'));
    }

    public String guess(char guess){
        guess = Character.toUpperCase(guess);
        for (int i = 0; i < wordToGuess.length; i++){
            if (wordToGuess[i] == guess){
                guessList[i] = guess;
            }
        }
        finished = (wordToGuess == guessList);
        return getGuess();
    }

    public String getGuess(){
        return String.valueOf(guessList);
    }
}
