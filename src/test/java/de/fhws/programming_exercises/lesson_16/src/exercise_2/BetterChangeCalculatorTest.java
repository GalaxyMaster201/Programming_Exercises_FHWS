package de.fhws.programming_exercises.lesson_16.src.exercise_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterChangeCalculatorTest{

    BetterChangeCalculator bCalc = new BetterChangeCalculator();

    @Test
    void testChangeTotal1(){
        int euros = 5;
        int cents = 47;
        int total = 100 * euros+cents;

        assertEquals(total, calculateTotal(euros,cents));
    }
    @Test
    void testChangeTotal2(){
        int euros = 0;
        int cents = 15;
        int total = 100 * euros+cents;

        assertEquals(total, calculateTotal(euros,cents));
    }
    @Test
    void testChangeTotal3(){
        int euros = 3;
        int cents = 13;
        int total = 100 * euros+cents;

        assertEquals(total, calculateTotal(euros,cents));
    }

    @Test
    void testChangeAmount1(){
        int euros = 7;
        int cents = 32;
        int[] expected = {0,1,0,1,1,0,1,3};
        assertArrayEquals(expected,bCalc.getChange(euros, cents));
    }
    @Test
    void testChangeAmount2(){
        int euros = 0;
        int cents = 13;
        int[] expected = {1,1,0,1,0,0,0,0};
        assertArrayEquals(expected,bCalc.getChange(euros, cents));
    }
    @Test
    void testChangeAmount3(){
        int euros = 1;
        int cents = 29;
        int[] expected = {0,2,1,0,1,0,1,0};
        assertArrayEquals(expected,bCalc.getChange(euros, cents));
    }

    private int calculateTotal(int euros, int cents){
        int calculatedTotal = 0;
        int[] changeArr = bCalc.getChange(euros, cents);
        Coin[] coins = Coin.values();

        for (int i = 0; i < 8; i++){
            calculatedTotal += changeArr[i] * coins[i].value;
        }
        return calculatedTotal;
    }
}