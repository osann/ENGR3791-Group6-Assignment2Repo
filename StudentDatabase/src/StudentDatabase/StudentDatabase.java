package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import java.util.ArrayList;

/**
 *  Database management system that maintains Student records.
 *  Students have a list of Topics
 *  MedStudents have a list of awarded prizes
 *
 */
public class StudentDatabase {
    // Variables
    protected ArrayList<Student> studentList = new ArrayList<>();

    // Constructor
    public StudentDatabase(){

    }

    // Class functions

    /**
     * Used to add a Student to the database, handles all degree types.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     * @param newDegree
     * The degree Student studies.
     * @param x
     * Information to pass to the create Student methods.
     * @param y
     * Information to pass to the create Student methods.
     */
    public void createStudent(int newStudentNum,
                           String newFamilyName,
                           String newGivenName,
                           String newDegree,
                           String x , String y) {
        switch (newDegree) {
            case "art" -> this.createArtStudent(newStudentNum, newFamilyName, newGivenName, x, y);
            case "medicine" -> this.createMedStudent(newStudentNum, newFamilyName, newGivenName, x);
            case "science" -> this.createStemStudent(newStudentNum, newFamilyName, newGivenName);
            default -> System.out.println("Bad newDegree value"); /* TODO: properly react to incorrect inputs */
        }
    }

    /**
     * Creates an ArtStudent instance with supplied information and adds to the database.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     * @param newMajor
     * Exclusive to ArtStudent's, a major of a degree.
     * @param newMinor
     * Exclusive to ArtStudent's, a minor of a degree.
     */
    public void createArtStudent(int newStudentNum,
                              String newFamilyName,
                              String newGivenName,
                              String newMajor,
                              String newMinor) {
        ArtStudent newStudent = new ArtStudent(newStudentNum, newFamilyName, newGivenName, "art",
                                                newMajor, newMinor);
        this.studentList.add(newStudent);
    }

    /**
     * Creates a MedStudent with supplied information and adds to the database.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     * @param prizeName
     * Exclusive to MedStudents, a Student can be created with a prize.
     */
    public void createMedStudent(int newStudentNum,
                                 String newFamilyName,
                                 String newGivenName,
                                 String prizeName) {
        MedStudent newStudent = new MedStudent(newStudentNum, newFamilyName, newGivenName,
                                                "medicine", prizeName);
        this.studentList.add(newStudent);
    }

    /**
     * Creates a StemStudent and adds it to the database.
     * This is the most basic form of Student in regards to this database.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     */
    public void createStemStudent(int newStudentNum,
                                  String newFamilyName,
                                  String newGivenName) {
        StemStudent newStudent = new StemStudent(newStudentNum, newFamilyName, newGivenName, "science");
        this.studentList.add(newStudent);
    }

}