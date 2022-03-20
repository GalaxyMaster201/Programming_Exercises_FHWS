package de.fhws.programming_exercises.lesson_08.src.Exercise5;

public class Exercise5Main{
    public static void main(String[] args){
        Car[] carArray = defineAttributes();
        int highest = 0;
        // find car with the largest displacement
        for (int i = 0; i < 2; i++){
            if (carArray[i].displacement < carArray[i+1].displacement){
                highest = i+1;
            }
        }

        // OUTPUT
        System.out.printf("The car with the biggest displacement is the %s %s %s %n",
                carArray[highest].brand, carArray[highest].name, carArray[highest].model);

        System.out.printf("with %.1f litres and %d horsepower %n",
                carArray[highest].displacement, carArray[highest].horsepower);
    }

    /**
     * Defines the attributes for each of the cars
     * This whole part could be done without car1, car2 and car3 variables,
     * but I found it easier to understand this way
     *
     * @return Array of cars with attributes
     */
    public static Car[] defineAttributes(){
        Car[] carray = new Car[3];

        Car car1 = new Car();
        car1.brand = "Mazda";
        car1.name = "MX-5";
        car1.model = "NA";
        car1.displacement = 1.9f;
        car1.colour = "Red";
        car1.convertible = true;
        car1.transmission = "5-speed manual";
        car1.horsepower = 130;
        carray[0] = car1;

        Car car2 = new Car();
        car2.brand = "Nissan";
        car2.name = "GTR";
        car2.model = "Nismo";
        car2.displacement = 3.8f;
        car2.colour = "White";
        car2.convertible = false;
        car2.transmission = "6-speed DCT";
        car2.horsepower = 608;
        carray[1] = car2;

        Car car3 = new Car();
        car3.brand = "Mercedes Benz";
        car3.name = "B-Klasse";
        car3.model = "B180";
        car3.displacement = 1.7f;
        car3.colour = "Gray";
        car3.convertible = false;
        car3.transmission = "CVT";
        car3.horsepower = 110;
        carray[2] = car3;

        return carray;
    }
}
// Comparing a supercar to a family hatchback and a Miata is kinda useless,
// but those were the first 3 cars that came to my mind