package StudentDatabase;

// Imports

// Authors: Jack Harris,

import org.apache.commons.text.WordUtils;

public class ArtStudent extends Student {

    // Variables
    protected String major;
    protected String minor;

    // Constructor
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

