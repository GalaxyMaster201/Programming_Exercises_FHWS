package de.fhws.programming_exercises.lesson_09.src.exercise2;

public class Pizza{
    private String name;
    private final int[] diameter;
    private final float[] price;

    /**
     * Constructor for the pizza
     *
     * @param name     name of the pizza
     * @param diameter an array of sizes
     * @param price    an array of prices
     */
    public Pizza(String name, int[] diameter, float[] price){
        this.name = name;
        this.diameter = diameter;
        this.price = price;
    }

    // Getter and Setter for the name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    // Getter and Setter for the diameter
    public int[] getDiameter(){
        return diameter;
    }

    public void setDiameter(int diameter, int index){
        this.diameter[index] = diameter;
    }

    // Getter and Setter for the price
    public float[] getPrice(){
        return price;
    }

    public void setPrice(float price, int index){
        this.price[index] = price;
    }
}
