package daily;

import model.Day4.PrintingPlace;
import util.FileReader;

import java.util.List;

public class Day4 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("paperRoll");

        PrintingPlace place = new PrintingPlace(data);

        System.out.println("There is " + place.getNumberOfPaperRollAccessible() + " that can be accessed by the forklift");
    }
}
