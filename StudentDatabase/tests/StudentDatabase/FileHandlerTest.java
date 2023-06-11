package StudentDatabase;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void inputFromFile()  {

        try {
            String testInput = "Kaz Baz,25\nKirhy Zarzei,30";
            File tempFile = File.createTempFile("testInput", ".txt");
            Files.write(tempFile.toPath(), testInput.getBytes());
            FileHandler fileHandler = new FileHandler(new StudentFactory("Example Academy"));
            assertDoesNotThrow(() -> fileHandler.inputFromFile(tempFile.getAbsolutePath()));
            boolean deleteResult = tempFile.delete();
            if (!deleteResult) {
                System.err.println("Failed to delete the temporary file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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