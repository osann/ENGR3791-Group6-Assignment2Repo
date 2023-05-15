package StudentDatabase;

// Imports

// Authors: Jack Harris,

import org.apache.commons.text.WordUtils;

public class MedStudent extends Student {
    protected String prize;

    public MedStudent (int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree,
                       String newPrize) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
        this.prize = newPrize;
    }

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println("Prize:    " + WordUtils.capitalizeFully(prize));
    }
}
