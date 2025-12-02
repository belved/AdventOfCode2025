package tests;

import model.Day1.Combination;
import model.Day1.Locker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Day1Tests {

    @Test
    void testGetRotationLeft() {
        Combination combination = new Combination("L85");
        Assertions.assertFalse(combination.getIsTurnRight());
    }

    @Test
    void testGetRotationRight() {
        Combination combination = new Combination("R85");
        Assertions.assertTrue(combination.getIsTurnRight());
    }

    @Test
    void testGetNumberOfRotation() {
        Combination combination = new Combination("L85");
        Assertions.assertEquals(85, combination.getNumberOfRotation());
    }

    @Test
    void testRotateLeft() {
        Combination combination = new Combination("L85");
        Assertions.assertEquals(-85, combination.rotate());
    }

    @Test
    void testRotateRight() {
        Combination combination = new Combination("R85");
        Assertions.assertEquals(85, combination.rotate());
    }

    @Test
    void testListCompletion() {
        Locker locker = new Locker(List.of("L34", "L54", "R32", "R89"));

        Assertions.assertEquals(4, locker.getCombinationList().size());
        Assertions.assertEquals(34, locker.getCombinationList().getFirst().getNumberOfRotation());
    }

    @Test
    void testUnlockWithValueR40() {
        Locker locker = new Locker(List.of("R40"));

        Assertions.assertEquals(90, locker.unlock());
    }

    @Test
    void testUnlockWithValueL40() {
        Locker locker = new Locker(List.of("L40"));

        Assertions.assertEquals(10, locker.unlock());
    }

    @Test
    void testUnlockWithValueL50() {
        Locker locker = new Locker(List.of("L50"));

        Assertions.assertEquals(0, locker.unlock());
    }

    @Test
    void testUnlockWithValueR50() {
        Locker locker = new Locker(List.of("R50"));

        Assertions.assertEquals(0, locker.unlock());
    }

    @Test
    void testUnlockWithValueL51() {
        Locker locker = new Locker(List.of("L51"));

        Assertions.assertEquals(99, locker.unlock());
    }

    @Test
    void testUnlockWithValueL350() {
        Locker locker = new Locker(List.of("L350"));

        Assertions.assertEquals(0, locker.unlock());
    }

    @Test
    void testUnlockWithValueR300() {
        Locker locker = new Locker(List.of("R300"));

        Assertions.assertEquals(50, locker.unlock());
    }

    @Test
    void testUnlockWithValueR99() {
        Locker locker = new Locker(List.of("R99"));

        Assertions.assertEquals(49, locker.unlock());
    }

    @Test
    void testUnlockWithValueL99() {
        Locker locker = new Locker(List.of("L99"));

        Assertions.assertEquals(51, locker.unlock());
    }

    @Test
    void testUnlockWithValueR100() {
        Locker locker = new Locker(List.of("R100"));

        Assertions.assertEquals(50, locker.unlock());
    }

    @Test
    void testUnlockWithValueL100() {
        Locker locker = new Locker(List.of("L100"));

        Assertions.assertEquals(50, locker.unlock());
    }

    @Test
    void testUnlockWithMultipleValue() {
        Locker locker = new Locker(List.of("L68", "L30", "R48"));

        Assertions.assertEquals(0, locker.unlock());
    }

    @Test
    void testNumberOfZero() {
        Locker locker = new Locker(List.of("L68", "L30", "R48"));

        locker.unlock();

        Assertions.assertEquals(1, locker.getNumberOfZero());
    }

    @Test
    void testNumberOfZeroWithExampleInput() {
        Locker locker = new Locker(Arrays.asList("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"));

        locker.unlock();

        Assertions.assertEquals(3, locker.getNumberOfZero());
    }

    @Test
    void testNumberOfZeroWithExampleInputPart2() {
        Locker locker = new Locker(Arrays.asList("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(6, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueL351WhenCountingPass() {
        Locker locker = new Locker(List.of("L351"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(4, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueR300WhenCountingPass() {
        Locker locker = new Locker(List.of("R300"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(3, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueR1000WhenCountingPass() {
        Locker locker = new Locker(List.of("R1000"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(10, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueAround0FromNegative() {
        Locker locker = new Locker(List.of("R50", "L1", "R1", "L1", "R1"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(3, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueAround0FromPositive() {
        Locker locker = new Locker(List.of("L50", "R1", "L1", "R1", "L1"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(3, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueL150() {
        Locker locker = new Locker(List.of("L50", "L100"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(2, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithValueR150() {
        Locker locker = new Locker(List.of("R50", "R100"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(2, locker.getNumberOfZero());
    }

    @Test
    void testUnlockWithHighValue() {
        Locker locker = new Locker(Arrays.asList("R50", "R600", "L600", "L50"));

        locker.countWhenPassingZero();

        Assertions.assertEquals(13, locker.getNumberOfZero());
    }
}