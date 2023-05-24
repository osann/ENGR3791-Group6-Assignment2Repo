package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import org.apache.commons.text.WordUtils;

/**
 *  Represents a Student in a medicine degree.
 *  An extension of the Student class.
 *  Holds a list of awarded Prize's.
 */
public class MedStudent extends Student {
    // Variables
    protected String prize; // Needs to be an array of 10 Prize objects

    // Constructor
    public MedStudent (int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree,
                       String newPrize) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
        this.prize = newPrize;
    }

    // Class functions
    @Override
    public void printStudentDetails() {
        super.printStudentDetails();
        System.out.println("Prize:    " + WordUtils.capitalizeFully(prize));
    }

    // Getters/Setters

}
