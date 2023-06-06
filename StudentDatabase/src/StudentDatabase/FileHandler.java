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
import java.util.Scanner;

/**
 * Class to handle inputting Student information with a file.
 */
public class FileHandler {
    StudentFactory sFact = new StudentFactory("Factory");

    public FileHandler(StudentFactory studentFactory) {
        this.sFact = studentFactory;

    }

    /**
     * Adds Student information to the attached StudentFactory with a .txt file.
     * @param pathname
     * Path to the input file.
     * @throws Exception
     * Throws FileNotFound if no file exists.
     */
    public void inputFromFile(String pathname) throws Exception {
        try {
            Scanner scanner = new Scanner(new File(pathname));

            while (scanner.hasNextLine()) {
                String[] currentLine = (scanner.nextLine().split(","));
                sFact.createStudent(currentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
