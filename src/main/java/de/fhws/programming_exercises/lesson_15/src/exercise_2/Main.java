package de.fhws.programming_exercises.lesson_15.src.exercise_2;

public class Main{
    public static void main(String[] args){
        Person[] people = new Person[100];

        for (int i = 0; i < 100; i++){
            if (i % 2 != 0){
                people[i] = new Professor("Computer science");
            }else {
                people[i] = new Student("Computer science");
            }
        }
        for (int i = 0; i < 100; i++){
            people[i].printTask();
        }
    }
}
