package de.fhws.programming_exercises.lesson_15.src.exercise_1;

public class Employee{
    protected String lastName;
    protected String firstName;
    protected String identifier;
    protected String dateOfBirth;
    protected int baseSalary;

    private double salaryFactor = 1;
    protected int totalSalary;


    public Employee(String lastName, String firstName, String identifier, String dateOfBirth, int baseSalary){
        this.lastName = lastName;
        this.firstName = firstName;
        this.identifier = identifier;
        this.dateOfBirth = dateOfBirth;
        this.baseSalary = baseSalary;
        calculateSalary();
    }

    public void calculateSalary(){
        this.totalSalary = (int) (this.baseSalary * this.salaryFactor);
    }

    public double getSalaryFactor(){
        return salaryFactor;
    }
    public void setSalaryFactor(double salaryFactor){
        this.salaryFactor = salaryFactor;
    }

    public int getTotalSalary(){
        return totalSalary;
    }
}
