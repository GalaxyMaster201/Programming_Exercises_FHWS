package de.fhws.programming_exercises.lesson_14.src.exercise_3;

import de.fhws.programming_exercises.lesson_14.src.exercise_3.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest{
    @Test
    public void testSuccessful(){
        try{
            Person p = new Person("Max","Mustermann","Musterstraße","12a",12345,"Musterstadt");
        }catch (RuntimeException e){
            fail("Unexpected Runtime Exception");
        }
    }
    @Test
    public void testFirstNameLower(){
        try{
            Person p = new Person("max","Mustermann","Musterstraße","12a",12345,"Musterstadt");
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("The first name must be capitalized",e.getMessage());
        }
    }
    @Test
    public void testStreetNameLower(){
        try{
            Person p = new Person("Max","Mustermann","musterstraße","12a",12345,"Musterstadt");
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("The street name must be capitalized",e.getMessage());
        }
    }
    @Test
    public void testPlaceNameLower(){
        try{
            Person p = new Person("Max","Mustermann","Musterstraße","12a",12345,"musterstadt");
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("The place name must be capitalized",e.getMessage());
        }
    }
    @Test
    public void testStreetNumberNonDigit(){
        try{
            Person p = new Person("Max","Mustermann","Musterstraße","a12",12345,"Musterstadt");
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("The street number must start with a digit",e.getMessage());
        }
    }
}