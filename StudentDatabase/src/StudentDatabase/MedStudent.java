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
 *  Represents a Student in a medicine degree.
 *  An extension of the Student class.
 *  Holds a list of awarded Prize's.
 */
public class MedStudent extends Student {
    // Variables
    protected ArrayList<Prize> prizeList = new ArrayList<>();

    // Constructor
    public MedStudent (int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree,
                       String newPrize) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
        this.addPrize(newPrize);
    }

    /**
     * Overloaded constructor to create a MedStudent without a prize
     */
    public MedStudent (int newStudentNum,
                       String newFamilyName,
                       String newGivenName,
                       String newDegree) {
        super(newStudentNum, newFamilyName, newGivenName, newDegree);
    }

    // Class functions
    /**
     * Handles adding Prize objects to the Student's prizeList
     */
    public void addPrize(String prizeName) {
        Prize newPrize = new Prize(prizeName);
        this.prizeList.add(newPrize);
    }

    public void printMedStudentPrizes() {
        for (Prize prize : this.prizeList) {
            String prizeLine = "Prize:    " + prize.prizeName;
            System.out.println(prizeLine);
        }
    }

    @Override
    public void printStudentDetails() {
        super.printStudentDetails();
        this.printMedStudentPrizes();
    }

    public ArrayList<Prize> returnPrizeList() {
        return this.prizeList;
    }

    public String[] returnStudentInformation() {
        try {
            return new String[]{String.valueOf(this.studentNum), this.familyName, this.givenName, this.degree,
                    this.prizeList.get(0).getPrizeName()};
        } catch (IndexOutOfBoundsException e) {
            return super.returnStudentInformation();
        }
    }
}
