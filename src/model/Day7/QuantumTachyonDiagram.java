package model.Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantumTachyonDiagram {

    private final List<String> data;
    private final List<List<Character>> grid = new ArrayList<>();

    public QuantumTachyonDiagram(List<String> grid) {
        this.data = grid;

        for(String line : data) {
            List<Character> temp = new ArrayList<>();
            for(int i = 0; i < line.length(); i++) {
                temp.add(line.charAt(i));
            }
            this.grid.add(temp);
        }
    }

    public List<String> getData() {
        return data;
    }

    public int getStart() {
        return data.getFirst().indexOf("S");
    }
    
    private final Map<String, Long> memo = new HashMap<>();

    public long getPathCount(int x, int y) {
        if(memo.containsKey(x+"-"+y)) {
            return memo.get(x+"-"+y);
        }
        
        if(x >= data.size()-1) {
            return 1;
        }
        
        if(grid.get(x).get(y) == '^') {
            grid.get(x+1).set(y-1, '|');
            grid.get(x+1).set(y+1, '|');
            return getPathCount(x+1, y-1) + getPathCount(x+1, y+1);
        } else {
            grid.get(x).set(y, '|');
        }

        long count;
        
        count = getPathCount(x+1, y);
        memo.put(x+"-"+y, count);
        return count;
    }
}
