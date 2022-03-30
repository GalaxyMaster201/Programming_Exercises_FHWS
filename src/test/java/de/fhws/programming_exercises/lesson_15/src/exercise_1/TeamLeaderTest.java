package de.fhws.programming_exercises.lesson_15.src.exercise_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamLeaderTest{
    TeamLeader tl = new TeamLeader("Mustermann","Max","I2JK","13.01.2021",1500);

    @Test
    void testSalary(){
        assertEquals(3000, tl.getTotalSalary());
    }

    @Test
    void testPromotionSf(){
        Employee emp = new Employee("Mustermann","Max","I2JK","13.01.2021",1500);
        tl.promote(emp);

        assertEquals(1.1, emp.getSalaryFactor());
    }

    @Test
    void testPromotionSalary(){
        Employee emp = new Employee("Mustermann","Max","I2JK","13.01.2021",1500);
        tl.promote(emp);

        assertEquals(1650, emp.getTotalSalary());
    }
}