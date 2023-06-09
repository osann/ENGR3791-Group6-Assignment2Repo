package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import java.io.*;
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

    /**
     * Creates a file "StudentDatabase.txt" and redirects printAllStudentsTopics() to write to file.
     * @param sFact
     * Pass the database information to write to file.
     * @throws FileNotFoundException
     * Shouldn't occur as the first step is createFile()
     */
    public void writeToFile(StudentFactory sFact) throws FileNotFoundException {
        File f = this.createFile();
        assert f != null;
        PrintStream stream = new PrintStream(f);
        System.setOut(stream);
        sFact.printAllStudentsTopics();
        System.setOut(System.out);
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
     */
    private void inputPrize(String[] input) throws Exception {
        sFact.awardPrize(input);
    }

    /**
     * Helper method that creates and returns a File object.
     * @return
     * Returns reference to created File.
     */
    private File createFile() {
        try {
            File f = new File("StudentDatabase.txt");
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }
            return f;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
