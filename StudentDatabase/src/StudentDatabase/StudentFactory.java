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
 *  StudentFactory handles a list of Student objects.
 *  Students have a list of Topics
 *  MedStudents have a list of awarded prizes
 *
 */
public class StudentFactory {
    // Variables
    protected ArrayList<Student> studentList = new ArrayList<>();
    protected String factoryName;

    // Constructor
    public StudentFactory(String newFactoryName){
        this.factoryName = newFactoryName;
    }

    // Public methods
    /**
     * Used to add a Student to the database, handles all degree types.
     * @param degreeType
     * The degree Student studies.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     * @param x
     * Information to pass to the create Student methods.
     * @param y
     * Information to pass to the create Student methods.
     */
    public void createStudent(String degreeType, int newStudentNum, String newFamilyName, String newGivenName,
                              String x, String y) {
        System.out.println("Inputting new student into database...");
        switch (degreeType) {
            case "A" -> this.createArtStudent(newStudentNum, newFamilyName, newGivenName, x, y);
            case "M" -> this.createMedStudent(newStudentNum, newFamilyName, newGivenName, x);
            case "S" -> this.createStemStudent(newStudentNum, newFamilyName, newGivenName);
            default -> System.out.println("Bad degree value"); /* TODO: properly react to incorrect inputs */
        }
    }

    /**
     * Overloaded methods to make the extra information input optional.
     * I program in Python I apologize for this.
     */
    public void createStudent(String degreeType, int newStudentNum, String newFamilyName, String newGivenName,
                              String x) {
        this.createStudent(degreeType, newStudentNum, newFamilyName, newGivenName, x, "");
    }
    public void createStudent(String degreeType, int newStudentNum, String newFamilyName, String newGivenName) {
        this.createStudent(degreeType, newStudentNum, newFamilyName, newGivenName, "", "");
    }

    /**
     * This method prints each student in the studentList's details to the console.
     * TODO: Print MedStudent prizes, Print ArtStudents major + minor
     */
    public void printStudents() {
        for (Student student : this.studentList) {
            student.printStudentDetails();
            student.printStudentTopicResults();
        }
    }

    // Private methods
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
    private void createArtStudent(int newStudentNum,
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
    private void createMedStudent(int newStudentNum,
                                 String newFamilyName,
                                 String newGivenName,
                                 String prizeName) {
        MedStudent newStudent = new MedStudent(newStudentNum, newFamilyName, newGivenName,
                                                "medicine", prizeName);
        this.studentList.add(newStudent);
    }

    /**
     * Creates a StemStudent and adds it to the database.
     * This is the most basic form of Student in regard to this database.
     * @param newStudentNum
     * Student Number for Identification
     * @param newFamilyName
     * Student last name.
     * @param newGivenName
     * Student first name(s).
     */
    private void createStemStudent(int newStudentNum,
                                  String newFamilyName,
                                  String newGivenName) {
        StemStudent newStudent = new StemStudent(newStudentNum, newFamilyName, newGivenName, "science");
        this.studentList.add(newStudent);
    }

}