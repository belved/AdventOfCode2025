package model.Day4;

import java.util.ArrayList;
import java.util.List;

public class PrintingPlace {

    private final List<List<Location>> matrix = new ArrayList<>();

    public PrintingPlace(List<String> data) {
        for(String s: data) {
            setMatrixLine(s);
        }
    }

    public int getNumberOfPaperRollAccessible() {
        computeAccessibility();
        int temp = 0;
        for (List<Location> locations : matrix) {
            for (Location location : locations) {
                if (location.isAccessible()) temp++;
            }
        }
        return temp;
    }

    private void computeAccessibility() {
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(checkIfAccessible(i, j)) {
                    matrix.get(i).get(j).setAccessible(true);
                }
            }
        }
    }

    public boolean checkIfAccessible(int i, int j) {
        int sideCount = 0;

        //Checking top
        if(i > 0 && matrix.get(i-1).get(j).isPaperRoll()) {
            sideCount++;
        }
        //Checking bottom
        if(i < matrix.size()-1 && matrix.get(i+1).get(j).isPaperRoll()) {
            sideCount++;
        }

        //Checking left
        if(j > 0 && matrix.get(i).get(j-1).isPaperRoll()) {
            sideCount++;
        }

        //Checking right
        if(j < matrix.get(i).size()-1 && matrix.get(i).get(j+1).isPaperRoll()) {
            sideCount++;
        }

        //Checking Top Left
        if(i > 0 && j > 0 && matrix.get(i-1).get(j-1).isPaperRoll()) {
            sideCount++;
        }

        //Checking Top Right
        if(i > 0 && j < matrix.get(i).size()-1 && matrix.get(i-1).get(j+1).isPaperRoll()) {
            sideCount++;
        }

        //Checking Bottom Left
        if(i < matrix.size()-1 && j > 0 && matrix.get(i+1).get(j-1).isPaperRoll()) {
            sideCount++;
        }

        //Checking Bottom Right
        if(i < matrix.size()-1 && j < matrix.get(i).size()-1 && matrix.get(i+1).get(j+1).isPaperRoll()) {
            sideCount++;
        }
        return sideCount < 4;
    }

    private void setMatrixLine(String line) {
        List<Location> temp = new ArrayList<>();
        for(int i = 0; i < line.length(); i++) {
            temp.add(new Location(line.substring(i, i+1)));
        }
        matrix.add(temp);
    }

    public List<List<Location>> getMatrix() {
        return matrix;
    }
}
