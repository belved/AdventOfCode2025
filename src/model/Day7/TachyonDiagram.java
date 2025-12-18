package model.Day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TachyonDiagram {
    
    private final List<String> data;
    private final List<List<Character>> grid = new ArrayList<>();
    
    private int count = 0;
    
    public TachyonDiagram(List<String> grid) {
        this.data = grid;
        
        for(String line : data) {
            List<Character> temp = new ArrayList<>();
            for(int i = 0; i < line.length(); i++) {
                temp.add(line.charAt(i));
            }
            this.grid.add(temp);
        }
    }
    
    public List<List<Character>> getGrid() {
        return grid;
    }
    
    public List<String> getData() {
        return data;
    }
    
    public int getStart() {
        return data.getFirst().indexOf("S");
    }
    
    public void setBeam(int i, int j) {
        if(data.get(i).charAt(j) == '^') {
            grid.get(i).set(j-1, '|');
            grid.get(i).set(j+1, '|');
        } else {
            grid.get(i).set(j, '|');
        }
    }
    
    public void navigateThrough() {
        setBeam(1, getStart());
        
        for(int i = 1; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(i).size(); j++) {
                if(grid.get(i-1).get(j) == '|') setBeam(i, j);
            }
        }
    }
    
    public void countNumberOfSplit() {
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(i).size(); j++) {
                if(grid.get(i).get(j) == '^' && grid.get(i-1).get(j) == '|') {
                    count ++;
                }
            }
        }
    }
    
    private final List<Beam> beams = new ArrayList<>();
    
    public void computeQuantumPath() {
        
        int length = (grid.size()/2)-1;
        
        for(int i = 0; i < Math.pow(2, length); i++) {
            String seed = String.format("%"+length+"s", Integer.toBinaryString(i)).replace(' ', '0');
            beams.add(new Beam(seed, getGrid(), getStart()));
        }
        
        for(Beam beam : beams) {
            beam.navigateThrough();
        }
    }
    
    public int getQuantumPathCount() {
        HashSet<Beam> temp = new HashSet<>(beams);
        return temp.size();
    }
    
    public int getCount() {
        countNumberOfSplit();
        return count;
    }
}
