package ua.lviv.iot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WriterManagerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void writeCSV() {
        try (FileReader expectedReader = new FileReader("./src/test/resources/expected.csv");
                BufferedReader expectBR = new BufferedReader(expectedReader);
             FileReader actualReader = new FileReader("./src/test/resources/result.csv");
             BufferedReader actualBR = new BufferedReader(actualReader)) {
            String expectedLine = expectBR.readLine();
            String actualLine = actualBR.readLine();
            while(expectedLine != null && actualLine != null)
            {
                Assertions.assertEquals(expectedLine, actualLine);
                expectedLine = expectBR.readLine();
                actualLine = actualBR.readLine();
            }
            Assertions.assertNull(expectedLine);
            Assertions.assertNull(actualLine);
            expectedReader.close();
            actualReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}