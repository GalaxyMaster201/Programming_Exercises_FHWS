package de.fhws.programming_exercises.lesson_08.src;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int nrOfAttempts = 15;                  // maximum number of attempts
        String str = randomWord();      // the word which has to be guessed
        char[] wordToGuess = str.toCharArray();

        boolean finished = false;
        boolean failed = false;

        char[] guessArray = new char[wordToGuess.length];   // the array of guessed characters
        Arrays.fill(guessArray, '_');                   // filled with underscores at the beginning

        System.out.println("Hangman Game - Try to guess the word one letter at a time! You have 15 attempts");
        System.out.println(guessArray);
        // Loops user input
        for (int count = 0; true; count++){
            // check if the user has run out of attempts
            if (count == nrOfAttempts){
                failed = true;
                break;
            }

            System.out.print("\nAttempt Nr. "+(count+1)+": ");
            char input = scanner.nextLine().charAt(0);

            guessArray = checkGuess(wordToGuess, input, guessArray);

            // the user has guessed the word when the 2 arrays are equal
            if (Arrays.equals(guessArray, wordToGuess)){
                finished = true;
                break;
            }

            System.out.println(guessArray);
        }
        // OUTPUT
        if (finished){
            System.out.println(guessArray);
            System.out.println("\nCONGRATULATIONS! YOU'VE GUESSED THE WORD :D");
        } else if (failed){
            System.out.println("\nOH NO! YOU'VE RUN OUT OF ATTEMPTS :(");
        }
        scanner.close();
    }

    /**
     * Checks if the wordToGuess contains the input char and if true, adds it to the array of guessed values
     *
     * @param wordToGuess the word which has to be guessed
     * @param input       a character input from the user
     * @param guessArray  an Array of correct guesses
     * @return guessArray with possibly added values
     */
    public static char[] checkGuess(char[] wordToGuess, char input, char[] guessArray){
        for (int i = 0; i < wordToGuess.length; i++){
            if (guessArray[i] != '_'){                              // value is already set, move to the next one
                continue;
            }
            if (Character.toUpperCase(input) == wordToGuess[i]){    // the input is in the wordToGuess
                guessArray[i] = wordToGuess[i];                     // add it to the array of guessed characters
            }

        }
        return guessArray;
    }

    /**
     * Selects a random Word from an Array of 20 words
     * @return  the word which has to be guessed
     */
    public static String randomWord(){
        String[] wordArray = {"PROGRAMMIERSPRACHE","KLASSE","METHODE","JAVA","COMPILER","SOFTWARE","KOMMENTAR","JAVADOC","BIBLIOTHEK","ECLIPSE",
                "HANGMAN","COMPUTER","INFORMATIK","KONSTRUKTOR","OOP","PIZZA","PRINTF","SCANNER","EXCEPTION","SCHLEIFE"};
        int index = (int) Math.round(Math.random()*20);
        return wordArray[index];
    }
}
