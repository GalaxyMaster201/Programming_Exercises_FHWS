package de.fhws.programming_exercises.lesson_16.src.exercise_4;

public class Human extends AbstractBeing
        implements Driving{

    /**
     * Presents the human with a danger and makes him decide which action to take. The human in unsure in approx. 25% of cases.
     *
     * @param danger Type of danger presented to the human
     * @return human's reaction
     */
    @Override
    public CarDangerReaction choose(CarDanger danger){
        boolean unsure = Math.random() * 4 < 1;

        return unsure ?
                CarDangerReaction.UNDECIDED :
                switch (danger){
                    case DANGER_LEFT -> CarDangerReaction.GO_RIGHT;
                    case DANGER_RIGHT -> CarDangerReaction.GO_LEFT;
                    case DANGER_FRONT -> CarDangerReaction.BRAKE;
                };
    }
}
