package de.fhws.programming_exercises.lesson_08.src;

import java.util.Objects;

public class Exercise3{
    public static void main(String[] args){
        boolean subtraction = Objects.equals(args[args.length-1], "-"); // check if user wants to subtract or add
        int res = 0;

        if (!subtraction){  // the user has entered a +
            for (int i = 0; i < args.length-1; i++){
                res += Integer.parseInt(args[i]);
            }
        } else{     // the user has entered a -
            res = Integer.parseInt(args[0]);    // subtraction from first number
            for (int i = 1; i < args.length-1; i++){
                res -= Integer.parseInt(args[i]);
            }
        }
        System.out.println(res);
    }
}
// this one sort of relies on the user doing what he's supposed to