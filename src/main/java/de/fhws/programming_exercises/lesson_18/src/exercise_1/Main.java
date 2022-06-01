package de.fhws.programming_exercises.lesson_18.src.exercise_1;

import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    static File matrNrFile = new File("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_18/src/MatrNrs.txt");

    public static void main(String[] args){
        makeRandomList();
        MatrNrFilter mnf = new MatrNrFilter(matrNrFile);
        try{
            mnf.splitCourses();
            System.out.println("Courses split successfully!");
        }catch (FileNotFoundException fnfe){
            System.out.println("File not found!");
        }
    }

    private static void makeRandomList(){
        RandomMatNrGenerator rmng = new RandomMatNrGenerator(30);
        rmng.generateToFile(matrNrFile);
    }

}
