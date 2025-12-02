package tests;

import model.Day2.Id;
import model.Day2.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2Tests {

    @Test
    void testCorrectIdWithTwoNumber() {
        Id id = new Id("35");

        Assertions.assertTrue(id.isValidFromHalf());
    }

    @Test
    void testWrongIdWithTwoNumber() {
        Id id = new Id("33");

        Assertions.assertFalse(id.isValidFromHalf());
    }

    @Test
    void testWrongIdWithTwoNumberInAStringOfThree() {
        Id id = new Id("344");

        Assertions.assertTrue(id.isValidFromHalf());
    }

    @Test
    void testWrongIdOnExampleValue() {
        Id id = new Id("11");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("22");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("99");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("1010");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("1188511885");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("222222");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("446446");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("38593859");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("55");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("6464");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("123123");
        Assertions.assertFalse(id.isValidFromHalf());
        id = new Id("101");
        Assertions.assertTrue(id.isValidFromHalf());
    }

    @Test
    void testSetupRangeList() {
        Range range = new Range("11-22");
        Assertions.assertEquals(12, range.getIdRange().size());
    }

    @Test
    void testSetupRangeListFirstValue() {
        Range range = new Range("11-22");
        Assertions.assertEquals("11", range.getIdRange().getFirst().getValue());
    }

    @Test
    void testSetupRangeListLastValue() {
        Range range = new Range("11-22");
        Assertions.assertEquals("22", range.getIdRange().getLast().getValue());
    }

    @Test
    void testSetupRangeCreateGoodObjectInvalid() {
        Range range = new Range("11-22");
        Assertions.assertFalse(range.getIdRange().getFirst().isValidFromHalf());
    }

    @Test
    void testSetupRangeCreateGoodObjectValid() {
        Range range = new Range("11-22");
        Assertions.assertTrue(range.getIdRange().get(1).isValidFromHalf());
    }

    @Test
    void testgetSumOfInvalidIdFromHalf() {
        Range range = new Range("11-22");
        Assertions.assertEquals(33, range.getSumOfInvalidIdFromHalf());
    }

    @Test
    void testGetSumOfInvalidIdWithMultipleValues() {
        Range range = new Range("11-22,95-115");
        Assertions.assertEquals(132, range.getSumOfInvalidIdFromHalf());
    }

    @Test
    void testGetSumOfInvalidIdWithExampleValue() {
        Range range = new Range("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124");
        Assertions.assertEquals(1227775554, range.getSumOfInvalidIdFromHalf());
    }

    //Part 2

    @Test
    void testCorrectIdFromEverywhereWithTwoNumber() {
        Id id = new Id("35");

        Assertions.assertTrue(id.isValidFromEverywhere());
    }

    @Test
    void testWrongIdFromEverywhereWithTwoNumber() {
        Id id = new Id("33");

        Assertions.assertFalse(id.isValidFromEverywhere());
    }

    @Test
    void testWrongIdFromEverywhereWithTwoNumberInAStringOfThree() {
        Id id = new Id("13413");

        Assertions.assertTrue(id.isValidFromEverywhere());
    }

    @Test
    void testWrongIdFromEverywhereWith101() {
        Id id = new Id("101");

        Assertions.assertTrue(id.isValidFromEverywhere());
    }

    @Test
    void testWrongIdFromEverywhereWith110() {
        Id id = new Id("110");

        Assertions.assertTrue(id.isValidFromEverywhere());
    }

    @Test
    void testWrongIdFromEverywhereOnExampleValue() {
        Id id = new Id("11");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("22");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("99");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("111");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("999");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("1010");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("1188511885");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("222222");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("446446");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("38593859");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("55");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("6464");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("123123");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("101");
        Assertions.assertTrue(id.isValidFromEverywhere());
        id = new Id("565656");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("824824824");
        Assertions.assertFalse(id.isValidFromEverywhere());
        id = new Id("2121212121");
        Assertions.assertFalse(id.isValidFromEverywhere());
    }

    @Test
    void testSetupRangeCreateGoodObjectValidFromEverywhere() {
        Range range = new Range("11-22");
        Assertions.assertTrue(range.getIdRange().get(1).isValidFromEverywhere());
    }

    @Test
    void testgetSumOfInvalidIdFromHalfFromEverywhere() {
        Range range = new Range("11-22");
        Assertions.assertEquals(33, range.getSumOfInvalidIdFromEverywhere());
    }

    @Test
    void testGetSumOfInvalidIdWithMultipleValuesFromEverywhere() {
        Range range = new Range("11-22,95-115");
        Assertions.assertEquals(243, range.getSumOfInvalidIdFromEverywhere());
    }

    @Test
    void testGetSumOfInvalidIdWithEachExampleValueFromEverywhere() {
        Range range = new Range("11-22");
        Assertions.assertEquals(Long.parseLong("33"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("95-115");
        Assertions.assertEquals(Long.parseLong("210"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("998-1012");
        Assertions.assertEquals(Long.parseLong("2009"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("1188511880-1188511890");
        Assertions.assertEquals(Long.parseLong("1188511885"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("222220-222224");
        Assertions.assertEquals(Long.parseLong("222222"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("1698522-1698528");
        Assertions.assertEquals(0, range.getSumOfInvalidIdFromEverywhere());
        range = new Range("446443-446449");
        Assertions.assertEquals(Long.parseLong("446446"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("38593856-38593862");
        Assertions.assertEquals(Long.parseLong("38593859"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("565653-565659");
        Assertions.assertEquals(Long.parseLong("565656"), range.getSumOfInvalidIdFromEverywhere());
        range = new Range("824824821-824824827");
        Assertions.assertEquals(Long.parseLong("824824824"), range.getSumOfInvalidIdFromEverywhere());
    }

    @Test
    void testLastValueFromExample() {
        Range range = new Range("2121212118-2121212124");
        Assertions.assertEquals(Long.parseLong("2121212121"), range.getSumOfInvalidIdFromEverywhere());
    }

    @Test
    void testGetSumOfInvalidIdWithExampleValueFromEverywhere() {
        Range range = new Range("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124");
        Assertions.assertEquals(Long.parseLong("4174379265"), range.getSumOfInvalidIdFromEverywhere());
    }

}
