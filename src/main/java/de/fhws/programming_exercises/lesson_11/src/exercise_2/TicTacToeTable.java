package de.fhws.programming_exercises.lesson_11.src.exercise_2;

public class TicTacToeTable{
    private int numX = 0;
    private int numO = 0;

    private final boolean[][][] tttTable = new boolean[3][3][3];

    public TicTacToeTable(){
        fillRandomly();
    }

    public char[][][] getTable(){
        return convertTable();
    }

    public int getNumX(){
        return numX;
    }

    public int getNumO(){
        return numO;
    }

    private void fillRandomly(){
        double limit = 0.5;         // limit starting point

        for (int i = 0; i < 3; i++){            // cycle layers
            for (int j = 0; j < 3; j++){        // cycle rows
                for (int k = 0; k < 3; k++){    // cycle elements

                    // this part tries to make the number
                    // of true and false values somewhat equal
                    if ((numX-numO) > 2 && limit < 0.7){        // increase the limit
                        limit+= 0.1;
                    }else if ((numO-numX) > 2 && limit > 0.3){  // decrease the limit
                        limit-= 0.1;
                    }

                    if(Math.random() >= limit){
                        tttTable[i][j][k] = true;
                        numX++;
                    }else{
                        tttTable[i][j][k] = false;
                        numO++;
                    }
                }
            }
        }
    }

    /**
     * Converts the array from boolean values to true = 'X' and false = 'O'
     * @return the converted array
     */
    private char[][][] convertTable(){
        char[][][] convertedTable = new char[3][3][3];

        for (int i = 0; i < 3; i++){            // cycle layers
            for (int j = 0; j < 3; j++){        // cycle rows
                for (int k = 0; k < 3; k++){    // cycle elements
                    if (tttTable[i][j][k]){
                        convertedTable[i][j][k] = 'X';  // val = true
                    }else {
                        convertedTable[i][j][k] = 'O';  // val = false
                    }
                }
            }
        }
        return convertedTable;
    }
}
