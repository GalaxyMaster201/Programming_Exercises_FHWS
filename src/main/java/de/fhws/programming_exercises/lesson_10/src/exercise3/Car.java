package de.fhws.programming_exercises.lesson_10.src.exercise3;

public class Car{
    String brand;
    String name;
    String model;
    int displacement;
    String colour;
    int horsepower;
    String transmission;
    boolean convertible;
    private static int zaehler = 0;

    /**
     * Constructor for the car class
     *
     * @param b    car brand
     * @param nme  car name
     * @param mod  car model
     * @param disp engine displacement in ccm
     * @param col  car colour
     * @param hp   engine horsepower
     * @param tran transmission type
     * @param conv is the car a convertible?
     */
    public Car(String b, String nme, String mod, int disp, String col, int hp, String tran, boolean conv){
        brand = b;
        name = nme;
        model = mod;
        if (disp > 0){
            displacement = disp;
        } else{
            displacement = 1600;
        }
        colour = col;
        horsepower = hp;
        transmission = tran;
        convertible = conv;
        zaehler++;
    }

    /**
     * A method to set the engine displacement
     *
     * @param ccm new displacement to attribute
     */
    public void setDisplacement(int ccm){
        if (ccm > 0){
            this.displacement = ccm;
        }
    }
}
