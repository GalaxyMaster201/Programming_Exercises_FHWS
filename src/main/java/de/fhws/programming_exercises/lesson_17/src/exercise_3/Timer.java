package de.fhws.programming_exercises.lesson_17.src.exercise_3;

public class Timer extends Main{
    private long startTime;
    private long endTime;

    /**
     * (Re)Starts the timer
     */
    public void start(){
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
    }

    /**
     * Ends the timer and returns the elapsed time
     *
     * @return difference between end and start time
     */
    public long end(){
        this.endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    @Override
    public String toString(){
        return "Delta: " + (endTime - startTime) + "ms";
    }
}
