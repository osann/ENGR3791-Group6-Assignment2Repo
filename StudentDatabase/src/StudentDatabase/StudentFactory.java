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
     * Creates a Student object relevant to the input degree.
     * @param inputs
     * String array that contains information to input new student.
     * Order should follow: degreeType, studentNum, familyName, givenName
     * Followed by a prize for MedStudents or a major and minor for ArtsStudents
     */
    public void createStudent(String[] inputs) {
        System.out.println("Inputting new student into database...");
        switch (inputs[0]) {
            case "A" -> this.createArtStudent(Integer.parseInt(inputs[1]), inputs[2], inputs[3], inputs[4], inputs[5]);
            case "M" -> this.createMedStudent(Integer.parseInt(inputs[1]), inputs[2], inputs[3], inputs[4]);
            case "S" -> this.createStemStudent(Integer.parseInt(inputs[1]), inputs[2], inputs[3]);
            default -> System.out.println("Bad degree value"); /* TODO: properly react to incorrect inputs */

        }
        this.printAllStudentsTopics();
    }


    /**
     * Adds a Topic object to the specified Student object.
     * @param inputs
     * String array that contains information to identify a Student and topic information.
     * @throws Exception
     * Throws errors if specified studentNum doesn't match.
     */
    public void addTopicToStudent(String[] inputs) throws Exception {
        System.out.println("Adding topic to student record...");
        if (inputs.length == 5) {
            this.returnStudent(Integer.parseInt(inputs[1])).addTopicResults(inputs[2], inputs[3],
                    Integer.parseInt(inputs[4]));
            //System.out.println("in studentF have mark " + " [1] :" + inputs[1] + " [2] : " + inputs[2] + " [3] : " + inputs[3] + " [4] : " + inputs[4]);
        } else if (inputs.length == 4) {
            this.returnStudent(Integer.parseInt(inputs[1])).addTopicResults(inputs[2], inputs[3]);
            //System.out.println("In studentF no mark");
        }
    }

    /**
     * This method prints each student in the studentList's details to the console.
     * Student details are followed by associated topics.
     */
    public void printAllStudentsTopics() {
        for (Student student : this.studentList) {
            System.out.println();
            student.printStudentDetails();
            student.printStudentTopicResults();
        }
    }

    /**
     * Returns Student object if studentNum matches a Student in studentList.
     * Throws exception if studentNum isn't found.
     * @param studentNum
     * Which studentNum to match.
     * @return
     * Returns a Student.
     */
    public Student returnStudent(int studentNum) throws Exception {
        for (Student student : studentList) {
            if (student.getStudentNum() == studentNum) {
                return student;
            }
        }
        throw new Exception("studentNum does not match database");
    }

    /**
     * Returns an array with a students information dependent on the input studentNum.
     * Throws an exception if studentNum isn't found.
     * @param studentNum
     * Which studentNum to match.
     */
    public String[] returnStudentInformation(int studentNum) {
        String[] studentInfo = new String[4];

        try {
            studentInfo = this.returnStudent(studentNum).returnStudentInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }

    /**
     * Returns an array with a students specific topic information.
     * Throws an exception if studentNum or topicCode isn't found.
     * @param studentNum
     * Which studentNum to match.
     * @param topicCode
     * Which topicCode to match.
     * @return
     * Returns a String array with topicCode, grade and mark if there is one.
     */
    public String[] returnStudentTopicInformation(int studentNum, String topicCode) {
        String[] studentTopicInfo = new String[3];

        try {
            studentTopicInfo = this.returnStudent(studentNum).returnStudentTopicInformation(topicCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentTopicInfo;
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