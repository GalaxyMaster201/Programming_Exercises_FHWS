package de.fhws.programming_exercises.lesson_16.src.exercise_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StackTest{
    Stack stack = new Stack();

    @Test
    void testPush(){
        for (int i = 0; i <= 1000; i++){
            stack.push(i);
        }
        System.out.println("Successfully pushed to 1000");
    }

    @Test
    void testPop(){
        stack.push(123);
        assertEquals(123, stack.pop());
        System.out.println("Successfully popped last");
    }

    @Test
    void testEmptyPop(){
        try{
            while (stack.getSize() >= 0){
                stack.pop();
            }
        } catch (IndexOutOfBoundsException ioobE){
            if (stack.getSize() > 0){
                fail("Exception before empty");
            }else{
                System.out.println("Successfully failed");
                assertEquals("Cannot pop from empty stack", ioobE.getMessage());
            }
        }
    }
}