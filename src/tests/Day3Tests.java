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

    @Test
    void testResultWithExampleValueWith2Battery() {
        Bank bank = new Bank("987654321111111");
        Assertions.assertEquals(98, bank.getMaxJoltageValue(2));
        bank = new Bank("811111111111119");
        Assertions.assertEquals(89, bank.getMaxJoltageValue(2));
        bank = new Bank("234234234234278");
        Assertions.assertEquals(78, bank.getMaxJoltageValue(2));
        bank = new Bank("818181911112111");
        Assertions.assertEquals(92, bank.getMaxJoltageValue(2));
    }

    @Test
    void testResultWithExampleValueWith12Battery() {
        Bank bank = new Bank("987654321111111");
        Assertions.assertEquals(Long.parseLong("987654321111"), bank.getMaxJoltageValue(12));
        bank = new Bank("811111111111119");
        Assertions.assertEquals(Long.parseLong("811111111119"), bank.getMaxJoltageValue(12));
        bank = new Bank("234234234234278");
        Assertions.assertEquals(Long.parseLong("434234234278"), bank.getMaxJoltageValue(12));
        bank = new Bank("818181911112111");
        Assertions.assertEquals(Long.parseLong("888911112111"), bank.getMaxJoltageValue(12));
    }

    @Test
    void exampleFoundOnReddit() {
        Bank bank = new Bank("99999999993241");
        Assertions.assertEquals(Long.parseLong("999999999941"), bank.getMaxJoltageValue(12));
    }
}
