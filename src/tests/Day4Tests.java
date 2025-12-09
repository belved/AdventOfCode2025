package tests;

import model.Day4.Location;
import model.Day4.PrintingPlace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day4Tests {

    @Test
    void testLocationObject() {
        Location location = new Location("@");
        Assertions.assertTrue(location.isPaperRoll());

        location = new Location(".");
        Assertions.assertFalse(location.isPaperRoll());
    }

    @Test
    void testSetMatrix() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.", "@@@.@.@.@@"));

        List<List<Location>> matrix = place.getMatrix();

        Assertions.assertEquals(2, matrix.size());
        Assertions.assertEquals(10, matrix.getFirst().size());
        Assertions.assertEquals(10, matrix.get(1).size());
    }

    @Test
    void testObjectInMatrix() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.", "@@@.@.@.@@"));

        List<List<Location>> matrix = place.getMatrix();

        Assertions.assertFalse(matrix.getFirst().getFirst().isPaperRoll());
        Assertions.assertFalse(matrix.getFirst().get(1).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(2).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(3).isPaperRoll());
        Assertions.assertFalse(matrix.getFirst().get(4).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(5).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(6).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(7).isPaperRoll());
        Assertions.assertTrue(matrix.getFirst().get(8).isPaperRoll());
        Assertions.assertFalse(matrix.getFirst().get(9).isPaperRoll());
    }

    @Test
    void testIfPaperRollIsAccessibleOnFirstLine() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.", "@@@.@.@.@@"));

        Assertions.assertTrue(place.checkIfAccessible(0, 2));
        Assertions.assertFalse(place.checkIfAccessible(0,7));
    }

    @Test
    void testIfPaperRollIsAccessibleOnLastLine() {
        PrintingPlace place = new PrintingPlace(List.of(".@@@@@@@@.", "@.@.@@@.@."));

        Assertions.assertTrue(place.checkIfAccessible(1, 0));
        Assertions.assertFalse(place.checkIfAccessible(0,4));
    }

    @Test
    void testIfPaperRollIsAccessibleOnFirstAndLastColumn() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.", "@@@.@.@.@@", "@@@@@.@.@@"));

        Assertions.assertTrue(place.checkIfAccessible(1, 0));
        Assertions.assertFalse(place.checkIfAccessible(1,9));
    }

    @Test
    void testIfPaperRollIsAccessibleForFullExample() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.","@@@.@.@.@@", "@@@@@.@.@@", "@.@@@@..@.", "@@.@@@@.@@", ".@@@@@@@.@", ".@.@.@.@@@", "@.@@@.@@@@",".@@@@@@@@.","@.@.@@@.@."));

        //First line
        Assertions.assertTrue(place.checkIfAccessible(0,2));
        Assertions.assertTrue(place.checkIfAccessible(0,3));
        Assertions.assertTrue(place.checkIfAccessible(0,5));
        Assertions.assertTrue(place.checkIfAccessible(0,6));
        Assertions.assertFalse(place.checkIfAccessible(0,7));
        Assertions.assertTrue(place.checkIfAccessible(0,8));

        //Second line
        Assertions.assertTrue(place.checkIfAccessible(1,0));
        Assertions.assertFalse(place.checkIfAccessible(1,1));
        Assertions.assertFalse(place.checkIfAccessible(1,2));
        Assertions.assertFalse(place.checkIfAccessible(1,4));
        Assertions.assertFalse(place.checkIfAccessible(1,6));
        Assertions.assertFalse(place.checkIfAccessible(1,8));
        Assertions.assertFalse(place.checkIfAccessible(1,9));

        //Third line
        Assertions.assertFalse(place.checkIfAccessible(2,0));
        Assertions.assertFalse(place.checkIfAccessible(2,1));
        Assertions.assertFalse(place.checkIfAccessible(2,2));
        Assertions.assertFalse(place.checkIfAccessible(2,3));
        Assertions.assertFalse(place.checkIfAccessible(2,4));
        Assertions.assertTrue(place.checkIfAccessible(2,6));
        Assertions.assertFalse(place.checkIfAccessible(2,8));
        Assertions.assertFalse(place.checkIfAccessible(2,9));

        //Fourth line
        Assertions.assertFalse(place.checkIfAccessible(3,0));
        Assertions.assertFalse(place.checkIfAccessible(3,2));
        Assertions.assertFalse(place.checkIfAccessible(3,3));
        Assertions.assertFalse(place.checkIfAccessible(3,4));
        Assertions.assertFalse(place.checkIfAccessible(3,5));
        Assertions.assertFalse(place.checkIfAccessible(3,8));

        //Fifth line
        Assertions.assertTrue(place.checkIfAccessible(4,0));
        Assertions.assertFalse(place.checkIfAccessible(4,1));
        Assertions.assertFalse(place.checkIfAccessible(4,3));
        Assertions.assertFalse(place.checkIfAccessible(4,4));
        Assertions.assertFalse(place.checkIfAccessible(4,5));
        Assertions.assertFalse(place.checkIfAccessible(4,6));
        Assertions.assertFalse(place.checkIfAccessible(4,8));
        Assertions.assertTrue(place.checkIfAccessible(4,9));

        //Sixth line
        Assertions.assertFalse(place.checkIfAccessible(5,1));
        Assertions.assertFalse(place.checkIfAccessible(5,2));
        Assertions.assertFalse(place.checkIfAccessible(5,3));
        Assertions.assertFalse(place.checkIfAccessible(5,4));
        Assertions.assertFalse(place.checkIfAccessible(5,5));
        Assertions.assertFalse(place.checkIfAccessible(5,6));
        Assertions.assertFalse(place.checkIfAccessible(5,7));
        Assertions.assertFalse(place.checkIfAccessible(5,9));

        //Seventh line
        Assertions.assertFalse(place.checkIfAccessible(6,1));
        Assertions.assertFalse(place.checkIfAccessible(6,3));
        Assertions.assertFalse(place.checkIfAccessible(6,5));
        Assertions.assertFalse(place.checkIfAccessible(6,7));
        Assertions.assertFalse(place.checkIfAccessible(6,8));
        Assertions.assertFalse(place.checkIfAccessible(6,9));

        //Eighth line
        Assertions.assertTrue(place.checkIfAccessible(7,0));
        Assertions.assertFalse(place.checkIfAccessible(7,2));
        Assertions.assertFalse(place.checkIfAccessible(7,3));
        Assertions.assertFalse(place.checkIfAccessible(7,4));
        Assertions.assertFalse(place.checkIfAccessible(7,6));
        Assertions.assertFalse(place.checkIfAccessible(7,7));
        Assertions.assertFalse(place.checkIfAccessible(7,8));
        Assertions.assertFalse(place.checkIfAccessible(7,9));

        //Ninth line
        Assertions.assertFalse(place.checkIfAccessible(8,1));
        Assertions.assertFalse(place.checkIfAccessible(8,2));
        Assertions.assertFalse(place.checkIfAccessible(8,3));
        Assertions.assertFalse(place.checkIfAccessible(8,4));
        Assertions.assertFalse(place.checkIfAccessible(8,5));
        Assertions.assertFalse(place.checkIfAccessible(8,6));
        Assertions.assertFalse(place.checkIfAccessible(8,7));
        Assertions.assertFalse(place.checkIfAccessible(8,8));

        //Tenth line
        Assertions.assertTrue(place.checkIfAccessible(9,0));
        Assertions.assertTrue(place.checkIfAccessible(9,2));
        Assertions.assertFalse(place.checkIfAccessible(9,4));
        Assertions.assertFalse(place.checkIfAccessible(9,5));
        Assertions.assertFalse(place.checkIfAccessible(9,6));
        Assertions.assertTrue(place.checkIfAccessible(0,8));
    }

    @Test
    void testGetNumberOfPaperRollAccessible() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.","@@@.@.@.@@", "@@@@@.@.@@", "@.@@@@..@.", "@@.@@@@.@@", ".@@@@@@@.@", ".@.@.@.@@@", "@.@@@.@@@@",".@@@@@@@@.","@.@.@@@.@."));

        Assertions.assertEquals(13, place.getNumberOfPaperRollAccessible());
    }

    @Test
    void testGetNumberOfPaperRollRemoved() {
        PrintingPlace place = new PrintingPlace(List.of("..@@.@@@@.","@@@.@.@.@@", "@@@@@.@.@@", "@.@@@@..@.", "@@.@@@@.@@", ".@@@@@@@.@", ".@.@.@.@@@", "@.@@@.@@@@",".@@@@@@@@.","@.@.@@@.@."));

        Assertions.assertEquals(13, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(12, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(7, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(5, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(2, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(1, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(1, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(1, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(1, place.getNumberOfPaperRollAccessible());
        Assertions.assertEquals(0, place.getNumberOfPaperRollAccessible());
    }
}
