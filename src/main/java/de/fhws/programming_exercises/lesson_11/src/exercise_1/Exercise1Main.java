package de.fhws.programming_exercises.lesson_11.src.exercise_1;

import java.util.Arrays;

public class Exercise1Main{
    public static void main(String[] args){
        double[][] array1 =  {{1,5,15,3,85,65}, {6,98,74,35,21,15}};
        double[][] array2 = {{6.3,6.7,8.9,5.1},{12.6,8.2,6.4},{9.2},{15,16,54,2}};

        System.out.println(Arrays.toString(rowMax(array1)));
        System.out.println(Arrays.toString(rowMax(array2)));

    }

    /**
     * Finds the largest double number in every row.
     * @param startArr the starting array
     * @return an array of the largest numbers
     */
    public static double[] rowMax(double[][] startArr){
        double[] maxArr = new double[startArr.length];
        double maxNumber;

        for (int i = 0; i < startArr.length; i++){
            maxNumber = startArr[i][0];             // set maxNumber for the row

            for (int j = 1; j < startArr[i].length; j++){
                if (startArr[i][j] > maxNumber){    // check if there is a greater number
                    maxNumber = startArr[i][j];
                }
            }
            maxArr[i] = maxNumber;
        }

        return maxArr;
    }
}