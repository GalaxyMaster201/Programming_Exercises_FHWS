package de.fhws.programming_exercises.lesson_16.exercise_4;

public class Cyborg extends AbstractBeing
        implements Driving{

    Human humanPart = new Human();
    Robot robotPart = new Robot();

    @Override
    public CarDangerReaction choose(CarDanger danger){
        CarDangerReaction humanChoice = humanPart.choose(danger);
        CarDangerReaction robotChoice = robotPart.choose(danger);
        if (humanChoice == robotChoice){
            return humanChoice;
        }else {
            return Math.random() > 0.5 ? humanChoice:robotChoice;
        }
    }
}
