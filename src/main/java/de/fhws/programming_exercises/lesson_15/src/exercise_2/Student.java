package de.fhws.programming_exercises.lesson_15.src.exercise_2;

public class Student extends Person{
    private final String subject;

    public Student(String subject){
        this.subject = subject;
    }

    @Override
    public void printTask(){
        System.out.println("The student attends "+subject);
    }

    public String getSubject(){
        return subject;
    }
}
