package de.fhws.programming_exercises.lesson_17.src.exercise_1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ExceptionThrowerTest{
    ExceptionThrower eT = new ExceptionThrower();

    @Test
    void testThrowNumberFormat(){
        try{
            eT.throwNumberFormat();
            fail("Expected NumberFormatException");
        }catch (NumberFormatException nfe){
            System.out.println(nfe.getMessage());
            assertTrue(true);
        }
    }

    @Test
    void testThrowArrayIndexOutOfBounds(){
        try{
            eT.throwArrayIndexOutOfBounds();
            fail("Expected ArrayIndexOutOfBoundsException");
        }catch (ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe.getMessage());
            assertTrue(true);
        }
    }

    @Test
    void testThrowNullPointer(){
        try{
            eT.throwNullPointer();
            fail("Expected throwNullPointer");
        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
            assertTrue(true);
        }
    }

    @Test
    void testThrowOutOfMemory(){
        try{
            eT.throwOutOfMemory();
            fail("Expected OutOfMemoryError");
        }catch (OutOfMemoryError oome){
            System.out.println(oome.getMessage());
            assertTrue(true);
        }
    }

    @Test
    void testThrowArithmetic(){
        try{
            eT.throwArithmetic();
            fail("Expected ArithmeticException");
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
            assertTrue(true);
        }
    }

    @Test
    void testThrowFileNotFound(){
        try{
            eT.throwFileNotFound();
            fail("Expected FileNotFoundException");
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
            assertTrue(true);
        }
    }
}