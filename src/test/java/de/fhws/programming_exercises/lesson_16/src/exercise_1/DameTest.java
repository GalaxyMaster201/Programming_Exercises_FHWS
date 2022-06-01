package de.fhws.programming_exercises.lesson_16.src.exercise_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class DameTest{
    Dame dame = new Dame(4, 5);
    int x = dame.getX();
    int y = dame.getY();
    Brett erlaubteFelder = dame.gibErlaubteFelder();

    @Test
    void testDiagonal(){
        boolean[][] sollArray = {
                // 1      2      3      4      5      6      7      8
                {false, false, false, true, false, false, false, true},   //1
                {true, false, false, true, false, false, true, false},    //2
                {false, true, false, true, false, true, false, false},    //3
                {false, false, true, true, true, false, false, false},    //4
                {true, true, true, true, true, true, true, true},         //5
                {false, false, true, true, true, false, false, false},    //6
                {false, true, false, true, false, true, false, false},    //7
                {true, false, false, true, false, false, true, false}     //8
        };

        for (int i = 1; i <= 8; i++){
            for (int j = 1; j <= 8; j++){
                if (erlaubteFelder.gibFeld(j, i) != sollArray[i-1][j-1]){
                    String soll = sollArray[i-1][j-1] ? "true" : "false";
                    String ist = erlaubteFelder.gibFeld(j, i) ? "true" : "false";
                    fail(String.format("Feld %d/%d ist falsch gesetzt. \nSoll: %s \nIst: %s", i, j, soll, ist));
                }
            }
        }
    }

    @Test
    void testHorizontal(){
        for (int i = 1; i <= 8; i++){
            assertTrue(erlaubteFelder.gibFeld(i, y));
        }
    }

    @Test
    void testVertikal(){
        for (int i = 1; i <= 8; i++){
            assertTrue(erlaubteFelder.gibFeld(x, i));
        }
    }
}