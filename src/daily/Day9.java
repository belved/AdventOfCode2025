package daily;

import model.Day9.DistanceComputer;

import java.util.List;

public class Day9 implements IDay{
    
    @Override
    public void displayResult() {
        
        List<String> data =  util.FileReader.readDataAsListString("distance");

        DistanceComputer distanceComputer = new DistanceComputer(data);

        System.out.println("The size of the biggest square is " + distanceComputer.getBiggestDistance());
    }
}
