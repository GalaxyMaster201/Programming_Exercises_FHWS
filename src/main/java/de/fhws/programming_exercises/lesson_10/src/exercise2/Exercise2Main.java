package de.fhws.programming_exercises.lesson_10.src.exercise2;

public class Exercise2Main{
    public static void main(String[] args) throws InterruptedException{
        Clock[] worldTime = new Clock[24];
        for (int i = 0; i < worldTime.length; i++){
            worldTime[i] = new Clock(i, 23, 7);
        }
        for (int i = 0; i < 200; i++){
            System.out.println("------------------------------------------");
            printTime(worldTime);               // prints the list of clocks
            if (Clock.getSeconds() == 60){      // reset seconds after printing
                Clock.resetSeconds();
            }
            Clock.nextSecond();     // advance all clocks by 1 second

            Thread.sleep(1000);
        }
    }

    /**
     * Prints time in a pseudo-UTC format
     *
     * @param worldTime array of all the clocks
     */
    private static void printTime(Clock[] worldTime){
        for (int i = 0; i < worldTime.length; i++){
            if (i < 12){
                System.out.println("UTC "+(i-12)+":00 \t-   "+worldTime[i].getTime());     // west of UTC
            } else{
                System.out.println("UTC +"+(i-12)+":00 \t-   "+worldTime[i].getTime());    // east of UTC
            }
        }
    }

}
