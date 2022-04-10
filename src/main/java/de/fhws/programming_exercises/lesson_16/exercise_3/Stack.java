package de.fhws.programming_exercises.lesson_16.exercise_3;

import java.util.ArrayList;

public final class Stack{

    private final ArrayList<Integer> aList = new ArrayList<>();

    public int getSize(){
        return aList.size();
    }

    public void push(int number){
        aList.add(number);
    }

    public int pop(){
        int last = aList.size()-1;
        if (last < 0){
            throw new IndexOutOfBoundsException("Cannot pop from empty stack");
        }
        int var = aList.get(last);
        aList.remove(last);
        return var;
    }

    @Override
    public String toString(){
        return aList.toString();
    }

}
