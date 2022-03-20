package de.fhws.programming_exercises.lesson_13.src.exercise_2;

public class Checkerboard{
    private final boolean[][] board = new boolean[8][8];

    /**
     * Sets the rook on a specified position on the board
     * @param coordY row from the top
     * @param coordX column from the left
     */
    public void setRook(int coordY, int coordX){
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board[0].length; x++){
                if (y == coordY || x == coordX){
                    board[y][x] = true;
                }
            }
        }
    }

    @Override
    public String toString(){
        String output = "";
        for (int y = 0; y < board.length; y++){
            output += y+"| ";
            for (int x = 0; x < board[0].length; x++){
                if (board[y][x]){
                    output += "x  ";
                } else{
                    output += "o  ";
                }
            }
            output += "\n";
        }
        output += "   ";
        for (int i = 0; i < board[0].length; i++){
            output += "_  ";
        }
        output += "\n   ";
        for (int i = 0; i < board[0].length; i++){
            output += i+"  ";
        }
        output += "\n\n";
        return output;
    }
}
