package StudentDatabase;

// Imports
import org.apache.commons.text.WordUtils;

// Authors: Jack Harris,

public class StudentDatabase {
    public static void main (String[] args) {
        // Test objects
        ArtStudent testArtStudent = new ArtStudent(0000000, "Family", "given Test", "Arts", "Major Test", "Minor Test");
        MedStudent testMedStudent = new MedStudent(0000001, "Medicine", "Test SubJECT", "Medicine", "Test Prize 1988");

        testArtStudent.printStudent();
        System.out.println();
        testMedStudent.printStudent();
    }
}