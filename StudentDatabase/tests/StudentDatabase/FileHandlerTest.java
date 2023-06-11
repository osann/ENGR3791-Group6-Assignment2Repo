package StudentDatabase;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void inputFromFile()  {

        FileHandler fileHandler = new FileHandler(new StudentFactory("Example Academy"));
        String pathname = "StudentDatabase/src/StudentDatabase/TestInputLines.txt";
        assertDoesNotThrow(() -> fileHandler.inputFromFile(pathname));

    }

    @Test
    void writeToFile() {

        StudentFactory studentFactory = new StudentFactory("Example Academy");
        FileHandler fileHandler = new FileHandler(studentFactory);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        assertDoesNotThrow(() -> fileHandler.writeToFile(studentFactory));

        System.setOut(System.out);

        String output = outputStream.toString();
        assertNotNull(output);
        assertTrue(output.contains("Example Academy"), "Output does not contain the expected information.\nExpected: Example Academy\nActual: " + output);

    }
}