package de.fhws.programming_exercises.lesson_11.src.exercise_4;

import java.util.Arrays;

public class Ticker{
    private char[] buffer;

    /**
     * Initialize the ticker with a specific buffer size
     *
     * @param size size of the buffer
     */
    public Ticker(int size){
        if (size > 0){
            buffer = new char[size];
        } else{
            buffer = new char[200];
        }
        Arrays.fill(buffer,' ');
    }

    /**
     * If no size input, set to default
     */
    public Ticker(){
        buffer = new char[200];
    }

    public int getSize(){
        return buffer.length;
    }

    /**
     * Returns a copy of the ticker buffer
     *
     * @return
     */
    public char[] getBuffer(){
        return Arrays.copyOf(buffer, buffer.length);
    }

    /**
     * Resets the buffer by filling it with a specific symbol
     *
     * @param symbol the symbol to fill the buffer with
     */
    public void resetMessage(char symbol){
        Arrays.fill(buffer, symbol);
    }

    /**
     * Resets the buffer by filling it with +
     */
    public void resetMessage(){
        Arrays.fill(buffer, '+');
    }

    /**
     * Sets the buffer to a new message
     *
     * @param newMessage message to save in the ticker
     */
    public void setBuffer(char[] newMessage){

        buffer = Arrays.copyOf(newMessage, buffer.length);

        if (newMessage.length < buffer.length){                 // pad the message to the buffer size
            fillRest(newMessage.length,'+');
        }
    }

    /**
     * Fills the empty spaces in the array with a specified symbol
     *
     * @param symbol Symbol to fill the array with
     */
    private void fillRest(int messageLength, char symbol){
        Arrays.fill(buffer, messageLength, buffer.length, symbol);
    }

    /**
     * Cycles the array characters to the left.
     * @param distance distance to rotate the characters by
     */
    public void rotateMessage(int distance){

        if (distance <= 0 || distance >= buffer.length){        // test rotation conditions
            return;
        }

        char[] rotatedBuffer = new char[buffer.length];         // extra array to save rotation

        for (int i = 0; i < buffer.length; i++){

            int rotatedIndex;

            if (i < distance){
                rotatedIndex = buffer.length-(distance-i);      // cycle characters to the right side
            } else{
                rotatedIndex = i-distance;                      // move characters to the left
            }

            rotatedBuffer[rotatedIndex] = buffer[i];
        }

        buffer = rotatedBuffer;

    }

}


















