package de.fhws.programming_exercises.lesson_16.src.exercise_4;

public class Cyborg extends AbstractBeing
        implements Driving{

    Human humanPart = new Human();
    Robot robotPart = new Robot();

    /**
     * The cyborg is presented with a danger and has to decide how to react. The cyborg has a human and a robot half.
     * If the two halves make different decisions, the cyborg randomly chooses one of them.
     * Approx. undecisiveness: 25% * 50% = 12.5%
     *
     * @param danger type of danger presented
     * @return cyborg's choice
     */
    @Override
    public CarDangerReaction choose(CarDanger danger){
        CarDangerReaction humanChoice = humanPart.choose(danger);
        CarDangerReaction robotChoice = robotPart.choose(danger);
        if (humanChoice == robotChoice){
            return humanChoice;
        }else{
            return (Math.random() > 0.5) ? humanChoice : robotChoice;
        }
    }
}
