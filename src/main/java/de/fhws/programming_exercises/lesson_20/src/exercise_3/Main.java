package de.fhws.programming_exercises.lesson_20.src.exercise_3;

public class Main{
    public static void main(String[] args){
        Multimap mm = new Multimap();
        mm.put("Phone", new String[]{"Handy", "Telefon"});
        System.out.println(mm.dictionary);
    }
}
