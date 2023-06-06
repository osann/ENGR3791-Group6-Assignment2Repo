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
 * Perhaps update this to be a class to read from file instead of a main method.S
 */
public class Database {
    // Variables
    static StudentFactory studentList = new StudentFactory("Example Academy");
    static FileHandler fHand = new FileHandler(studentList);

    public static void main(String[] args) throws Exception {
        String path = "StudentDatabase/src/StudentDatabase/TestInputLines.txt";

        fHand.inputFromFile(path);

        studentList.printAllStudentsTopics();

    }

}
