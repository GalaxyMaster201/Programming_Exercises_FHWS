package de.fhws.programming_exercises.lesson_16.exercise_2;

import java.util.Arrays;

public class BetterChangeCalculator implements ChangeCalculator{

    @Override
    public int[] getChange(int euros, int cent){
        int change = 100 * euros+cent;

        int[] changeArray = new int[8];
        Coin[] coins = Coin.values();

        for (int i = 7; i >= 0; i--){
            changeArray[i] = change/coins[i].value;
            change %= coins[i].value;
        }
        return changeArray;
    }
}
