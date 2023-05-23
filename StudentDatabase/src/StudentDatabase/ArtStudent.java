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
 *  Represents a Student in an Art degree.
 *  An extension of the Student class.
 *  Holds a major and minor variable.
 */
public class ArtStudent extends Student {

    // Variables
    protected String major;
    protected String minor;

    // Constructor
    //test

    public ArtStudent (int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree,
                       String newMajor,
                       String newMinor) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
        this.major = newMajor.toLowerCase();
        this.minor = newMinor.toLowerCase();
    }

    // Class functions
    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println(
                "Major:    " + WordUtils.capitalizeFully(major) +
                "\nMinor:    " + WordUtils.capitalizeFully(minor));
    }

    // Getters/Setters

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

