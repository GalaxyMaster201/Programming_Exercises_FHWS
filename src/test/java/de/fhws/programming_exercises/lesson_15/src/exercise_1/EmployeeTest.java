package de.fhws.programming_exercises.lesson_15.src.exercise_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest{
    Employee emp;

    @Test
    void testSalary(){
        emp = new Employee("Mustermann","Max","I2JK","13.01.2021",1500);
        assertEquals(1500, emp.getTotalSalary());
    }



}