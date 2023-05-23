package StudentDatabase;

// Imports

// Authors: Jack Harris,

// Imports
import org.apache.commons.text.WordUtils;

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
