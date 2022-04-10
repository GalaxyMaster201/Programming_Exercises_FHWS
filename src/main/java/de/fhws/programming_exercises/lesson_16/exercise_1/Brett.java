package de.fhws.programming_exercises.lesson_16.exercise_1;

public class Brett{
    boolean[][] brett = new boolean[8][8];

    public Brett(){

    }

    public void markiereFeld(int x, int y){
        brett[x-1][y-1] = true;
    }

    public boolean gibFeld(int x, int y){
        return brett[x-1][y-1];
    }

    public Brett kombiniere(Brett brett2){
        Brett komboBrett = this;
        for (int i = 1; i <= 8; i++){
            for (int j = 1; j <= 8; j++){
                if (brett2.gibFeld(i, j)){
                    komboBrett.markiereFeld(i, j);
                }
            }
        }
        return komboBrett;
    }
}
