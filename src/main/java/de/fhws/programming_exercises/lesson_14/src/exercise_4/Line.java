package de.fhws.programming_exercises.lesson_14.src.exercise_4;

public class Line{
    private int start;
    private int end;

    public Line(int start, int end){
        if (start < 0 || end < 0){
            throw new RuntimeException("The points have to be positive!");
        }
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    /**
     * Formats the output as [start]------[end]
     * @return formatted String representation
     */
    @Override
    public String toString(){
        String output = "";
        output += start;
        if (start != end){
            output += "-".repeat(end-start);
            output += end;
        }

        return output;
    }

    /**
     * Checks if this line intersects another line
     * @param ln2 line to check
     * @return true if lines intersect, false if not
     */
    public boolean doesIntersect(Line ln2){
        int start2 = ln2.getStart();
        int end2 = ln2.getEnd();

        // Line 2 is to the right
        if (start2 >= end){
            return false;
        }

        // Line 2 is to the left
        if (end2 <= start){
            return false;
        }

        return true;
    }
}
