package de.fhws.programming_exercises.lesson_17.src.exercise_2;

import java.io.File;

public class Main{
    public static void main(String[] args){
        File originFile = new File("src/main/java/de/fhws/programming_exercises/lesson_17/exercise_2/from.txt");
        File destinationFile = new File("src/main/java/de/fhws/programming_exercises/lesson_17/exercise_2/to.txt");

        System.out.println("Copying files...");
        FileCopier.copyFile(originFile, destinationFile);
        System.out.println("Success");
    }


}
