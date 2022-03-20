package de.fhws.programming_exercises.lesson_12.src.exercise_1;

public class LottoSimulator{

    private static Number start;

    /**
     * Creates a linked list of numbers from 1 to 49
     */
    public static void createList(){
        start = new Number(1);
        Number cursor = start;
        for (int i = 2; i <= 49; i++){
            cursor.next = new Number(i);
            cursor = cursor.next;
        }
    }

    /**
     * Deletes the number from the list
     *
     * @param number the number to remove
     * @return the value of the removed number
     */
    public static int drawNumber(int number){
        Number leftCursor = start;
        Number rightCursor = start.next;

        if (leftCursor.next.getVal() == number){
            start = rightCursor;                    // the selected number is the first in the list
            return start.getVal();
        }

        while (rightCursor != null){
            if (rightCursor.getVal() == number){
                leftCursor.next = rightCursor.next;     // bypasses the number in the list, effectively removing it
                break;
            } else{
                leftCursor = rightCursor;               // moves forward in the list
                rightCursor = rightCursor.next;
            }
        }

        try{
            return rightCursor.getVal();
        } catch (NullPointerException e){     // the number has already been "drawn"
            return -1;
        }

    }

    /**
     * Draws six random non-repeating numbers between 1 and 49
     *
     * @return a Char array with 6 Integers
     */
    public static int[] draw6(){
        int[] results = new int[6];

        int counter = 0;
        while (counter < 6){
            int random = (int) (Math.random() * 49)+1;      // expand to [0,49), casting truncates, therefore +1
            int res = drawNumber(random);
            if (res != -1){
                results[counter] = res;
                counter++;                  // "conditional for-loop"
            }
        }
        return results;
    }
}
