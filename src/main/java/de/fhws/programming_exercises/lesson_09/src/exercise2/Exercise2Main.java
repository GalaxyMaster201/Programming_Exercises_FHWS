package de.fhws.programming_exercises.lesson_09.src.exercise2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------Menu-Creator 5000000-------------");   // header
        boolean doneWithMenu = false;
        Pizza[] pizzas = new Pizza[0];

        // let user input pizzas until he cancels it
        for (int i = 0; !doneWithMenu; i++){
            pizzas = Arrays.copyOf(pizzas, pizzas.length+1);        // create copy of the array and expand it
            pizzas[i] = addPizza(scanner);                                   // add a new pizza to the array
            doneWithMenu = isInputFinished("pizza", scanner);           // check if user is done with input
        }

        displayMenu(pizzas);    // display the menu
        scanner.close();
    }

    /**
     * Allows the user to add another pizza to the menu
     *
     * @param scanner Scanner pass-through
     * @return A pizza with one or several size-price combinations
     */
    private static Pizza addPizza(Scanner scanner){
        boolean doneWithCombos = false;
        String spacer = "----------------------------------------------";

        System.out.println(spacer);
        System.out.print("Enter the name of the pizza: ");
        String name = scanner.nextLine();
        int[] diameter = new int[0];    // an array of diameters
        float[] price = new float[0];   // an array of prices
        // ^indices reference the combination number

        // loops size-price input until the user cancels it to add different price
        for (int i = 0; !doneWithCombos; i++){
            System.out.println(spacer);
            System.out.println("Combination number "+(i+1));

            // user enters the diameter for the combination
            System.out.print("Enter the diameter of the pizza in cm: ");
            diameter = Arrays.copyOf(diameter, diameter.length+1);    // copy existing array and expand it by 1
            diameter[i] = Integer.parseInt(scanner.nextLine());                                    // add value to the expanded array

            // user enters the price for the combination
            System.out.print("Enter the price of the pizza in EUR: ");
            price = Arrays.copyOf(price, price.length+1);             // copy existing array and expand it by 1
            price[i] = Float.parseFloat(scanner.nextLine());                                     // add value to the expanded array

            doneWithCombos = isInputFinished("combination", scanner);       // check if the user is done with combination input
        }

        return new Pizza(name, diameter, price);
    }

    /**
     * Asks the user if they want to insert any more inputs
     *
     * @param item    a String which need to be inserted (here "pizza" or "combination")
     * @param scanner Scanner pass-through
     * @return a boolean value saying if the user is finished with the input or not
     */
    private static boolean isInputFinished(String item, Scanner scanner){
        while (true){   // true gets broken by the returns
            System.out.printf("Do you want to add another %s? Answer with Y or N.%n", item);
//            if (item.equals("combination")){    // a ghetto way of dealing with an input problem I had
//                scanner.nextLine();             // the program would jump to line 81 when entering combinations without it
//               }

            String input = scanner.nextLine();  // take user input

            if (input.equalsIgnoreCase("Y")){
                return false;       // the user wants to enter more pizzas/combinations = input not finished
            } else if (input.equalsIgnoreCase("N")){
                return true;        // the user doesn't want to enter any more pizzas/combinations = input finished
            } else{
                System.out.println("Your input is invalid, please try again."); // invalid input, loop again
            }
        }
    }

    /**
     * Prints the menu with pizza names and size-price combinations
     *
     * @param pizzas an array of Pizza objects with their names and size-price combinations
     */
    private static void displayMenu(Pizza[] pizzas){
        String spacer = "----------------------------------------------";

        System.out.println("Name:\n"+spacer+"\n  Diameter: \t\t Price: ");  // header

        for (int i = 0; i < pizzas.length; i++){                    // loop through the pizzas array
            System.out.println();
            System.out.println(pizzas[i].getName());                // print pizza name
            System.out.println(spacer);

            // get an array of sizes and corresponding prices for the pizza and save them in local variables.
            // could be done with multi/two-dimensional arrays, but I believe we didn't cover that yet.
            int[] diameters = pizzas[i].getDiameter();
            float[] prices = pizzas[i].getPrice();

            // print the size-price combinations with their index
            // (not sorted, because displaying the menu wasn't even required. Might do it at some later point)
            // TODO - SORT THE OUTPUT
            for (int j = 0; j < diameters.length; j++){
                System.out.printf("%d) %2d cm \t\t\t %3.2f EUR%n", j+1, diameters[j], prices[j]);
            }
        }
    }
}
