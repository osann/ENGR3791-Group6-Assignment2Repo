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
    // Variables
    StudentFactory sFact;
    String[] functionTriggers = {"S", "M", "A", "R", "P"};

    // Constructor
    public FileHandler(StudentFactory studentFactory) {
        this.sFact = studentFactory;
    }

    // Class methods
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

    // Private methods
    /**
     * Helper method to initiate workflow through methods.
     * @param input
     * Input Strings.
     * @throws Exception
     * Throws exceptions:
     */
    private void nextLineFromFile(String[] input) throws Exception {
        this.validateInput(input);
    }

    /**
     * Validates the input line from the file.
     * Basically makes sure the input has a line that triggers a function such as adding a Student.
     * @param input
     * Input Strings.
     * @throws Exception
     * Throws exceptions:
     */
    private void validateInput(String[] input) throws Exception {
        for (String s : functionTriggers) {
            if (input[0].equals(s)) {
                this.decideFunction(input);
            }
        }
    }

    /**
     * Decision maker for which method to execute in accordance to the input.
     * "R" will input a Topic, "P" will input a Prize, anything else MUST be either "S, M, A" which inputs a Student.
     * @param input
     * Input Strings
     * @throws Exception
     * Throws exceptions:
     */
    private void decideFunction(String[] input) throws Exception {
        if (input[0].equals("R")) {
            this.inputTopic(input);
        } else if (input[0].equals("P")) {
            this.inputPrize(input);
        } else {
            this.inputStudent(input);
        }
    }

    /**
     * Helper method to create a Student via the StudentFactory reference.
     */
    private void inputStudent(String[] input) {
        sFact.createStudent(input);
    }

    /**
     * Helper method to create a Topic for a Student via the StudentFactory reference.
     */
    private void inputTopic(String[] input) throws Exception {
        sFact.addTopicToStudent(input);
    }

    /**
     * Helper method to add a Prize to a Student via the StudentFactory reference.
     * TODO: Implement this.
     */
    private void inputPrize(String[] input) {

    }

}
