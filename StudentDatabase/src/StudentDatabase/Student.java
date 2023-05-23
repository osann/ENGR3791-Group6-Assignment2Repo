package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import org.apache.commons.text.WordUtils;
import java.util.ArrayList;

/**
 *  Represents a single Student.
 *  Holds studentNum, familyName, givenName, degree and a topicList.
 */
public class Student {

    // Variables
    protected int studentNum; // Maybe change this to StringBuilder or String?
    protected String familyName;
    protected String givenName;
    protected String degree;

    // Topic Variables
    ArrayList<Topic> topicList = new ArrayList<>();

    public Student() {
        // Throw an error?
        // Needed this for some reason

    }

    // Constructor
    public Student(
            int newStudentNum,
            String newFamilyName,
            String newGivenName,
            String newDegree) {

        this.studentNum = newStudentNum;
        this.familyName = newFamilyName.toLowerCase();
        this.givenName = newGivenName.toLowerCase();
        this.degree = newDegree.toLowerCase();
    }

    // Class functions
    public void printStudent() {
        String fullName = WordUtils.capitalizeFully(givenName + " " + familyName);
        System.out.println("Academic Record For: " + fullName +
                "\nDegree:   " + WordUtils.capitalizeFully(degree));
    }

    // Getters/Setters
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getStudentNum() {
        return studentNum;
    }

}

