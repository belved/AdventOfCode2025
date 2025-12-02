package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.FileReader;

import java.util.List;

public class FileReaderTest {

    @Test
    void testReadFileAsListString() {
        List<String> list = FileReader.readDataAsListString("lockExample");

        Assertions.assertEquals(10, list.size());
        Assertions.assertEquals("L68", list.getFirst());
        Assertions.assertEquals("L30", list.get(1));
        Assertions.assertEquals("R48", list.get(2));
        Assertions.assertEquals("L5", list.get(3));
        Assertions.assertEquals("R60", list.get(4));
        Assertions.assertEquals("L55", list.get(5));
        Assertions.assertEquals("L1", list.get(6));
        Assertions.assertEquals("L99", list.get(7));
        Assertions.assertEquals("R14", list.get(8));
        Assertions.assertEquals("L82", list.get(9));
    }
}
