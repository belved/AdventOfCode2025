package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitExampleTestCase {

    @Test
    void testAddition() {
        int a = 5;
        int b = 6;
        Assertions.assertEquals(a+b, 11);
    }

    @Test
    void testDivision() {
        int a = 10;
        int b = 2;
        Assertions.assertEquals(a/b, 5);
    }
}
