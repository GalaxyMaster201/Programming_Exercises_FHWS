package de.fhws.programming_exercises.lesson_12.src.exercise_2;

public class Person{
    private final String name;
    private final int age;

    Person next;
    Person previous;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}
