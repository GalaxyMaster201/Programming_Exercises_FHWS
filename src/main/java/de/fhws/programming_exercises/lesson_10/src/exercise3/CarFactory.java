package de.fhws.programming_exercises.lesson_10.src.exercise3;

import java.util.Arrays;

public class CarFactory{
    private int productionCounter;
    private Car[] cars = new Car[0];

    public int getProductionCounter(){
        return productionCounter;
    }

    public Car[] getCars(){
        return cars;
    }

    public void produceCar(
            String brand, String name, String model,
            int displacement, int hp, String transmission,
            String color, boolean convertible){
        Car car = new Car(brand, name, model, displacement, color, hp, transmission, convertible);
        cars = Arrays.copyOf(cars,cars.length+1);
        cars[productionCounter] = car;
        productionCounter++;
        System.out.printf("A %s %s %s %s with a %d ccm engine producing %d HP with a %s transmission has been produced. %n",
                color, brand, name, model, displacement, hp, transmission);
        System.out.printf("Production counter: %d %n%n",productionCounter);
    }
}
