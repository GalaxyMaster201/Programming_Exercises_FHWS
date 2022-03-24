package de.fhws.programming_exercises.lesson_14.src.exercise_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyPointTest{
    MyPoint p = new MyPoint();

    @Test
    public void testSuccessful(){
        try{
            p.movePoint(1,1);
        }catch (RuntimeException e){
            fail("Unexpected Runtime Exception");
        }
    }

    @Test
    public void testXTooSmall(){
        try{
            p.movePoint(-1,1);
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("Invalid coordinates",e.getMessage());
        }
    }

    @Test
    public void testYTooSmall(){
        try{
            p.movePoint(1,-1);
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("Invalid coordinates",e.getMessage());
        }
    }

    @Test
    public void testXTooLarge(){
        try{
            p.movePoint(2000,1);
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("Invalid coordinates",e.getMessage());
        }
    }

    @Test
    public void testYTooLarge(){
        try{
            p.movePoint(1,2000);
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("Invalid coordinates",e.getMessage());
        }
    }
}
