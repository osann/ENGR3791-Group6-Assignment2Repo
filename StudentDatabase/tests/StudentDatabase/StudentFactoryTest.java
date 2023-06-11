package StudentDatabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    //this code creates a studentfactory object named myfactory

    StudentFactory studentFactory = new StudentFactory("MyFactory");

    @Test
    void createStudent() {

        //the createstudent test makes sure that student information can be created
        //and retrieved correctly using the studentfactory object

        studentFactory.createStudent(new String[]{"A", "555", "Aeternum", "Seeker", "Swordmaster", "Elementalist"});
        studentFactory.createStudent(new String[]{"M", "666", "Everfall", "Defender", "Golden Axe"});
        studentFactory.createStudent(new String[]{"M", "777", "First Light", "Healer"});
        studentFactory.createStudent(new String[]{"S", "888", "Brightwood", "Alchemist"});
        assertArrayEquals(new String[]{"555", "aeternum", "seeker", "art", "swordmaster", "elementalist"},
                studentFactory.returnStudentInformation(555));
        assertArrayEquals(new String[]{"666", "everfall", "defender", "medicine", "golden axe"},
                studentFactory.returnStudentInformation(666));
        assertArrayEquals(new String[]{"777", "first light", "healer", "medicine"},
                studentFactory.returnStudentInformation(777));
        assertArrayEquals(new String[]{"888", "brightwood", "alchemist", "science"},
                studentFactory.returnStudentInformation(888));

    }

    @Test
    void addTopicToStudent() throws Exception {

        //the addtopictostudent test checks if topics can be successfully
        //added to a student's profile using the studentFactory object
        //it makes sure that the topics are correctly added and can be
        //accessed when retrieving the student's information

        studentFactory.createStudent(new String[]{"A", "696", "Aeternum", "Seeker", "Swordmaster", "Elementalist"});

        studentFactory.addTopicToStudent(new String[]{"R", "696", "TEST1234", "HD", "90"});
        studentFactory.addTopicToStudent(new String[]{"R", "696", "TEST4321", "PS"});

        assertArrayEquals(new String[]{"TEST1234", "HD", "90"},
                studentFactory.returnStudentTopicInformation(696, "TEST1234"));
        assertArrayEquals(new String[]{"TEST4321", "PS"},
                studentFactory.returnStudentTopicInformation(696, "TEST4321"));

    }

    @Test
    void awardPrize() throws Exception {

        //the awardprize test checks if students are successfully given prizes by creating
        //student profiles, assigning a specific prize, and verifying that the prize is correctly
        //assigned to correct students while excluding the wrong ones

        studentFactory.createStudent(new String[]{"M", "443", "Beckham", "Alistair", "Expedition Master"});
        studentFactory.createStudent(new String[]{"M", "553", "Delaney", "Evelyn", "Archivist"});
        studentFactory.createStudent(new String[]{"A", "663", "Thornfield", "Nathaniel", "Alchemy", "Herbalism"});

        studentFactory.awardPrize(new String[]{"P", "BestAdventurer", "Champion", "1"});

        String[] student1Info = studentFactory.returnStudentInformation(443);
        String[] student2Info = studentFactory.returnStudentInformation(553);
        String[] student3Info = studentFactory.returnStudentInformation(663);
        assertEquals("bestadventurer", student1Info[4]);
        assertNull(student2Info[4]);
        assertNull(student3Info[4]);

    }

    @Test
    void addPrizeToStudent() throws Exception {

        //the addprizetostudent test verifies that a prize can be added to a student
        //it creates student profiles, adds a specific prize to a student
        //and checks if the prize is correctly assigned to the student

        studentFactory.createStudent(new String[]{"M", "7777777", "Beckham", "Alistair"});
        studentFactory.createStudent(new String[]{"M", "8888888", "Delaney", "Evelyn"});
        studentFactory.createStudent(new String[]{"A", "9999999", "Thornfield", "Nathaniel", "Alchemy", "Herbalism"});
        int studentNum = 7777777;
        String expectedPrizeName = "best adventurer";
        studentFactory.addPrizeToStudent(studentNum, expectedPrizeName);
        MedStudent s = studentFactory.returnMedStudent(studentNum);
        String actual = String.valueOf(s.returnPrizeList().get(0).getPrizeName());
        assertEquals(expectedPrizeName, actual);

    }

    @Test
    void printAllStudentsTopics() {

        //the printallstudentstopics test checks the correct printing of all students
        //topics by creating student profiles, capturing the output, and comparing it to the expected output.

        studentFactory.createStudent(new String[]{"A", "555", "Ezra", "Ashton", "Crafting", "Fishing"});
        studentFactory.createStudent(new String[]{"M", "666", "Luna", "Everly"});
        studentFactory.createStudent(new String[]{"S", "777", "Nova", "Raine"});
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        studentFactory.printAllStudentsTopics();
        String expectedOutput = """
        \n
        Student Number: 555
        Name: Ezra Ashton
        Degree: Crafting
        Minor: Fishing
        Topics:
            
        Student Number: 666
        Name: Luna Everly
        Degree: Medicine
        Topics:

        Student Number: 777
        Name: Nova Raine
        Degree: STEM
        Topics:
        """;
        assertEquals(expectedOutput, outputStream.toString());

    }

    @Test
    void returnStudent() {

        //the resturnstudent test creates a student profile and checks if the returned
        //student object has the expected attributes
        //like student number, family name and given name

        String[] inputs = {"A", "6868", "Winterfell", "Amara", "Shieldbearer", "Swordsmanship"};
        studentFactory.createStudent(inputs);
        Assertions.assertDoesNotThrow(() -> {
            Student student = studentFactory.returnStudent(6868);
            Assertions.assertNotNull(student);
            Assertions.assertEquals(6868, student.getStudentNum());
            Assertions.assertEquals("Winterfell", student.getFamilyName());
            Assertions.assertEquals("Amara", student.getGivenName());});

    }

    @Test
    void returnMedStudent() {

        //the returnmedstudent test creates a student profile for a potential medical student
        //and checks if the system correctly makes an exception when attempting to retrieve a medical student
        //it makes sure that the expected error message matches the actual error message

        String[] inputs = {"M", "2468", "Winterfell", "Amara", "MedPrize"};
        studentFactory.createStudent(inputs);
        Exception exception = Assertions.assertThrows(Exception.class,
                () -> studentFactory.returnMedStudent(2468));
        String expectedMessage = "Not a medical student.";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void returnArtStudent() {

        //the returnartstudent test creates an art student profile and verifies if
        //the returned student object has the expected attributes like
        //student number, family name, given name major

        String[] inputs = {"A", "7868", "Winterfell", "Amara", "ArtPainting"};
        studentFactory.createStudent(inputs);
        Assertions.assertDoesNotThrow(() -> {
            ArtStudent artStudent = studentFactory.returnArtStudent(7868);
            Assertions.assertNotNull(artStudent);
            Assertions.assertEquals(7868, artStudent.getStudentNum());
            Assertions.assertEquals("Winterfell", artStudent.getFamilyName());
            Assertions.assertEquals("Amara", artStudent.getGivenName());
            Assertions.assertEquals("ArtPainting", artStudent.getMajor());});

    }

    @Test
    void returnStudentInformation() {

        //the returnstudentinformation test makes sure that if the student information can be retrieved
        //correctly by creating a student profile with specific details and comparing
        //the retrieved information with the expected values

        String[] inputs = {"A", "1290", "EzPzEzPz", "John", "AxeMaster", "ShieldBearer"};
        studentFactory.createStudent(inputs);
        String[] studentInfo = studentFactory.returnStudentInformation(1290);
        Assertions.assertArrayEquals(inputs, studentInfo);

    }

    @Test
    void returnStudentTopicInformation() {

        //the returnstudenttopicinformation test makes sure that the students topic information can be
        //retrieved correctly by creating a student profile with the right details
        //retrieving the topic information for a given topic name
        //and making sure that the retrieved information matches the expected values

        String[] inputs = {"A", "4590", "xDxDxDxD", "Amara", "ArtPainting"};
        studentFactory.createStudent(inputs);
        String[] studentTopicInfo = studentFactory.returnStudentTopicInformation(4590, "ENG101");
        Assertions.assertNotNull(studentTopicInfo);
        Assertions.assertArrayEquals(new String[]{"ArtPainting", "ENG101", "Art History"}, studentTopicInfo);

    }
}