package StudentDatabase;

// Imports
import org.apache.commons.text.*;

// Authors: Jack Harris,

import static java.lang.Character.toLowerCase;

public class Student {
    protected int studentNum;
    protected String familyName;
    protected String givenName;
    protected String degree;

    public Student() {

    }

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

    public void printStudent() {
        String fullName = WordUtils.capitalizeFully(givenName + " " + familyName);
        System.out.println("Academic Record For: " + fullName +
                "\nDegree:   " + WordUtils.capitalizeFully(degree));
    }

}

