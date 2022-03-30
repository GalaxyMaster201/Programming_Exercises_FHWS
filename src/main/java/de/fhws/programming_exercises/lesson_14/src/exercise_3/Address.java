package de.fhws.programming_exercises.lesson_14.src.exercise_3;

public class Address{
    private final String street;
    private final String number;
    private final int PLZ;
    private final String place;


    public Address(String street, String number, int PLZ, String place){
        checkInput(street, number, place);

        this.street = street;
        this.number = number;
        this.PLZ = PLZ;
        this.place = place;
    }

    private void checkInput(String street, String number, String place){
        if (!startsCap(street)){
            throw new RuntimeException("The street name must be capitalized");
        }
        if (number.charAt(0) <'0' || number.charAt(0) > '9'){
            throw new RuntimeException("The street number must start with a digit");
        }
        if (!startsCap(place)){
            throw new RuntimeException("The place name must be capitalized");
        }
    }

    public String getAddressString(){
        return street + number + PLZ + place;
    }

    private boolean startsCap(String str){
        return str.charAt(0) >= 'A' && str.charAt(0) <= 'Z';
    }
}
