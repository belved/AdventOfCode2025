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

    @Test
    void testReadFileAsString() {
        String string = FileReader.readDataAsString("giftShopIdExample");

        Assertions.assertEquals("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124", string);
    }
}
