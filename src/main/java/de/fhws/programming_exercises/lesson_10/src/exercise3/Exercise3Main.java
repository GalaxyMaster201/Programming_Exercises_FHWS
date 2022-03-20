package de.fhws.programming_exercises.lesson_10.src.exercise3;

public class Exercise3Main{
    public static void main(String[] args){
        CarFactory factory = new CarFactory();
        factory.produceCar("Ford","Focus","C519",2300,276,"7-Speed Automatic","Silver",false);
        factory.produceCar("Ford","Mustang","S550",4951,435,"6-Speed Manual","Black",false);
    }
}
