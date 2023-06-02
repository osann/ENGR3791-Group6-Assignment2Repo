package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class to handle input and database of students.
 */
public class Database {
    // Variables
    static StudentFactory studentList = new StudentFactory("Example Academy");

    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(new File("StudentDatabase/src/StudentDatabase/TestInputLines.txt"));

            while (scanner.hasNextLine()) {
                String[] currentLine = (scanner.nextLine().split(","));
                studentList.createStudent(currentLine);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        studentList.printAllStudentsTopics();
        System.out.println(Arrays.toString(studentList.returnStudentInformation(9800123)));
        studentList.addTopicToStudent(new String[]{"9800123", "TEST1234", "PS"});
        System.out.println(Arrays.toString(studentList.returnStudentTopicInformation(9800123, "TEST1234")));

        studentList.printAllStudentsTopics();
    }

}
