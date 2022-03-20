package de.fhws.programming_exercises.lesson_11.src.exercise_2;

// 3x3 TTT
public class Exercise2Main{
    public static void main(String[] args){
        TicTacToeTable table = new TicTacToeTable();
        char[][][] tttArray = table.getTable();

        printBox(tttArray);
        System.out.println("Number of X's: "+table.getNumX());
        System.out.println("Number of O's: "+table.getNumO());
    }

    /** Outputs all 3 layers of the 3x3x3 box ❒
     *
     * @param box a 3x3x3 array
     */
    public static void printBox(char[][][] box){
        for (int layer = 0; layer < 3; layer++){
            System.out.println(" \tLayer "+(layer+1)+":");
            printLayer(box[layer]);
            System.out.println();
        }

    }

    /**
     * Prints one layer of the box □
     * @param layer an array with 3 rows
     */
    private static void printLayer(char[][] layer){
        for (int row = 0; row < 3; row++){
            printRow(layer[row]);
            System.out.println();
        }
    }


    /**
     * Prints one row of a layer -
     * @param row an array of 3 Chars ( X and O )
     */
    private static void printRow(char[] row){
        for (int element = 0; element < 3; element++){
            System.out.printf(" %3c ",row[element]);
        }
    }
}


