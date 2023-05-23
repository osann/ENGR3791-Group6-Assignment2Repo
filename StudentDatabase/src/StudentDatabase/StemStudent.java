package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

/**
 *  Represents a Student in a STEM degree.
 *  An extension of the Student class.
 *  Not entirely sure this ones necessary,
 */
public class StemStudent extends Student {
    public StemStudent(int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
    }
}
