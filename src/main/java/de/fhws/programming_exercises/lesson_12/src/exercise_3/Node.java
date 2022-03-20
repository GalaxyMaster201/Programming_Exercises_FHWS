package de.fhws.programming_exercises.lesson_12.src.exercise_3;

public class Node{
    private final String word;
    private final String definition;

    public Node left;
    public Node right;

    public Node(String word, String definition){
        this.word = word;
        this.definition = definition;
    }

    public String getWord(){
        return word;
    }

    public String getDefinition(){
        return definition;
    }
}
