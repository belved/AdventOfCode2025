package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class jUnitExampleTestCase {

    @Test
    void testAddition() {
        int a = 5;
        int b = 6;
        Assert.assertEquals(a+b, 11);
    }

    @Test
    void testDivision() {
        int a = 10;
        int b = 2;
        Assert.assertEquals(a/b, 5);
    }
}
