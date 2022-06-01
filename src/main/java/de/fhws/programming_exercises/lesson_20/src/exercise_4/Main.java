package de.fhws.programming_exercises.lesson_20.src.exercise_4;

import java.io.File;

public class Main{
    public static void main(String[] args){
        File textContacts = new File("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_20/src/exercise_4/text_contacts.txt");
        File numberContacts = new File("C:/Users/mcaba/OneDrive/FHWS/Programmieren_Maven/src/main/java/de/fhws/programming_exercises/lesson_20/src/exercise_4/number_contacts.txt");

        TextToNumberConverter ttnc = new TextToNumberConverter(textContacts, numberContacts);
        ttnc.convertFile();
    }
}
