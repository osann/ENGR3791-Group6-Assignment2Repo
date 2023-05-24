package StudentDatabase;

// Imports

// Authors: Jack Harris,

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
        System.out.println();
        testArtStudent.printStudentTopicResults();
        testMedStudent.printStudentTopicResults();
    }
}