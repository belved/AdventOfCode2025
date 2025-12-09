package daily;

import model.Day5.Ingredient;
import model.Day5.Range;
import util.FileReader;
import util.MultipleStringList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


        //part 2
        Set<Long> ids = new HashSet<>();
        for(Range r: ranges) {
            ids.addAll(r.getAllId());
        }

        System.out.println("There is "+ids.size()+" fresh ids");
    }
}
