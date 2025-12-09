package tests;

import model.Day5.Ingredient;
import model.Day5.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Day5Tests {

    @Test
    void testSetupRangeListFirstValue() {
        Range range = new Range("3-5");
        Assertions.assertEquals(3, range.getStart());
    }

    @Test
    void testSetupRangeListLastValue() {
        Range range = new Range("3-5");
        Assertions.assertEquals(5, range.getEnd());
    }

    @Test
    void testSetupRangeListGetEveryId() {
        Range range = new Range("3-5");
        Assertions.assertEquals(3, range.getAllId().size());
        Assertions.assertEquals(3, range.getAllId().get(0));
        Assertions.assertEquals(4, range.getAllId().get(1));
        Assertions.assertEquals(5, range.getAllId().get(2));
    }

    @Test
    void testIngredientConstructor() {
        Ingredient ingredient = new Ingredient(5);

        Assertions.assertEquals(5, ingredient.id());
    }

    @Test
    void testIngredientIsfresh() {
        Ingredient ingredient = new Ingredient(5);

        Assertions.assertTrue(ingredient.isFresh(5, 10));
        Assertions.assertTrue(ingredient.isFresh(0, 5));
        Assertions.assertTrue(ingredient.isFresh(0, 10));
        Assertions.assertFalse(ingredient.isFresh(6, 10));
        Assertions.assertFalse(ingredient.isFresh(0,4));
    }

    @Test
    void testExample() {
        Range range = new Range("3-5");
        Ingredient ingredient = new Ingredient(1);
        Assertions.assertFalse(ingredient.isFresh(range.getStart(), range.getEnd()));

        ingredient = new Ingredient(5);
        Assertions.assertTrue(ingredient.isFresh(range.getStart(), range.getEnd()));
    }

    @Test
    void testFullExample() {
        List<Range> ranges = new ArrayList<>();
        ranges.add(new Range("3-5"));
        ranges.add(new Range("10-14"));
        ranges.add(new Range("16-20"));
        ranges.add(new Range("12-18"));

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(5));
        ingredients.add(new Ingredient(11));
        ingredients.add(new Ingredient(17));

        for(Ingredient i : ingredients) {
            Assertions.assertTrue(i.isFreshFromListOfRange(ranges));
        }

        ingredients.clear();
        ingredients.add(new Ingredient(1));
        ingredients.add(new Ingredient(8));
        ingredients.add(new Ingredient(32));

        for(Ingredient i : ingredients) {
            Assertions.assertFalse(i.isFreshFromListOfRange(ranges));
        }
    }
}
