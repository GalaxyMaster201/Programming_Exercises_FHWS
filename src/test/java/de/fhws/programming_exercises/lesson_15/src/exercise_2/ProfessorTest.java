package de.fhws.programming_exercises.lesson_15.src.exercise_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest{

    @Test
    void testSubject(){
        Professor p = new Professor("Computer science");
        assertEquals("Computer science",p.getSubject());
    }
}