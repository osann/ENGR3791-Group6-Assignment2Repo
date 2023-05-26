package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

/**
 *  Database management system that maintains Student and Prize objects.
 *  WIP
 */
public class StudentDatabase {
    public static void main (String[] args) {
        // Testing Students objects
        ArtStudent testArtStudent = new ArtStudent(0000000, "Family", "given Test", "Arts", "Major Test", "Minor Test");
        MedStudent testMedStudent = new MedStudent(0000001, "Medicine", "Test SubJECT", "Medicine", "Test Prize 1988");

        testArtStudent.printStudentDetails();
        System.out.println();
        testArtStudent.addTopicResults("TEST1234", "FL");
        testArtStudent.addTopicResults("TSET4321", "PS", 100);
        testMedStudent.addTopicResults("MMED8765", "HD", 5);
        testMedStudent.addPrize("pRIZE");
        System.out.println();
        testArtStudent.printStudentTopicResults();
        testMedStudent.printStudentTopicResults();
    }
}