package de.fhws.programming_exercises.lesson_12.src.exercise_1;

public class Exercise1Main{

    private static Number start = null;

    public static void main(String[] args){

        LottoSimulator.createList();

        arrayToList(LottoSimulator.draw6());

        printList();
    }

    /**
     * Turns an array into an ordered linked list
     *
     * @param array the input array
     */
    private static void arrayToList(int[] array){
        for (int j : array){
            insertNumber(j);
        }
    }

    /**
     * Inserts the specified number into the list at the correct position
     *
     * @param number number to add to the list
     */
    private static void insertNumber(int number){
        Number leftCursor = start;

        if (start == null || start.getVal() > number){      // check first list element
            start = new Number(number);
            start.next = leftCursor;
            return;
        }

        Number rightCursor = start.next;

        while (rightCursor != null){
            if (rightCursor.getVal() < number){
                leftCursor = rightCursor;                   // scroll forward in the list
                rightCursor = rightCursor.next;
            } else{
                Number newNumber = new Number(number);      // insert number in the list
                leftCursor.next = newNumber;
                newNumber.next = rightCursor;
                return;
            }
        }

        leftCursor.next = new Number(number);               // add new number to the end of the list
    }

    /**
     * Print all elements of the list
     */
    private static void printList(){
        Number cursor = start;
        System.out.println("Today's numbers are: ");
        while (cursor != null){
            System.out.printf("%d ", cursor.getVal());
            cursor = cursor.next;
        }
    }
}
