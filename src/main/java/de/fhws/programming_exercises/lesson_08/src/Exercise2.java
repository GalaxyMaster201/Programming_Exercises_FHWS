package de.fhws.programming_exercises.lesson_08.src;

public class Exercise2{
    public static void main(String[] args){
        if (args.length != 2){  // if the user enters less or more than 2 numbers, terminate the program with error message
            System.out.println( "ERROR: Your input is invalid, please try again.");
        }else{  // turn input to integers and output their product
            System.out.println(Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
        }
    }
}
