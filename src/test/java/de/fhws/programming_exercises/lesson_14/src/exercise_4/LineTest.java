package de.fhws.programming_exercises.lesson_14.src.exercise_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest{
    Line ln1 = new Line(5,10);
    Line ln2;

    /**
     * Check toString() for single point
     */
    @Test
    void testToStringSingle(){
        Line lns = new Line(5,5);
        assertEquals("5",lns.toString());
    }

    /**
     * Check toString() for standard line
     */
    @Test
    void testToStringStandard(){
        assertEquals("5-----10", ln1.toString());
    }

    /**
     * Negative value in constructor
     */
    @Test
    void negativePoint(){
        try{
            ln2=new Line(-1,10);
            fail("Expected Runtime Exception");
        }catch (RuntimeException e){
            assertEquals("The points have to be positive!",e.getMessage());
        }
    }

    /**
     * Check automatic switching of start and end
     */
    @Test
    void testSwitchStartEnd(){
        ln2 = new Line(10,1);
        assertTrue(ln2.getStart() < ln2.getEnd());
    }

    /**
     * Overlap on the left
     */
    @Test
    void testDoesIntersectLeft(){
        ln2 = new Line(1,8);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Overlap on the right
     */
    @Test
    void testDoesIntersectRight(){
        ln2 = new Line(8,15);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 in line 1
     */
    @Test
    void testDoesIntersectInner(){
        ln2 = new Line(7,8);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Line 1 in line 2
     */
    @Test
    void testDoesIntersectOuter(){
        ln2 = new Line(1,15);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 is a point on line 1
     */
    @Test
    void testDoesIntersectSingle(){
        ln2 = new Line(8,8);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 and line 1 are same
     */
    @Test
    void testDoesIntersectFull(){
        ln2 = new Line(5,10);
        assertTrue(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 end is line 1 start
     */
    @Test
    void testNotIntersectLeftTouch(){
        ln2 = new Line(1,5);
        assertFalse(ln1.doesIntersect(ln2));
    }

    /**
     * Line 1 end is line 2 start
     */
    @Test
    void testNotIntersectRightTouch(){
        ln2 = new Line(10,15);
        assertFalse(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 is to the left of line 1
     */
    @Test
    void testNotIntersectLeftNoTouch(){
        ln2 = new Line(1,4);
        assertFalse(ln1.doesIntersect(ln2));
    }

    /**
     * Line 2 is to the right of line 1
     */
    @Test
    void testNotIntersectRightNoTouch(){
        ln2 = new Line(11,15);
        assertFalse(ln1.doesIntersect(ln2));
    }
}