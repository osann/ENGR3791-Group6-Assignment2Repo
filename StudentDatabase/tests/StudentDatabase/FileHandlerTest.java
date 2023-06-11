package StudentDatabase;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FileHandlerTest {

    StudentFactory studentFactory = new StudentFactory("Some valid value");
    FileHandler fileHandler = new FileHandler(studentFactory);

    @Test
    void inputFromFile() {

        //the inputfromfile test verifies the functionality of reading student data from a file
        //it than creates a temporary file with sample data and writes the content to the file
        //and then calls the inputfromfile method to read and process the data

        try {
            File tempFile = File.createTempFile("player_data.txt", null);
            tempFile.deleteOnExit();
            String content = "S,1121314,Hyper,Venom,Swordsman\nS,9181716,Kaz,Baz,Archer";
            Files.writeString(tempFile.toPath(), content);
            fileHandler.inputFromFile(tempFile.getAbsolutePath());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

    }

    @Test
    void writeToFile() {

        //the writetofile test checks if the method properly writes student information to an output stream
        //it than sends the standard output to a print stream and calls the writetofile method
        //than, it captures the output in a string and compares it to the expected content

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        FileHandler fileHandler = new FileHandler(studentFactory);
        try {
            System.setOut(printStream);
            fileHandler.writeToFile(studentFactory);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        } finally {
            System.setOut(System.out);
        }
        String actualContent = outputStream.toString().trim();
        assertEquals("Expected content", actualContent);

    }
}