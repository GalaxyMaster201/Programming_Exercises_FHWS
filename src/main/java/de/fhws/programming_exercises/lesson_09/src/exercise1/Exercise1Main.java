package de.fhws.programming_exercises.lesson_09.src.exercise1;

public class Exercise1Main{
    public static void main(String[] args){
        Car[] carArray = defineAttributes();
        int highest = 0;
        // find car with the largest displacement
        for (int i = 0; i < 2; i++){
            if (carArray[i].displacement < carArray[i+1].displacement){
                highest = i+1;
            }
        }

        carArray[1].setDisplacement(4000);
        // OUTPUT
        System.out.printf("The car with the largest displacement is the %s %s %s ",
                carArray[highest].brand, carArray[highest].name, carArray[highest].model);

        System.out.printf("with %d ccm and %d horsepower %n",
                carArray[highest].displacement, carArray[highest].horsepower);
    }

    /**
     * Defines the attributes for each of the cars with their constructor.
     *
     * @return Array of cars with attributes
     */
    public static Car[] defineAttributes(){
        Car[] carray = new Car[3];

        carray[0] = new Car("Mazda","MX-5","NA",1900,"Red",130,"5-speed manual",true);

        carray[1] = new Car("Nissan", "GTR","Nismo",3800,"White",608,"6-speed DCT",false);

        carray[2] = new Car("Mercedes Benz","B-Klasse","B180",1700,"Gray",110,"CVT",false);

        return carray;
    }
}