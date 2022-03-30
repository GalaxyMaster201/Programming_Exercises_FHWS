package de.fhws.programming_exercises.lesson_15.src.exercise_1;

public class TeamLeader extends Employee{

    public TeamLeader(String firstName, String lastName, String identifier, String dateOfBirth, int baseSalary){
        super(firstName, lastName, identifier, dateOfBirth, baseSalary);
        super.setSalaryFactor(2);
        super.calculateSalary();
    }

    public void promote(Employee emp){
        double sf = emp.getSalaryFactor() * 1.1;
        emp.setSalaryFactor(sf);
        emp.calculateSalary();
    }
}
