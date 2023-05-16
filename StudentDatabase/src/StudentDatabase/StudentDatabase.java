package StudentDatabase;

// Imports

// Authors: Jack Harris,

public class StudentDatabase {
    public static void main (String[] args) {
        // Testing Students objects
        ArtStudent testArtStudent = new ArtStudent(0000000, "Family", "given Test", "Arts", "Major Test", "Minor Test");
        MedStudent testMedStudent = new MedStudent(0000001, "Medicine", "Test SubJECT", "Medicine", "Test Prize 1988");

        testArtStudent.printStudent();
        System.out.println();
        testMedStudent.printStudent();

        // Testing Topic objects
        Topic testTopic = new Topic("ABCD1234", "FL");
        System.out.println();
        testTopic.printTopicResults();

        Topic testTopic1 = new Topic("ZYXW0987", "HD", 95);
        System.out.println();
        testTopic1.printTopicResults();
    }
}