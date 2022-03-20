package de.fhws.programming_exercises.lesson_10.src.exercise2;

public class Clock{
    private int hours;
    private int minutes;
    private static int seconds;

    // ----------CONSTRUCTORS---------- //

    public Clock(int hours, int minutes, int seconds){
        if (checkTime(hours, minutes, seconds)){
            this.hours = hours;
            this.minutes = minutes;
            Clock.seconds = seconds;
        } else{
            this.hours = 12;
            this.minutes = 0;
            Clock.seconds = 0;
        }
    }

    // ----------GETTERS & SETTERS---------- //
    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public static int getSeconds(){
        return seconds;
    }

    public static void resetSeconds(){
        seconds = 0;
    }

    public void setClock(int hours, int minutes, int seconds){
        if (checkTime(hours, minutes, seconds)){
            this.hours = hours;
            this.minutes = minutes;
            Clock.seconds = seconds;
        } else{
            System.out.println("Your input is invalid, the time won't be changed");
        }
    }

    /**
     * Checks the time and corrects it if necessary, then writes it to a string
     * @return a string containing the formatted time
     */
    public String getTime(){
        correctTime();
        if (seconds == 60){
            return (String.format("%02d",hours)+":"+String.format("%02d",minutes)+":"+String.format("%02d",(0)));
        }else{
            return (String.format("%02d", hours)+":"+String.format("%02d", minutes)+":"+String.format("%02d", (seconds)));
        }
    }


    // ----------OTHER METHODS---------- //

    /**
     * Advances the time of all clocks by 1 second.
     */
    public static void nextSecond(){
        seconds++;
    }


    /**
     * Checks the validity of the time input
     *
     * @param h   hours
     * @param min minutes
     * @param sec seconds
     * @return boolean value saying if time is valid or not
     */
    private boolean checkTime(int h, int min, int sec){
        if (h < 0 || h > 24){
            return false;
        }
        if (min < 0 || min > 59){
            return false;
        }
        return sec >= 0 && sec <= 59;
    }

    /**
     * Corrects the time when passing onto a new minute/hour/day
     */
    private void correctTime(){
        if (seconds == 60){
            minutes ++;
        }
        if (minutes == 60){
            minutes = 0;
            hours++;
        }
        if (hours == 24){
            hours = 0;
        }
    }
}
