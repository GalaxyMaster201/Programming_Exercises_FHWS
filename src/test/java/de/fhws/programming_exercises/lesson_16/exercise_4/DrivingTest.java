package de.fhws.programming_exercises.lesson_16.exercise_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrivingTest{
    Human human = new Human();
    Robot robot = new Robot();
    Cyborg cyborg = new Cyborg();

    @Test
    void testLeftRobo(){
        CarDanger danger = CarDanger.DANGER_LEFT;
        assertEquals(CarDangerReaction.GO_RIGHT, robot.choose(danger));
    }

    @Test
    void testHumanRandomness(){
        int undecidedTotal = getUndecided(human);
        assertEquals(0.25, undecidedTotal / 3000d, 0.02);
        System.out.printf("Human \nActual: %.4f \nExpected: %f \n\n", undecidedTotal / 3000d, 0.25);
    }

    @Test
    void testCyborgRandomness(){
        int undecidedTotal = getUndecided(cyborg);
        assertEquals(0.125, undecidedTotal / 3000d, 0.01);
        System.out.printf("Cyborg \nActual: %.4f \nExpected: %f \n\n", undecidedTotal / 3000d,0.125);
    }

    private int getUndecided(AbstractBeing being){
        int total = 0;
        CarDanger[] dangers = CarDanger.values();
        for (CarDanger danger: dangers){
            for (int i = 0; i < 1000; i++){
                total += (being.choose(danger) == CarDangerReaction.UNDECIDED) ? 1 : 0;
            }
        }
        return total;
    }


}