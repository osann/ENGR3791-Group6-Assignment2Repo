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
    String[] functionTriggers = {"S", "M", "A", "R", "P"};

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
                this.nextLineFromFile(currentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method to initiate workflow through methods.
     * @param input
     * Input string.
     * @throws Exception
     * Throws exceptions:
     */
    private void nextLineFromFile(String[] input) throws Exception {
        this.validateInput(input);
    }

    private void validateInput(String[] input) throws Exception {
        for (String s : functionTriggers) {
            if (input[0].equals(s)) {
                this.decideFunction(input);
            }
        }
    }

    private void decideFunction(String[] input) throws Exception {
        if (input[0].equals("R")) {
            this.inputTopic(input);
        } else if (input[0].equals("P")) {
            this.inputPrize(input);
        } else {
            this.inputStudent(input);
        }
    }

    private void inputStudent(String[] input) {
        sFact.createStudent(input);
    }

    private void inputTopic(String[] input) throws Exception {
        sFact.addTopicToStudent(input);
    }

    private void inputPrize(String[] input) {
        // TODO: Input prize to Student

    }

}
