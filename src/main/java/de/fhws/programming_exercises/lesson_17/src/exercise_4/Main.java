package de.fhws.programming_exercises.lesson_17.src.exercise_4;

import de.fhws.programming_exercises.lesson_17.src.exercise_3.Timer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main{

    public static void main(String[] args){
        Timer timer = new Timer();
        try (FileInputStream fis = new FileInputStream("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_17/src/exercise_4/input_document.txt");
             FileOutputStream fos1 = new FileOutputStream("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_17/src/exercise_4/output_document_1.txt");
             FileOutputStream fos2 = new FileOutputStream("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_17/src/exercise_4/output_document_2.txt");
             OutputStreamDoubler osd = new OutputStreamDoubler(fos1, fos2)
        ){
            int b;
            timer.start();
            while (true){
                b = fis.read();
                if (b == -1) break;
                osd.write(b);
            }
            System.out.printf("Doubler finished successfully in %d ms\n", timer.end());
        }catch (IOException ioException){
            System.out.println("Stream Doubler has failed :(");
        }
    }
}
