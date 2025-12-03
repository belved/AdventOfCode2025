package tests;

import model.Day3.Bank;
import model.Day3.Battery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Tests {

    @Test
    void testJoltageCreationWithCorrectValue() {
        Battery battery = new Battery("5");

        Assertions.assertEquals(5, battery.getJoltage());
    }

    @Test
    void testJoltageCreationWithNegativeValue() {
        Battery battery = new Battery("-8");

        Assertions.assertEquals(-1, battery.getJoltage());
    }

    @Test
    void testJoltageCreationWithPositiveOver10Value() {
        Battery battery = new Battery("11");

        Assertions.assertEquals(-1, battery.getJoltage());
    }

    @Test
    void testJoltageCreationWithZeroValue() {
        Battery battery = new Battery("0");

        Assertions.assertEquals(-1, battery.getJoltage());
    }

    @Test
    void testBankInitializationWithExampleValue() {
        Bank bank = new Bank("987654321111111");

        Assertions.assertEquals(15, bank.getBatteryList().size());
    }

    @Test
    void testJoltageFromBankInitializationWithExampleValue() {
        Bank bank = new Bank("234234234234278");

        Assertions.assertEquals(2, bank.getBatteryList().get(0).getJoltage());
        Assertions.assertEquals(3, bank.getBatteryList().get(1).getJoltage());
        Assertions.assertEquals(4, bank.getBatteryList().get(2).getJoltage());
        Assertions.assertEquals(2, bank.getBatteryList().get(3).getJoltage());
        Assertions.assertEquals(3, bank.getBatteryList().get(4).getJoltage());
        Assertions.assertEquals(4, bank.getBatteryList().get(5).getJoltage());
        Assertions.assertEquals(2, bank.getBatteryList().get(6).getJoltage());
        Assertions.assertEquals(3, bank.getBatteryList().get(7).getJoltage());
        Assertions.assertEquals(4, bank.getBatteryList().get(8).getJoltage());
        Assertions.assertEquals(2, bank.getBatteryList().get(9).getJoltage());
        Assertions.assertEquals(3, bank.getBatteryList().get(10).getJoltage());
        Assertions.assertEquals(4, bank.getBatteryList().get(11).getJoltage());
        Assertions.assertEquals(2, bank.getBatteryList().get(12).getJoltage());
        Assertions.assertEquals(7, bank.getBatteryList().get(13).getJoltage());
        Assertions.assertEquals(8, bank.getBatteryList().get(14).getJoltage());
    }
}
