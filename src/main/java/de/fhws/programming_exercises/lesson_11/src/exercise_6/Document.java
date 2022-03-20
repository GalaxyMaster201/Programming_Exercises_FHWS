package de.fhws.programming_exercises.lesson_11.src.exercise_6;

import java.util.Arrays;

public class Document{
    private char[][] document;
    private int maxWidth;

    /**
     * Initializes the Document with a specified text.
     *
     * @param text String array, each element represents a new row
     */
    public Document(String[] text){
        document = convertToChars(text);
    }

    public int getMaxWidth(){
        return maxWidth;
    }

    /**
     * Clears the document text and sets it to the parameter.
     *
     * @param text an array of Stings (text rows)
     */
    public void setDocument(String[] text){
        document = null;                    // clear the document
        document = convertToChars(text);    // set new text
    }

    /**
     * Converts a String array to a 2-dimensional Char array.
     * Each element of the String array represents a "row" in the Char array.
     *
     * @param text initial String array with text
     * @return the String array converted to a 2-dimensional Char array
     */
    private char[][] convertToChars(String[] text){

        char[][] charArray = new char[text.length][];

        for (int i = 0; i < text.length; i++){
            charArray[i] = text[i].toCharArray();   // convert the String array to a 2D Char array

            if (charArray[i].length > maxWidth){    // find new maxWidth
                maxWidth = charArray[i].length;
            }
        }
        return charArray;
    }

    /**
     * Counts all characters in the text. Whitespaces are excluded from the count.
     *
     * @return number of characters in the text
     */
    public int countCharacters(){
        int counter = 0;

        for (char[] row : document){    // go through the rows

            if (row == null || row.length == 0){            // skip empty row
                continue;
            }

            for (char character : row){
                if (character != ' ' && character != 0){    // count non-whitespace characters
                    counter++;
                }
            }

        }
        return counter;
    }

    /**
     * Switches 2 rows in the document.
     *
     * @param row1 first row to switch
     * @param row2 second row to switch
     * @return false if either row is not in document, true if switch successful
     */
    public boolean switchRows(int row1, int row2){
        if ((row1 < 0 || row1 >= document.length) || (row2 < 0 || row2 >= document.length)){
            return false;                       // row not in document
        }

        char[] tempRow = document[row1];
        document[row1] = document[row2];        // switch rows
        document[row2] = tempRow;

        return true;
    }

    /**
     * Inserts new text into the document at a specified row.
     *
     * @param newText  new text to add to the document
     * @param afterRow row after which the text should be added
     */
    public void insertDocument(String[] newText, int afterRow){
        afterRow++;
        if (afterRow < 0 || afterRow > document.length){
            throw new RuntimeException("Invalid position");
        }

        expandAndMove(afterRow, newText.length);

        insertRows(convertToChars(newText), afterRow);
    }

    /**
     * Expands the initial document and makes space for the new text.
     *
     * @param position      starting row for the new text
     * @param newTextLength length of the text which should be added
     */
    private void expandAndMove(int position, int newTextLength){
        int lastRow = document.length-1;                // last row before expansion
        document = Arrays.copyOf(document, document.length+newTextLength); // expand the array
        for (int i = lastRow; i >= position; i--){
            document[i+newTextLength] = document[i];    // move the rows
        }
    }

    /**
     * Inserts the individual rows of the new text into the document
     *
     * @param newText  the text which should be added
     * @param position the starting row for the text
     */
    private void insertRows(char[][] newText, int position){
        for (int i = 0; i < newText.length; i++){
            document[position+i] = newText[i];
        }
    }

    /**
     * Prints the document to the terminal
     */
    public void print(){
        for (char[] row : document){
            System.out.println(row);
        }
    }
}
