package StudentDatabase;
import StudentDatabase.StudentFactory;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTests {
    private StudentFactory studentFactory;

    @Before
    public void setup() {
        studentFactory = new StudentFactory("Test Factory");
    }
        // the code initializes the test class studentfactorytests with a studentFactory object
        // the setup method sets up the studentfactory with the name yest factory before each test
    @Test
    public void testCreateStudent_ArtStudent() {
        String[] inputs = {"A", "123", "Kaz", "Baz", "Computer Science", "Mathematics"};

        studentFactory.createStudent(inputs);

        assertEquals(1, studentFactory.studentList.size());
        Student student = studentFactory.studentList.get(0);
        assertTrue(student instanceof ArtStudent);
        assertEquals(123, student.getStudentNum());
        assertEquals("Kaz", student.getFamilyName());
        assertEquals("Baz", student.getGivenName());
        ArtStudent artStudent = (ArtStudent) student;
        assertEquals("Computer Science", artStudent.getMajor());
        assertEquals("Mathematics", artStudent.getMinor());
    }
        // the code tests the createStudent method of the studentfactory class to create an artStudent
        // it verifies that the student is correctly created with the specified inputs
        // including the degree type, student number, name, major, and minor
    @Test
    public void testCreateStudent_MedStudent() {
        String[] inputs = {"M", "456", "Kaz", "Baz", "Nobel Prize"};

        studentFactory.createStudent(inputs);

        assertEquals(1, studentFactory.studentList.size());
        Student student = studentFactory.studentList.get(0);
        assertTrue(student instanceof MedStudent);
        assertEquals(456, student.getStudentNum());
        assertEquals("Kaz", student.getFamilyName());
        assertEquals("Baz", student.getGivenName());
        MedStudent medStudent = (MedStudent) student;
        ArrayList<Prize> l = medStudent.returnPrizeList();
        assertEquals("Nobel Prize", l.get(0).getPrizeName());
    }
        // the code tests the createstudent method of the studentfactory class to create a medstudent
        // it verifies that the student is correctly created with the specified inputs
        // including the degree type, student number, name, and prize name
    @Test
    public void testCreateStudent_StemStudent() {
        String[] inputs = {"S", "789", "Kaz", "Baz"};

        studentFactory.createStudent(inputs);

        assertEquals(1, studentFactory.studentList.size());
        Student student = studentFactory.studentList.get(0);
        assertTrue(student instanceof StemStudent);
        assertEquals(789, student.getStudentNum());
        assertEquals("Kaz", student.getFamilyName());
        assertEquals("Baz", student.getGivenName());
        StemStudent stemStudent = (StemStudent) student;
        assertEquals("science", stemStudent.getDegree());
    }
        // the code tests the creation of a stemstudent using the createstudent method of the studentfactory class
        // it verifies the students properties such as degree type, student number, name, and branch of study
    @Test
    public void testReturnStudentInformation() {

        String[] inputs1 = {"A", "111", "Kirhy", "Zarzei", "Physics", "Chemistry"};
        studentFactory.createStudent(inputs1);
        String[] inputs2 = {"M", "222", "Hyper", "Venom", "Turing Award"};
        studentFactory.createStudent(inputs2);
        String[] inputs3 = {"S", "333", "Kaz", "Baz"};
        studentFactory.createStudent(inputs3);
        String[] studentInfo = studentFactory.returnStudentInformation(222);
        assertArrayEquals(new String[]{"222", "Hyper", "Venom", "Gaming Award"}, studentInfo);
    }
        // the code tests the returnstudentinformation method of the studentfactory class
        // ot creates three students with different degree types and information
        // and then retrieves the information of a specific student
        // it asserts that the returned student information matches the expected values
}