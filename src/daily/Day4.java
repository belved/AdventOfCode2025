package daily;

import model.Day4.PrintingPlace;
import util.FileReader;

import java.util.List;

public class Day4 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("paperRoll");

        PrintingPlace place = new PrintingPlace(data);

        int numberOfPaper = place.getNumberOfPaperRollAccessible();

        System.out.println("There is " + numberOfPaper + " that can be accessed by the forklift");

        int numberOfPaperRemoved;
        do {
            numberOfPaperRemoved = place.getNumberOfPaperRollAccessible();
            numberOfPaper+= numberOfPaperRemoved;
        }while (numberOfPaperRemoved != 0);

        System.out.println("There is " + numberOfPaper + " removed by the forklift");
    }
}
