package StudentDatabase;

// Imports

// Authors: Jack Harris,

import org.apache.commons.text.WordUtils;

public class ArtStudent extends Student {
    protected String major;
    protected String minor;

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

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println(
                "Major:    " + WordUtils.capitalizeFully(major) +
                "\nMinor:    " + WordUtils.capitalizeFully(minor));
    }
}

