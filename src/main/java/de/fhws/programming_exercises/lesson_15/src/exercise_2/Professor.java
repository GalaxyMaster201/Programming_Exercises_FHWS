package de.fhws.programming_exercises.lesson_15.src.exercise_2;

public class Professor extends Person{
    private final String subject;

    public Professor(String subject){
        this.subject = subject;
    }

    @Override
    public void printTask(){
        System.out.println("The professor teaches "+subject);
    }

    public String getSubject(){
        return subject;
    }
}
