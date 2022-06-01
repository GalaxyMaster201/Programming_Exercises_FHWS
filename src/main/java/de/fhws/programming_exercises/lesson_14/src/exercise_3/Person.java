package de.fhws.programming_exercises.lesson_14.src.exercise_3;

public class Person{
    private final String firstName;
    private final String lastName;
    private final String address;


    public Person(String firstName, String lastName, String street, String number, int PLZ, String place){
        if (firstName.charAt(0) < 'A' || firstName.charAt(0) > 'Z'){
            throw new RuntimeException("The first name must be capitalized");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(street, number, PLZ, place).getAddressString();
    }
}
