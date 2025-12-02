package daily;

import model.Day2.Range;
import util.FileReader;

public class Day2 implements IDay{

    @Override
    public void displayResult() {
        String value = FileReader.readDataAsString("giftShopId");

        Range range = new Range(value);

        System.out.println("The value of all the incorrect id is : " + range.getSumOfInvalidIdFromHalf());

        System.out.println("The value of all the incorrect id from everywhere is : "+range.getSumOfInvalidIdFromEverywhere());
    }
}
