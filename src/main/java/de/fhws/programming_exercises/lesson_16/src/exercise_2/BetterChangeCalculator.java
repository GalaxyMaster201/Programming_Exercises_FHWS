package de.fhws.programming_exercises.lesson_16.src.exercise_2;

public class BetterChangeCalculator implements ChangeCalculator{

    /**
     * Calculates the least amount of coins which should be returned.
     * @param euros Euro part of change
     * @param cent Cent part of change
     * @return int[8]-Array of values corresponding to the number coins to return [1Ct,2Ct,5Ct,10Ct,20Ct,50Ct,1€,2€]
     */
    @Override
    public int[] getChange(int euros, int cent){
        int change = 100 * euros+cent;

        int[] changeArray = new int[8];
        Coin[] coins = Coin.values();

        // Uses Integer-Division and Modulo to get the number of coins to return
        for (int i = 7; i >= 0; i--){
            changeArray[i] = change/coins[i].value;
            change %= coins[i].value;
        }
        return changeArray;
    }
}
