package model.Day7;

import java.util.ArrayList;
import java.util.List;

public class Beam {

    private final String seed;
    private final List<List<Character>> grid = new ArrayList<>();
    
    private String path = "";
    private final int start;
    
    public Beam(String seed, List<List<Character>> grid, int start) {
        this.seed = seed;
        this.start = start;
        
        for(List<Character> row : grid) {
            List<Character> temp = new ArrayList<>(row);
            this.grid.add(temp);
        }
    }
    
    public String getSeed() {
        return seed;
    }

    public String getPath() {
        return path;
    }
    
    public List<List<Character>> getGrid() {
        return grid;
    }
    
    public boolean shouldGoLeft() {
        return seed.charAt(seed.length() - path.length()-1) == '0';
    }

    //TODO Consider memoization and maybe recursion ? 
    //TODO Maybe a good idea to keep position of the beam to avoid checking all the line (to combine with recursion)
    public void updatePath(int i, int j) {
        if(grid.get(i).get(j) == '^') {
            if(shouldGoLeft()) {
                grid.get(i).set(j-1, '|');
                path += "l";
            } else {
                grid.get(i).set(j+1, '|');
                path += "r";
            }
        } else {
            grid.get(i).set(j, '|');
        }
    }
    
    public void updatePathWithNoRecursion(int i, int j) {
        if(grid.get(i).get(j) == '^') {
            if(shouldGoLeft()) {
                grid.get(i).set(j-1, '|');
                path += "l";
            } else {
                grid.get(i).set(j+1, '|');
                path += "r";
            }
        } else {
            grid.get(i).set(j, '|');
        }
    }

    public void navigateThroughWithNoRecursion() {
        updatePathWithNoRecursion(1, start);

        for(int i = 1; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(i).size(); j++) {
                if(grid.get(i-1).get(j) == '|') {
                    updatePathWithNoRecursion(i, j);
                    j = grid.get(i).size();
                }
            }
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Beam) {
            return this.getPath().equals(((Beam) o).getPath());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getPath().hashCode();
    }
}
