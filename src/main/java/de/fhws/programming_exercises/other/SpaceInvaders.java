package de.fhws.programming_exercises.other;

import java.util.Scanner;
import java.util.Arrays;

public class SpaceInvaders{

    private static char[] raumschiff = new char[15];

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int index = 2 * ((int) (Math.random()*8));
        printFeld(index);

        char input;

        while(true){
            input = scanner.nextLine().charAt(0);
            if (input == 'x'){
                break;
            }
            index = bewege(input, index);
            printFeld(index);
        }

        scanner.close();
    }

    private static int bewege(char input, int index){
        if(index >= 2 && input == 'a'){
            return index-2;
        }else if (index <= 12 && input == 'd'){
            return index+2;
        }
        return index;
    }

    private static void printFeld(int position){
        Arrays.fill(raumschiff,' ');
        raumschiff[position] = 'V';
        System.out.println("O O O O O O O O");
        System.out.println("               ");
        System.out.println("               ");
        System.out.println("               ");
        System.out.println(raumschiff);
    }
}
