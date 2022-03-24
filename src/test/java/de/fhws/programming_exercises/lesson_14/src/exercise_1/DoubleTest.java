package de.fhws.programming_exercises.lesson_14.src.exercise_1;

import org.junit.jupiter.api.Test;

import static de.fhws.programming_exercises.lesson_14.src.exercise_1.Kugelvolumen.berechneKugelvolumen;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleTest{

    @Test
    public void testZero(){
        assertEquals(0,berechneKugelvolumen(0));
    }
    @Test
    public void testOne(){
        assertEquals(4.1887902047863905,berechneKugelvolumen(1));
    }
    @Test
    public void testMinusOne(){
        // Negativer Radius sowie das negative Volumen existieren nicht!
        assertEquals(-4.1887902047863905,berechneKugelvolumen(-1));
    }
    @Test
    public void testFive(){
        assertEquals(523.5987755982989,berechneKugelvolumen(5));
    }

}
