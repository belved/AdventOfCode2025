package daily;

import model.Day5.Ingredient;
import model.Day5.Range;
import model.Day5.RangeOrganizer;
import util.FileReader;
import util.MultipleStringList;

import java.util.ArrayList;
import java.util.List;

public class Day5 implements IDay{

    @Override
    public void displayResult() {

        MultipleStringList mString = FileReader.readDataAsMultipleStringList("ingredient");

        List<Range> ranges = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        int count = 0;

        for(String s : mString.getFirstList()) {
            ranges.add(new Range(s));
        }

        for(String s : mString.getSecondList()) {
            ingredients.add(new Ingredient(Long.parseLong(s)));
        }

        for (Ingredient i : ingredients) {
            if(i.isFreshFromListOfRange(ranges)) count++;
        }

        System.out.println("There are "+count+" fresh in the list");

        RangeOrganizer rangeOrganizer = new RangeOrganizer(ranges);

        rangeOrganizer.mergeRange();

        System.out.println("There are "+ rangeOrganizer.getFreshIdCount()+" fresh id in the list");


        /*
        Easy solution for part 2 but not working for big amount of data.
        Only left to keep trace of this solution
        Set<Long> ids = new HashSet<>();
        for(Range r: ranges) {
            ids.addAll(r.getAllId());
        }

        System.out.println("There is "+ids.size()+" fresh ids");
        */
    }
}
