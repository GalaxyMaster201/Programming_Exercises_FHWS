package de.fhws.programming_exercises.lesson_15.src.exercise_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest{
    @Test
    void testSubject(){
        Student s = new Student("Computer science");
        assertEquals("Computer science",s.getSubject());
    }
}