package de.fhws.programming_exercises.lesson_16.exercise_4;

public class Robot extends AbstractBeing
        implements Driving{

    /**
     * Presents a robot with a danger and makes him decide which action to take.
     * The robot always makes the right decision
     *
     * @param danger type of danger presented
     * @return robot's reaction
     */
    @Override
    public CarDangerReaction choose(CarDanger danger){
        return switch (danger){
            case DANGER_LEFT -> CarDangerReaction.GO_RIGHT;
            case DANGER_RIGHT -> CarDangerReaction.GO_LEFT;
            case DANGER_FRONT -> CarDangerReaction.BRAKE;
        };
    }
}
